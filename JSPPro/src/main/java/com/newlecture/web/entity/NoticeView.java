package com.newlecture.web.entity;

import java.util.Date;

public class NoticeView extends Notice {

	private int cmt;
	
	public NoticeView() {}
	public NoticeView(int nid, String title, Date regDate, String writerId, String hit, int cmt) {
		super(nid, title, regDate, writerId, hit,"");
		this.cmt =cmt;
	}
	
	public int getCmt() {
		return cmt;
	}
	public void setCmt(int cmt) {
		this.cmt = cmt;
	}
	

	
}
