//const url = "https://swapi.dev/api/planets/"
const url = "http://localhost:8080/"

/*************
let contentDiv = document.getElementById("content");
let planetNum = document.getElementById("planetNum"); 

async function getPlanet() {
  let planet = planetNum.value;
  
  let response = await fetch(url+planet);

  if(response.status===200){
    let data = await response.json();
    //console.log(data);
    console.log(data);
    let resident = {name: "no residents"};
    if(data.residents.length){
      let residentResp = await fetch(data.residents[0]);
      resident = await residentResp.json();
    }
    populatePage(data, resident);
  }else{
    console.log("error happened");
  }
}

function populatePage(data, resident){
  let name = document.createElement("h2");
  name.innerText = data.name
  let population = document.createElement("p");
  population.innerText = "population: "+data.population;
  let terrain = document.createElement("p");
  terrain.innerText = "terrain: "+data.terrain;
  let resName = document.createElement("p");
  resName.innerText = "First Resident: "+resident.name;


  contentDiv.appendChild(name); 
  contentDiv.appendChild(population);
  contentDiv.appendChild(terrain);
  contentDiv.appendChild(resName);
}


async function getFilms() {

  let result = await fetch("https://swapi.dev/api/films/");

  if(result.status===200){
    let films = await result.json();
    console.log(films);
    populateFilms(films);
  }else {
    console.log("Something went wrong"); 
  }
}

function populateFilms(films){
  //let filmsArray = films.results;
  for(let film of films.results){
    let filmTitle = document.createElement("h2");
    filmTitle.innerText = film.title;
    contentDiv.appendChild(filmTitle);
  }

  // for (let i = 0; i<films.results.length; i++){
  //   let filmTitle = document.createElement("h2");
  //   console.log(films);
  //   console.log(films.results);
  //   console.log(films.results[i]);
  //   filmTitle.innerText = films.results[i].title;
  //   contentDiv.appendChild(filmTitle);
  // }

  // let filmTitle0 = document.createElement("h2");
  // filmTitle0.innerText = films.results[0].title;
  // contentDiv.appendChild(filmTitle0);

  // let filmsArray = films.results;
  // let film0 = filmsArray[0];
  // let nameOfFilm = film0.title;
  // let filmTitle0 = document.createElement("h2");
  // filmTitle0.innerText = nameOfFilm;
  // contentDiv.appendChild(filmTitle0);
}

async function fakeinput(){
  let userFilm = "A New Hope";
  let somethingelse = await fetch("https://swapi.dev/api/films/");

  if(somethingelse.status===200){
    let films = await somethingelse.json();
    console.log(films);
    let singleFilm = {title: "no such film"};
    for(film of films.results){
      if(film.title == userFilm){
        singleFilm = film;
      }
    }
    populateFilm(singleFilm);
  }else {
    console.log("Something went wrong"); 
  }
}

function populateFilm(film){
  let filmTitle = document.createElement("h2");
  filmTitle.innerText = film.title;
  contentDiv.appendChild(filmTitle);
}

*****************/