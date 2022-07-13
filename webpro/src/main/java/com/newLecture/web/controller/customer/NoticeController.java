package com.newLecture.web.controller.customer;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newLecture.web.entitiy.Notice;
import com.newLecture.web.service.NoticeService;

@Controller
@RequestMapping("/customer/notice/")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("list")
	//p -> page 로 변환
	public String list(@RequestParam(defaultValue = "1",name ="p") int page) throws ClassNotFoundException, SQLException {
		//String p = request.getParameter("p");
		System.out.println(page);
		//List<Notice> list = noticeService.getList(1, "TITLE","");
		return "notice.list";
	}
	
	@RequestMapping("detail")
	public String detail() {
		return "notice.detail";
	}
	

}
