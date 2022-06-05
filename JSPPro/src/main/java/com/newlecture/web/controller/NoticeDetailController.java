package com.newlecture.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;

@WebServlet("/notice/detail")
public class NoticeDetailController extends HttpServlet {
	
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "SELECT * FROM NOTICE WHERE ID=? ";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String uid = "NEWLEC";
			String pwd = "11111";
			Connection con = DriverManager.getConnection(url,uid, pwd);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			
			rs.next();
			Notice notice = new Notice();
			notice.setTitle(rs.getString("TITLE"));
			notice.setRegDate(rs.getDate("regDate"));
			notice.setWriterId(rs.getString("WRITER_ID"));
			notice.setHit(rs.getString("HIT"));
			notice.setContent(rs.getString("CONTENT"));
//			NTT(객체)
			request.setAttribute("n", notice);

			rs.close();
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.getRequestDispatcher("/WEB-INF/view/notice/detail.jsp")
		.forward(request, response);
		
	}
}
