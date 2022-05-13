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
//const age = parseInt(prompt("how old are you"));
// console.log(typeof age);
// console.log(age);
//isNaN() = 
// console.log(isNaN(age));

// 자바 스크립트 조건문 : 자바랑 비슷함
// if(condition){
//     code
// }else{
//}
// if(isNaN(age) || age<1){
//     console.log("Please write a number");
// }else if (0< age < 18){
//     console.log("you are too young");
// }else if(18<=age && age<=50){
//     console.log("you can drink");
// }else{
//     console.log("thanks!!");
// }

// const title = document.getElementById("title");
// title.innerText="got you";
// console.log(title.id);
// console.log(title.className);

// const hellos = document.getElementsByClassName("hello");
// console.log(hellos);
 
// const title = document.getElementsByTagName("h1");


// 첫번쨰 element만 가져옴
// const title = document.querySelector(".hello h1");

// n번쨰 가져오기
const title = document.querySelector(".hello h1:first-child");

// 전체 가져오기
// const title = document.querySelectorAll(".hello h1");

function handleTitleClick(){
    h1.style.color="red";
}

//  addEventListener : 이벤트 생성
h1.addEventListener("click",handleTitleClick);
console.dir(h1);

//html mdn(구글에서 검색) = html Element 확인

function handleMouseEnter(){
    h1.innerText = "Mouse is here!";
}
function handleMouseLeave(){
    h1.innerText = "Mouse is gone!";
}
// h1.onclick= handleTitleClick;
h1.addEventListener("mouseenter",handleMouseEnter);
h1.addEventListener("mouseleave",handleMouseLeave);

function handleWindowResize(){
    document.body.style.background="tomato";
}
function handleWindowCopy(){
    alert("copierd");
}
function handleWindowOffline(){
    alert("no WIFI");
}
function handleWindowOnline(){
    alert("WIFI ON");
}
// window.addEventListener("resize",handleWindowResize);
// window.addEventListener("copy",handleWindowCopy);
// window.addEventListener("offline",handleWindowOffline);
// window.addEventListener("online",handleWindowOnline);
//document.title,document.head,document.body 정도를 제외하고는 
//일반적으로 querySelector로 찾음
 
function handleMouseClick(){
    const currnetColor = h1.style.color;
    let newColor;
    if(currnetColor==="blue"){
        newColor="tomato";
    }else{
        newColor="blue";
    }
    h1.style.color = newColor;
}
// toggle로 대체 하는 방법
function handleTitleClick(){
    const clickedClass = "clicked"
    if(h1.classList.contains(clickedClass)){
        h1.classList.remove(clickedClass);
    }else{
        h1.classList.add(clickedClass);
    }
}
//toggle로 대체
function handleTitleClick(){
    h1.classList.toggle("clicked");
}


//220509
const loginForm = document.querySelector("#login-form");
const loginInput = loginForm.querySelector("input");
const loginButton = loginForm.querySelector("button");
const greeting = document.querySelector("#greeting");
const HIDDEN_CLASSNAME = "hidden";
const link = document.querySelector("a");
function loginClick(){
    const username = loginInput.value;
    if (username ===""){
        console.log("please write your id");
    } else if(username.length>10){
        console.log("your id is too long");
    }
}

//form 태그에서 넘어가는 정보를 onLoginSubmit() 함수에 info변수를 주어서 
//어떤 정보가 submit되는지 알 수 있음
/////////////////////////////////////////////////////////////////////////////////////////////
// SubmitEvent {isTrusted: true, submitter: button, type: 'submit', target: form#login-form, currentTarget: form#login-form, …}
// isTrusted: true
// bubbles: true
// cancelBubble: false
// cancelable: true
// composed: false
// currentTarget: null
// defaultPrevented: true
// eventPhase: 0
// path: (5) [form#login-form, body, html, document, Window]
// returnValue: false
// srcElement: form#login-form
// submitter: button
// target: form#login-form
// timeStamp: 1319.5
// type: "submit"
// [[Prototype]]: SubmitEvent
/////////////////////////////////////////////////////////////////////////////////////////////

function onLoginSubmit(event){
    // preventDefault() submit 새로고침을 막아주는 함수
    event.preventDefault();
    loginForm.classList.add(HIDDEN_CLASSNAME);
    const username = loginInput.value;
    console.log(username);
    localStorage.setItem(USERNAME_KEY,username);
    // greeting.innerText = "hello  " + username;
    paintGreetings(username);
}
function handleLinkClick(event){
    event.preventDefault();
    console.dir(event);
}
function paintGreetings(username){
    greeting.classList.remove(HIDDEN_CLASSNAME);
    greeting.innerText = `hello ${username}`;
}
// loginButton.addEventListener("click",loginClick);
// loginForm.addEventListener("submit",onLoginSubmit);
// link.addEventListener("click",handleLinkClick);


const savedUsername = localStorage.getItem(USERNAME_KEY);

if(savedUsername===null){
    //show the form
    loginForm.classList.remove(HIDDEN_CLASSNAME);
    loginForm.addEventListener("submit",onLoginSubmit);
}else{
    //show the greetings
    paintGreetings(savedUsername);
}



