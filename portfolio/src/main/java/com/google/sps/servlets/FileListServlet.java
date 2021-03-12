package com.google.sps.servlets;

import com.google.api.gax.paging.Page;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

/** Shows all of the images uploaded to Cloud Storage. */
@WebServlet("/list-images")
public class FileListServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // List all of the uploaded files.
    String projectId = "jguerrero-sps-spring21";
    String bucketName = "jguerrero-sps-spring21.appspot.com";
    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
    Bucket bucket = storage.get(bucketName);
    Page<Blob> blobs = bucket.list();

    // Output <img> elements as HTML.
    response.setContentType("application/json;");
    Gson gson = new Gson();
    for (Blob blob : blobs.iterateAll()) {
      String imgTag = blob.getName();
      String json = gson.toJson(imgTag);
      response.getWriter().println(json);
    }
  }
}