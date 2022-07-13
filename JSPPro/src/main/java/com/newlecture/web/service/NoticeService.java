package com.newlecture.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

public class NoticeService {
	
	public int removeNoticeAll(int[] ids) {
		return 0;
	}
	public int pubNoticeAll(int[] ids) {
		return 0;
	}
	
	public int insertNotice(Notice notice) {
		return 0;
	}
	public int deleteNotice(int id) {
		return 0;
	}
	
	public int updateNotice(Notice notice) {
		return 0;
	}
	
	List<Notice> getNoticeNewestList(){
		return null;
	}
	
	public List<NoticeView>	getNoticeList(){
		return  getNoticeList("TITLE","",1);
	}

	public List<NoticeView>	getNoticeList(int page){
		return getNoticeList("title","",page);
	}


	public List<NoticeView>	getNoticeList(String field,String query,int page){
		
		List<NoticeView> list = new ArrayList<>();
		
		String sql = "SELECT * FROM(" +
					"SELECT N.*,ROWNUM NUM FROM " +
					"(SELECT * FROM NOTICE_VIEW WHERE "+field+" LIKE ? ORDER BY REGDATE DESC) N)" +
					"WHERE ROWNUM BETWEEN ? AND ?";
		
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String uid = "NEWLEC";
			String pwd = "11111";
			Connection con = DriverManager.getConnection(url,uid, pwd);
			PreparedStatement st = con.prepareStatement(sql);
		
			st.setString(1, "%"+query+"%");
			st.setInt(2, 1+(page-1)*10);
			st.setInt(3, page*10);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()){
				int id = rs.getInt("id");
				String title = rs.getString("TITLE");
				Date regDate = rs.getDate("REGDATE");
				String writerId = rs.getString("WRITER_ID");
				String hit = rs.getString("HIT");
				//String content = rs.getString("CONTENT");
				int cmt = rs.getInt("CMT");
				NoticeView notice = new NoticeView(id,title,regDate,writerId,hit,cmt);
				list.add(notice);
			}
		  	rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int getNoticeCount() {
		return getNoticeCount("title","");
	}
	
	
	public int getNoticeCount(String field,String query) {
		
		int count =0;
		
		String sql = "SELECT COUNT(ID) COUNT FROM(" +
					"SELECT N.*,ROWNUM NUM FROM " +
					"(SELECT * FROM NOTICE WHERE "+field+" LIKE ? ORDER BY REGDATE DESC) N)";
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String uid = "NEWLEC";
			String pwd = "11111";
			Connection con = DriverManager.getConnection(url,uid, pwd);
			PreparedStatement st = con.prepareStatement(sql);
		
			st.setString(1, "%"+query+"%");
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("COUNT");
			}
		  	rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}
	
	public Notice getNotice(int id) {
		Notice notice =null;
		
		String sql = "SELECT * FROM NOTICE WHERE ID=? ";
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String uid = "NEWLEC";
			String pwd = "11111";
			Connection con = DriverManager.getConnection(url,uid, pwd);
			PreparedStatement st = con.prepareStatement(sql);
		
			st.setInt(1,id);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()){
				int nid = rs.getInt("id");
				String title = rs.getString("TITLE");
				Date regDate = rs.getDate("REGDATE");
				String writerId = rs.getString("WRITER_ID");
				String hit = rs.getString("HIT");
				String content = rs.getString("CONTENT");
				notice = new Notice(nid,title,regDate,writerId,hit,content);
			}
		  	rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return notice;
	}
	
	public Notice getNextNotice(int id) {
		Notice notice =null;
		String sql = "SELECT * FROM NOTICE" + 
					 "WHERE ID =(" +
					  " SELECT ID FROM NOTICE" +
					  " WHERE REGDATE > (SELECT REGDATE FROM NOTICE WHERE ID=?)" +
					  " AND ROWNUM =1)";
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String uid = "NEWLEC";
			String pwd = "11111";
			Connection con = DriverManager.getConnection(url,uid, pwd);
			PreparedStatement st = con.prepareStatement(sql);
		
			st.setInt(1,id);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()){
				int nid = rs.getInt("id");
				String title = rs.getString("TITLE");
				Date regDate = rs.getDate("REGDATE");
				String writerId = rs.getString("WRITER_ID");
				String hit = rs.getString("HIT");
				String content = rs.getString("CONTENT");
				notice = new Notice(nid,title,regDate,writerId,hit,content);
			}
		  	rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return notice;
	}
	
	public Notice getPrevNotice(int id) {
		Notice notice =null;
		String sql = "SELECT * FROM (SELECT * FROM NOTICE ORDER BY REGDATE DESC) " + 
					"WHERE ID =(" +
					" SELECT ID FROM NOTICE" +
					" WHERE REGDATE < (SELECT REGDATE FROM NOTICE WHERE ID=1)" +
					" AND ROWNUM =1)";
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String uid = "NEWLEC";
			String pwd = "11111";
			Connection con = DriverManager.getConnection(url,uid, pwd);
			PreparedStatement st = con.prepareStatement(sql);
		
			st.setInt(1,id);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()){
				int nid = rs.getInt("id");
				String title = rs.getString("TITLE");
				Date regDate = rs.getDate("REGDATE");
				String writerId = rs.getString("WRITER_ID");
				String hit = rs.getString("HIT");
				String content = rs.getString("CONTENT");
				int cmt = rs.getInt("CMT");
				notice = new Notice(nid,title,regDate,writerId,hit,content);
			}
		  	rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return notice;
	}
}

