package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


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
		 
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		String v_ =req.getParameter("v");
		String op =req.getParameter("operator");
		
		int v =0;
		if(!v_.equals(""))
			v = Integer.parseInt(v_);
		if(op.equals("=")) {
//			int x = (Integer)application.getAttribute("value");
//			int x = (Integer)session.getAttribute("value");
			int x =0;
			for(Cookie c:cookies)
				if(c.getName().equals("value")) {
				x = Integer.parseInt(c.getValue());
				break;
				}
			int y = v;
			
//			String operator =(String)application.getAttribute("op");
//			String operator =(String)session.getAttribute("op");
			String operator ="";
			for(Cookie c:cookies) 
				if(c.getName().equals("op")) {
					operator = c.getValue();
					break;
				}
			
			int result = 0;
			if(operator.equals("+"))
				result=x+y;
			else	
				result=x-y;	
			out.println("result is "+result);
		}
		else {
		
//		application.setAttribute("value", v);
//		application.setAttribute("op", op);
		
//		session.setAttribute("value", v);
//		session.setAttribute("op", op);
		
		Cookie valueCookie = new Cookie("value",String.valueOf(v));
		Cookie opCookie = new Cookie("op",op);
//		쿠키를 특정 경로에서만 사용할 떄
		valueCookie.setPath("/calc");
		opCookie.setPath("/calc");
//		쿠기의 유지 시간 설정
		valueCookie.setMaxAge(24*60*60);
		resp.addCookie(valueCookie);
		resp.addCookie(opCookie);
		
		resp.sendRedirect("calc.html");
		}
		
		


	}
}
