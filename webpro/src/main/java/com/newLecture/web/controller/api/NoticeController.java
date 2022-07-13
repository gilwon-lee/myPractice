package com.newLecture.web.controller.api;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newLecture.web.entitiy.Notice;
import com.newLecture.web.service.NoticeService;


// @RestController -> RequestBody와 같은 

@RestController("apiNoticeController")
@RequestMapping("/api/notice/")
public class NoticeController {
	
	@Autowired
	private NoticeService service;
	
	//객체를 던지면 알아서 JSON 형식으로 바뀐다.
	@RequestMapping("list")
	public Notice list() throws ClassNotFoundException, SQLException {
		List<Notice> list = service.getList(1,"title", "");
		
		return list.get(0);
	}
}
