package com.newLecture.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/")
public class HomeController{

	//@RequestMapping("index")
	/* @ResponseBody public void index(HttpServletResponse response) throws
	 * IOException{ PrintWriter out = response.getWriter();
	 * out.println("hello index"); // return "root.index"; }
	 */
	
	@RequestMapping("index")
	//@ResponseBody -> tiles,Annotation에서 패턴을 찾는 것이 아닌 아닌 
	//출력 자체를  할때 사용 (hello index라는 text 출력)
	@ResponseBody
	public String index() {
	return "hello index";
	}
	
//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		// TODO Auto-generated method stub
//		ModelAndView mv = new ModelAndView("root.index");
//		mv.addObject("data","Spring MVC");
//		mv.setViewName("/WEB-INF/view/index.jsp");
//		return mv;
//	}
}
