const toDoForm = document.getElementById("todo-form");
const toDoInput = toDoForm.querySelector("input");
const toDoList = document.getElementById("todo-list");

let toDos = [];
const TODOS_KEY ="todos";

// 로컬 저장소에 값을 저장하는 함수
function saveToDos(){
    localStorage.setItem("todos",JSON.stringify(toDos));
}
// 삭제 함수
function deleteToDo(event){
    const li = event.target.parentElement;
    li.remove();
    // toDos = toDos.filter((item) => item.id!==parseInt(li.id));
    toDos = toDos.filter(item=>myFilter(item,li));
    console.log(toDos);
    saveToDos();
}
// 삭제할 값의 필터 함수
function myFilter(item,li){
    return item.id !== parseInt(li.id)
}

// newToDo로 받은 항목을 웹페이지에 보여주는 함수 
function paintToDo(newToDo){
    const li =document.createElement("li");
    li.id =newToDo.id;
    const span = document.createElement("span");
    span.innerText=newToDo.text;
    const button = document.createElement("button");
    button.innerText="X";
    button.addEventListener("click",deleteToDo);
    li.appendChild(span);
    li.appendChild(button);
    toDoList.appendChild(li);
}

// submit 버튼 클릭 시 데이터 넘김 함수
function handleToDoSubmit(event){
    event.preventDefault();
    const newToDo =toDoInput.value;
    toDoInput.value="";
    const newToDoObj = {
        text : newToDo,
        id : Date.now(),
    }
    toDos.push(newToDoObj);
    paintToDo(newToDoObj);
    saveToDos();
}



toDoForm.addEventListener("submit",handleToDoSubmit);
const savedToDos = localStorage.getItem(TODOS_KEY);

if(savedToDos !==null){
    const parsedToDos = JSON.parse(savedToDos);
    toDos=parsedToDos;
    parsedToDos.forEach(paintToDo);
}
