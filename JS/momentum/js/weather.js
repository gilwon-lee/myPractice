
const apiId ="***";
function onGeoOk(position){
    const lat =position.coords.latitude;
    const lng =position.coords.longitude;
    const url = `https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lng}&appid=${apiId}&unit=metric`;
    console.log(lat,lng);
    fetch(url).
    then((response) => response.json()).
    then((data) =>{
            const weather = document.querySelector("#weather span:first-child");
            const city = document.querySelector("#weather span:last-child");
            city.innerText = data.name;
            weather.innerText = data.weather[0].main;
});
}
function onGeoError(){
    alert("can't find you");
}

navigator.geolocation.getCurrentPosition(onGeoOk,onGeoError);