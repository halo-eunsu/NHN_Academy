console.log("My name is " + "Marco");

let score = 68;
let result = score >= 60 ? "합격" : "불합격";
console.log(result);


function sayHello() {
    return "Hello, ";
}


function greeting(helloMessage, name) {

    if (typeof helloMessage == "function")
        console.log(helloMessage(), name);
    else {
        console.log(helloMessage, name);
    }
}

greeting(sayHello(), "brian!");
greeting("Hello2, " , "brian !")



