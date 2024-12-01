package com.study.sBoard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.study.sBoard.dao.ISimpleBoardDao;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController {
	
	@Autowired
	ISimpleBoardDao dao;
	
	@GetMapping("/")
	public String root() throws Exception{
		// Jdbc Template : SimpleBBS
		return "redirect:list";
	}
	
	@GetMapping("/list")
	public String userlistPage(Model model) {
		model.addAttribute("list", dao.listDao());
		return "list";
	}
	
	@GetMapping("/view")
	public String view(HttpServletRequest request, Model model) {
		String sId = request.getParameter("id");
		model.addAttribute("dto", dao.viewDao(sId));
		return "view";
	}
	
	@GetMapping("/writeForm")
	public String writeForm() {
		return "writeForm";
	}
	
	@PostMapping("/write")
	public String write(Model model, HttpServletRequest request) {
		dao.writeDao(request.getParameter("writer"),
				request.getParameter("title"),
				request.getParameter("content"));
		return "redirect:list";
	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		dao.deleteDao(request.getParameter("id"));
		return "redirect:list";
	}
	
}
