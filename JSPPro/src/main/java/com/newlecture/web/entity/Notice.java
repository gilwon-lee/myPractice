package com.newlecture.web.entity;

import java.util.Date;

public class Notice {
	private int id;
	private String title;
	private Date regDate;
	private String writerId;
	private String hit;
	private String content;
	
	public Notice() {
	}
	
	public Notice(int id, String title, Date regDate, String writerId, String hit, String content) {
		super();
		this.id = id;
		this.title = title;
		this.regDate = regDate;
		this.writerId = writerId;
		this.hit = hit;
		this.content = content;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getWriterId() {
		return writerId;
	}
	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
	public String getHit() {
		return hit;
	}
	public void setHit(String hit) {
		this.hit = hit;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	
	@Override
	public String toString() {
		return "Notice [id=" + id + ", title=" + title + ", regDate=" + regDate + ", writerId=" + writerId + ", hit="
				+ hit + ", content=" + content + "]";
	}
	
	
}
