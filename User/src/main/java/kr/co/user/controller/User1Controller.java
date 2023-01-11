package kr.co.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.user.service.User1Service;
import kr.co.user.vo.User1VO;

@Controller
@RequestMapping("/user1")
public class User1Controller {

	@Autowired
	private User1Service service;

	@GetMapping("/home")
	public String home() {
		System.out.println("도착");
		return "/home";
	}

	@GetMapping("/list")
	public String list(Model model) {
		List<User1VO> selectUser1s = service.selectUser1s();
		model.addAttribute("users", selectUser1s);
		return "/user1/list";
	}

	@GetMapping("/registerform")
	public String register() {
		return "/user1/register";
	}

	@PostMapping("/register")
	public String register(User1VO vo) {
		System.out.println("등록:"+vo);
		service.insertUser1(vo);
		return "redirect:/user1/list";
	}

	@GetMapping("/modify")
	public String modify() {
		return "/user1/modify";
	}

}