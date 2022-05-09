const clock = document.querySelector("#clock");

// clock.innerText = "clock";

//padStart(문자길이, 비어있는 장소를 채울 문자) -> 000123
//padEnd(문자길이, 비어있는 장소를 채울 문자) -> 123000
function getTime(){
    const date = new Date();
    const hours = String(date.getHours()).padStart(2,"0");
    const minutes = String(date.getMinutes()).padStart(2,"0");
    const seconds = String(date.getSeconds()).padStart(2,"0");
    clock.innerText = `${hours}:${minutes}:${seconds}`;
}

getTime()
// xx초 마다 실행
setInterval(getTime, 1000);

// xx초 후에 실행
//setTimeout(getTime,5000);
