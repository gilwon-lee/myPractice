/*eslint-disable */   //할당 안된 변수가 있습니다. 가 안나옴

import React,{useState} from 'react';
/*import logo from './logo.svg';*/
import './App.css';

function App() {

// destructuring
// [10,100]; 이 2개를 변수에 담기 위해서
// let [a,b] =[10,100];

//state 
// 1.변수 대신 쓰는 데이터 저장 공간
// 2.useState()를 이용하여 만들어야 함
// state HTML이 자동 렌더링이 가능함
let [글제목,글제목변경] = useState(['오늘의 점심','늦은 개발자 취업',
'SI업체란']);
let posts = '강남 고기 맛집';
//state 변경 방법 
let [따봉,따봉변경] = useState(0);
// state는 index로 접근 할 수가 없음
// 리액트는 immutable data , state는 직접 건드리면 안 된다.
// state Data는 아래와 방식으로 교체한다.
function 제목변경(){
	// let newArray = 글제목 -> 값 복사가 아닌 주소 복사 
	let newArray = [...글제목];
	newArray[0] = '여자코트 추천';
	글제목변경(newArray);
}

//return() 안에 <div>같은 태그는 여러개가 올 수 없다.
  return (
    <div className="App">
    	<div className="black-nav">
      		<div>블로그</div>
    	</div>
		<button onClick={제목변경}>버튼</button>
    	<div className="list">
			 {/* state 변경 방법   */}
    		<h4>{글제목[0]}<span onClick={()=>{따봉변경(따봉+1)}}>👍따봉</span>{따봉}</h4>
    		<p> 2월 17일 발행 </p>
    		<hr/>
			<h4>{글제목[1]}</h4>
    		<p> 2월 18일 발행 </p>
    		<hr/>
			<h4>{글제목[2]}</h4>
    		<p> 2월 19일 발행 </p>
    		<hr/>			
    	</div>
		<Model></Model>
    </div>
  );
}
// component:HTML을 한단어로 줄여서 쓸 수 있는 문법
// component는 대문자로 시작
// 반복 출현 하거나 자주 변경되는 HTML
// 다른페이지 만들 떄도 사용
function Model(){
	return(
		<div className='model'>
			<h2>제목</h2>
			<p>날짜</p>
			<p>상세내용</p>
		</div>
	)
}
function List(){
	return(
		<div>
			<h4>{글제목[2]}</h4>
			<p> 2월 19일 발행 </p>
			<hr/>
		</div>
	)
}

export default App;
