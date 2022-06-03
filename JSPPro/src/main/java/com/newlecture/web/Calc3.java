package com.newlecture.web;

import java.io.IOException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
Application/Session/Cookie

Application : 전역 변수로 사용할 때,  생명주기 WAS, 저장위치 WAS서버의 메모리
Session : 세션 범위에 저장(접속자 마다 공간이 달라짐), 생명주기 세션, 저장위치 WAS서버의 메모리
Cookie : Web Browser(path범위에 범주를 바꿀 수 있음 setPath), 생명주기 만료시간까지(setMaxAge), 저장위치 Web의 메모리나 파일
*/

//annotation
@WebServlet("/calc3")
public class Calc3 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		어플리케이션 => 어플리케이션 전역에서 사용
//		세션 => 세션 범주내에서 사용
//		세션 = 현재 접속한 사용자(접속자 마다 공간이 달라짐)
		
//		ServletContext application = req.getServletContext();
//		HttpSession session = req.getSession();
		Cookie[] cookies = req.getCookies();

		String value =req.getParameter("value");
		String operator =req.getParameter("operator");
		String dot =req.getParameter("dot");
		
		String exp ="";
		
		if(cookies !=null) {
			for(Cookie c:cookies) 
				if(c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
		};		
		
		if(operator!=null && operator.equals("=")) {
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
			try {
				exp = String.valueOf(engine.eval(exp));
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(operator!=null && operator.equals("C")) {
			exp = "";
			
					
		}
		else {
			exp += (value==null)?"":value;
			exp += (operator==null)?"":operator;
			exp += (dot==null)?"":dot;
		}
		
		Cookie expCookie = new Cookie("exp",exp);
		 if(operator!=null && operator.equals("C")) {
				expCookie.setMaxAge(0);	
		}
		expCookie.setPath("/");
		resp.addCookie(expCookie);
		resp.sendRedirect("calcpage");
		}

}
