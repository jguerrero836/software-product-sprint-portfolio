// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
function addRandomGreeting() {
  const greetings =
      ['Hello world!', '¡Hola Mundo!', '你好，世界！', 'Bonjour le monde!'];

  // Pick a random greeting.
  const greeting = greetings[Math.floor(Math.random() * greetings.length)];

  // Add it to the page.
  const greetingContainer = document.getElementById('greeting-container');
  greetingContainer.innerText = greeting;
}

function addRandomFact() {
  const facts =
      ['My favorite food is pasta.', 
      'One place I really want to visit is Brazil.', 
      'I know a little bit of french from my highschool language classes.', 
      'One CS project I am very proud of is coding a sensor for my robotics team.'];

  // Pick a random greeting.
  const fact = facts[Math.floor(Math.random() * facts.length)];

  // Add it to the page.
  const factContainer = document.getElementById('greeting-container');
  factContainer.innerText = fact;
}

function addRandomPlantPicture() {
    const plant_pics = [
        "/images/seedling.jpg", "/images/garfield.jpeg",
        "/images/flowers.jpeg"
    ];

    const picture = plant_pics[Math.floor(Math.random() * plant_pics.length)];
    const picContainer = document.getElementById('plant_pic');
    document.getElementById('plant').src = picture;

}

async function serverHelloWorld() {
    const responseFromServer = await fetch('/hello');
    const textFromResponse = await responseFromServer.text();

    const greetingContainer = document.getElementById('greeting-container');
    greetingContainer.innerText = textFromResponse;
}
