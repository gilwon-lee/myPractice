package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
@WebServlet("/calcpage")
public class CalcPage extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		out.write("<!DOCTYPE html>");
		
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("<style>");
		out.write("input{");
		out.write("width:50px;");
		out.write("height:50px;");
		out.write("}");
		out.write(".output{");
		out.write("	height:50px;");
		out.write("	background :#e9e9e9;");
		out.write("	font-size:24px;");
		out.write("	font-weight:bold;");
		out.write("	text-align :right;");
		out.write("padding: 0px 5px;");
		out.write("}");
		out.write("</style>");
		out.write("</head>");
		out.write("<body>");
		out.write("	<div>");
		out.write("		<form action=\"calc3\" method=\"post\">");
				out.write("			<table>");
				out.write("			<tr>");
				out.printf("				<td colspan=\"4\" class=\"output\">%d</td>",3+4);
				out.write("			</tr>");
						out.write("			<tr>");
						out.write("				<td><input type=\"submit\" name=\"operator\" value=\"CE\"></td>");
							out.write("					<td><input type=\"submit\" name=\"operator\" value=\"C\"></td>");
							out.write("					<td><input type=\"submit\" name=\"operator\" value=\"BS\"></td>");
							out.write("					<td><input type=\"submit\" name=\"operator\" value=\"÷\"></td>");
							out.write("				</tr>");
						out.write("				<tr>");
						out.write("			<td><input type=\"submit\" name=\"value\" value=\"7\"></td>");
						out.write("				<td><input type=\"submit\" name=\"value\" value=\"8\"></td>");
						out.write("				<td><input type=\"submit\" name=\"value\" value=\"9\"></td>");
						out.write("				<td><input type=\"submit\" name=\"operator\" value=\"X\"></td>");
						out.write("				</tr>");
						out.write("				<tr>");
						out.write("			<td><input type=\"submit\" name=\"value\" value=\"4\"></td>");
							out.write("				<td><input type=\"submit\" name=\"value\" value=\"5\"></td>");
							out.write("				<td><input type=\"submit\" name=\"value\" value=\"6\"></td>");
							out.write("			<td><input type=\"submit\" name=\"operator\" value=\"-\"></td>");
							out.write("			</tr>");
						out.write("			<tr>");
						out.write("<td><input type=\"submit\" name=\"value\" value=\"1\"></td>");
						out.write("<td><input type=\"submit\" name=\"value\" value=\"2\"></td>");
						out.write("<td><input type=\"submit\" name=\"value\" value=\"3\"></td>");
						out.write("<td><input type=\"submit\" name=\"operator\" value=\"+\"></td>");
						out.write("</tr>");
						out.write("<tr>");
						out.write("<td></td>");
						out.write("<td><input type=\"submit\" name=\"value\" value=\"0\"></td>");
						out.write("<td><input type=\"submit\" name=\"dot\" value=\".\"></td>");
						out.write("<td><input type=\"submit\" name=\"operator\" value=\"=\"></td>");
						out.write("</tr>");
					out.write("</table>");
					out.write("</form>");
				out.write("</div>");
			out.write("</body>");
		out.write("</html>");

	}
}
