const loginForm = document.querySelector("#login-form");
const loginInput = loginForm.querySelector("input");
const loginButton = loginForm.querySelector("button");
const greeting = document.querySelector("#greeting");
const HIDDEN_CLASSNAME = "hidden";
const USERNAME_KEY = "username";
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
