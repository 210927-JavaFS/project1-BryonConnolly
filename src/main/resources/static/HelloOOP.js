//DOM Selection

let value = document.getElementById("value");
let button = document.getElementById("button");

//classless object

let obj = {
  name:'tim',
  age:25,
  favoritePet: 'cat',
  speak: () => {console.log(obj.name+" says hi.");}
}
let counter = 0;

// button.addEventListener('click', ()=>{
//   if(counter==0){
//     counter++;
//     //DOM manipulation
//     value.innerText = obj.name;
//   }else if(counter==1){
//     counter++;
//     value.innerText = obj.age;
//   }else if(counter==2){
//     counter++;
//     value.innerText = obj.favoritePet;
//   }else {
//     counter=0;
//     obj.speak()
//     value.innerText = `${obj.name} spoke into the console`;
//   }
// })

//prototypical inheritance

let animal = {
  eats:true,
  move() {
    alert("I moved")
  }
}

let moose = {
  canadian: true,
  __proto__: animal
}

console.log(animal);
console.log(moose);

console.log(moose.canadian);
console.log(moose.eats);
moose.move();

//Class declarations

class Person {
  constructor(name, age){
    this.name = name;
    this.age = age; 
  }
}

let Tim = new Person("tim", 75);

button.addEventListener('click', ()=>{
  if(counter==0){
    counter++;
    //DOM manipulation
    value.innerText = Tim.name;
  }else if(counter==1){
    counter=0;
    value.innerText = Tim.age;
  }
})

console.log(Tim);

let Pet = class{
  constructor(name, type){
    this.name = name;
    this.type = type;
  }
}

let myCat = new Pet("Artemis", "cat");

console.log(myCat);