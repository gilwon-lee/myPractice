const canvas = document.getElementById("jsCanvas");

canvas.width =document.getElementsByClassName("canvas")[0].offsetWidth;
canvas.heigth=document.getElementsByClassName("canvas")[0].offsetHeight;

const colors =document.getElementsByClassName("jsColor");
const ctx = canvas.getContext("2d");
const range = document.getElementById("jsRange");
const mode = document.getElementById("jsMode");
const saveBtn = document.getElementById("jsSave");
const INITIAL_COLOR ="##2c2c2c";
const CANVAS_SIZE =700;

ctx.fillStyle = "white";
ctx.fillRect(0,0,CANVAS_SIZE,CANVAS_SIZE);
ctx.strokeStyle = INITIAL_COLOR;
ctx.fillStyle =INITIAL_COLOR;
ctx.lineWidth =2.5;

let painting = false;
let filling = false;

function startPainting(){
    painting = true;
}

function stopPainting(){
    painting=false;
}
function onMouseMove(event){
    const x =event.offsetX;
    const y =event.offsetY;
    if(!painting){
        //새로운 경로를 만듭니다. 경로가 생성됬다면, 
        //이후 그리기 명령들은 경로를 구성하고 만드는데 사용하게 됩니다.
        ctx.beginPath();
        //펜을  x와 y 로 지정된 좌표로 옮깁니다.
        ctx.moveTo(x,y);
    }else{
        //현재의 드로잉 위치에서 x와 y로 지정된 위치까지 선을 그립니다.
        ctx.lineTo(x,y);
        //윤곽선을 이용하여 도형을 그립니다.
        ctx.stroke();
    }
}
function onMouseDown(event){
    startPainting();
}
function onMouseUp(event){
    stopPainting();
}

function onMouseLeave(event){
    stopPainting();
}

function changeColor(event){
    console.log(event.target.style);
    const color = event.target.style.backgroundColor;
    ctx.strokeStyle =color;
    ctx.fillStyle =color;
}
function handleRangeChange(event){
    const size =event.target.value;
    ctx.lineWidth=size;
}
function handleMode(event){
    if(filling){
        filling = false;
        mode.innerText = "Fill";
    }else{
        filling = true;
        mode.innerText="paint";
        
    }
}
function handleCanvasClick(){
    if(filling){
        ctx.fillRect(0,0,CANVAS_SIZE,CANVAS_SIZE);
    }
}
function handleCM(event){
    event.preventDefault();
}
function handleSaveClick(){
    const image = canvas.toDataURL("image/jpeg");
    const link = document.createElement("a");
    link.href=image;
    link.download = "PaintJS";
    // link.innerText="저장됐어";
    link.click();
    // document.body.appendChild(link);
}
if(canvas){
    canvas.addEventListener("mousemove",onMouseMove);
    canvas.addEventListener("mousedown",onMouseDown);
    canvas.addEventListener("mouseup",onMouseUp);
    canvas.addEventListener("mouseleave",onMouseLeave);
    canvas.addEventListener("click",handleCanvasClick);
    canvas.addEventListener("contextmenu",handleCM);
}

// Array.from(colors) = 어레이 생성
Array.from(colors).forEach(color => color.addEventListener("click",changeColor))

if(range){
    range.addEventListener("input",handleRangeChange);
}

if(mode){
    mode.addEventListener("click",handleMode);
}
if(saveBtn){
    saveBtn.addEventListener("click",handleSaveClick);
}
