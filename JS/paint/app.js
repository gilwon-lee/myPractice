const canvas = document.getElementById("jsCanvas");
let painting = false;

function stopPainting(){
    painting=false;
}
function inMouseMove(event){
    const x =event.offsetX;
    const y =event.offsetY;
    console.log(x,y);
}
function OnMouseDown(event){
    painting = true;
}
function OnMouseUp(event){
    stopPainting();
}

function onMouseLeave(event){
    stopPainting();
}

if(canvas){
    canvas.addEventListener("mousemove",inMouseMove);
    canvas.addEventListener("mousedown",OnMouseDown);
    canvas.addEventListener("mouseup",OnMouseUp);
    canvas.addEventListener("mouseleave",onMouseLeave);
}