// JS 복습하기 

// const a = 5 ;
// const b = 2 ;
// let name = "lee";

// console.log(name);
// console.log(a+b);
// console.log(a*b);
// console.log(a/b);

// name = "gilwon";
// console.log(name);

// const dayOfWeek = ["mon","tue","wed","thu","fri","sat"];

// console.log(dayOfWeek[5]);

// // array 값 추가
// dayOfWeek.push("sun");


// console.log(dayOfWeek)

// const apple ="apple";
// const potato = "potato";

// const toBuy = ["apple","potato","pizze"];
// toBuy.push("kimbab");
// console.log(toBuy);


// const player = {
//     name : "lee",
//     points : 10,
//     fat:true,
// };

// console.log(player);
// console.log(player.name);
// console.log(player["name"]);

// player.fat =false;
// player.lastName = "potato";
// console.log(player);

// function sayHello(name,age){
//     console.log("hello my name is "+name+" i'm"+age+" years old");
// }
// sayHello("a",10);
// sayHello("b",15);
// sayHello("c",20);

// const player = {
//     name : "lee",
//     sayHello:function(otherPerson){
//         console.log("hello!"+otherPerson);
//     }
// }

// console.log(player.name);
// player.sayHello("lynn");

// function plus(a,b){
//     return console.log(a+b);
// }

// plus(10,20);
// function divide(a,b){
//     return console.log(a/b);
// }
// divide(10,3);

//1+1 1-1 a+b a-b  a/b a**b

// const calculator = {
//     add : function(a,b){
//         console.log(a+b);
//     },
//     minus : function(a,b){
//         console.log(a-b);
//     },
//     divide : function(a,b){
//         console.log(a/b);
//     },
//     powerof : function(a,b){
//         console.log(a**b);
//     }
// }
// calculator.add(1,2);
// calculator.minus(1,2);
// calculator.powerof(1,2);
// calculator.divide(1,2);
// const age = 96;
// function calculatorKrAge(ageOfForeigner){
//     return ageOfForeigner +2;
// }
// const krAge = calculatorKrAge(age);
// console.log(krAge);

//parseInt : type 변경함수
const age = parseInt(prompt("how old are you"));
// console.log(typeof age);
// console.log(age);
//isNaN() = 
// console.log(isNaN(age));

// 자바 스크립트 조건문 : 자바랑 비슷함
// if(condition){
//     code
// }else{
//}
if(isNaN(age)){
    console.log("Please write a number");
}else if (0< age < 18){
    console.log("you are too young");
}else{
    console.log("you can drink");
}

 









