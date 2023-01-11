package kr.co.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.book.service.CustomerService;
import kr.co.book.vo.CustomerVo;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/customer/list")
	public String list(Model model) {
		//ModelAndView mv = new ModelAndView();
		List<CustomerVo> list = customerService.cuslist();
		//mv.addObject("list", list);
		//mv.setViewName("/customer/list");
		model.addAttribute("list",list);
		return "/customer/list";
	}

	@GetMapping("/customer/register")
	public String registerForm() {
		//ModelAndView mv = new ModelAndView();
		System.out.println("도착..");
		//mv.setViewName("/customer/register");
		return "/customer/register";
	}

	@PostMapping("/customer/register")
	public String register(CustomerVo vo) {
		//ModelAndView mv = new ModelAndView();
		customerService.cusregister(vo);
		//mv.setViewName("redirect:/customer/list");
		return "redirect:/customer/list";
	}

	@GetMapping("/customer/modifyForm")
	public String modifyForm(int custId, Model model) {
		//ModelAndView mv = new ModelAndView();
		CustomerVo vo = customerService.find(custId);
		//mv.addObject("vo",vo);
		//mv.setViewName("/customer/modify");
		model.addAttribute("vo",vo);
		return "/customer/modify";
	}

	@PostMapping("/customer/modify")
	public String modify(CustomerVo vo) {
		//ModelAndView mv = new ModelAndView();
		customerService.cusmodify(vo);
		//mv.setViewName("redirect:/customer/list");
		return "redirect:/customer/list";
	}

	@GetMapping("/customer/delete")
	public String delte(int custId) {
		//ModelAndView mv = new ModelAndView();
		customerService.cusdelte(custId);
		//mv.setViewName("redirect:/customer/list");
		return "redirect:/customer/list";
	}

}
