const api = "https://pokeapi.co/api/v2/pokemon/"

let dataSection = document.getElementById("data");
let button = document.getElementById("btn");

button.onclick = getPoke;

async function getPoke(){
  let userInput = document.getElementById("num").value

  let response = await fetch(api+userInput);

  if(response.status===200){
    let data = await response.json();
    populateData(data);
  }else {
    console.log("it got away!!!");
  }
}

function populateData(data) {
  let nameTag = document.createElement('h3');
  nameTag.innerText = data.name;

  let types = document.createElement('ol');
  let typeArr = data.types;

  types.innerHTML="<h4>Types</h4>"

  for(let type of typeArr){
    let li = document.createElement('li');
    li.innerText = type.type.name;
    types.appendChild(li);
  }

  let abilities = document.createElement('ul');
  let abilArr = data.abilities;

  abilities.innerHTML="<h4>Abilities</h4>";

  for(ability of abilArr){
    let li = document.createElement('li');
    li.innerText = ability.ability.name;
    abilities.appendChild(li);
  }

  let sprite = document.createElement('img');
  sprite.setAttribute('src', data.sprites.front_default);

  dataSection.appendChild(nameTag)
  dataSection.appendChild(types)
  dataSection.appendChild(abilities)
  dataSection.appendChild(sprite)
}