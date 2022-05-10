const images = [
    "0.jpg","1.jpg","2.jpg","3.jpg","4.jpg"
];
const todayImage = images[Math.floor(Math.random()*images.length)];

const bgImage = document.createElement("img");

bgImage.src = `img/${todayImage}`;

//append -> html 제일 끝에 추가
//prepend -> html 제일 앞에 추가
document.body.appendChild(bgImage);





