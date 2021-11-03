console.log("Hello World!");

var a = 100 //note the interpreter/JIT will insert the ; for you in most circumstances. 
console.log('Var a: '+a+" is of type: "+typeof a);

a = "100";
console.log('Var a: '+a+" is of type: "+typeof a);

a = true;
console.log('Var a: '+a+" is of type: "+typeof a);

a=null;
console.log('Var a: '+a+" is of type: "+typeof a);

a=25/0;
console.log('Var a: '+a+" is of type: "+typeof a);

var b;
console.log('Var b: '+b+" is of type: "+typeof b);

c = "I am undeclared";
console.log('Var c: '+c+" is of type: "+typeof c);

console.log("=====================================================")

function coercionTest(inp1, inp2){ //This is a named function.
  console.log("=====================================================")
  console.log('The first input is '+inp1+' which is of type: '+typeof inp1);
  console.log('The second input is '+inp2+' which is of type: '+typeof inp2);
  console.log('Coercion shows them as '+((inp1==inp2)?'the same':'different'));
}

coercionTest(3, 3);
coercionTest(3, 4);

coercionTest('3', 3); //same
coercionTest(false, 'false'); //different
coercionTest(0, false); //same
coercionTest(1, true); //same
coercionTest(2, true); //different
coercionTest('true', true); //different
coercionTest('1', true); //same
coercionTest(false, ''); //same
coercionTest('null', null); //different
coercionTest(null, null); //same
coercionTest(null, undefined); //same
coercionTest({}, {}); //different
coercionTest([], []); //different 
coercionTest([], {}); //different
coercionTest(NaN, NaN); //different


// Hoisting in brief
console.log(d);
var d = "I'm var d";

// console.log(e);
let e = "I'm var e";

console.log("===============Truthy/Falsy================")

var truthTest = function(inp1){ //This is an anonymous function stored in the truthTest variable. 
  console.log("==============================")
  if(inp1){
    console.log(inp1 + ' of type '+typeof inp1+" is truthy");
  }else{
    console.log(inp1 + ' of type '+typeof inp1+" is falsy");
  }
}

truthTest(true);
truthTest(false);

truthTest(0); //f
truthTest(1); //t
truthTest("0"); //t
truthTest(null); //f
truthTest(-1); //t
truthTest(undefined); //f
truthTest(''); //f
truthTest(2-'3'); //t
truthTest(3.5 * "b"); //f
truthTest(' '); //t
truthTest([]) //t
truthTest({}) //t
truthTest([]+[]); //f []+[] = ''

console.log("===============Arrow Function/Callback Functions================")

var arrow = () => {return "From the arrow function";}

console.log(arrow())

function callAFunc(inp1){
  var str = "I'm a string from the outer function";
  inp1(str);
}

callAFunc((s)=>{console.log(s)});

console.log("===============Closure================")

function addX(x){
  var operand = x;
  return function(y){
    return operand+y;
  }
}

var add5 = addX(5);

console.log(add5(10));

addX = addX(7);

console.log(addX(9));