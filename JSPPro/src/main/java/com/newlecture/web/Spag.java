package com.newlecture.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/spag")
public class Spag extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		int num = 0; 
		String num_ =request.getParameter("n");
		String result ="";
		if(num_ !=null && !num_.equals("")){
			 num = Integer.parseInt(num_); 
		}
		if(num%2==1){ 
			result="홀수";
		}
		else{
			result="짝수";

		result="홀수";
		}
		
		request.setAttribute("result", result);
		
		String[] names = {"newlec","lee"};
		request.setAttribute("names", names);
		
		Map<String, Object> notice = new HashMap<String, Object>();
		notice.put("id", 1);
		notice.put("title", "EL표기");
		request.setAttribute("notice", notice);
		//forward

		RequestDispatcher dispatcher = request.getRequestDispatcher("spaghetti.jsp");
		dispatcher.forward(request, resp);
		
	}
}
