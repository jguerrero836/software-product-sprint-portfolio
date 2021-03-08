package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import java.util.ArrayList;



/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    //response.setContentType("text/html;");
    //response.getWriter().println("<h1>Hello world again!</h1>");

    String[] arr = {"hello", "bonjour", "hola"};
    ArrayList<String> arr_list = new ArrayList<String>();
    arr_list.add("hello");
    arr_list.add("hello2");
    arr_list.add("hello3");
    Gson gson = new Gson();
    String json = gson.toJson(arr_list);

    response.setContentType("application/json;");
    response.getWriter().println(json);

  }
  
}
