package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

//annotation
@WebServlet("/notice-reg")
public class Notice_reg extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		resp.setCharacterEncoding("UTF-8");
//		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		String title =req.getParameter("title");
		String content =req.getParameter("content");
		System.out.println(title);
		out.println("제목:"+title);
		out.println("내용:"+content);

	}
}
