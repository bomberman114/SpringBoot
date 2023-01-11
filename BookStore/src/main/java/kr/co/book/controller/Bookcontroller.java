package kr.co.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.book.service.BookService;
import kr.co.book.vo.BookVo;

@Controller
public class Bookcontroller {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/book/list")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();
		List<BookVo> list = bookService.list();
		mv.addObject("book", list);
		mv.setViewName("/book/list");
		return mv;
	}
	
	@GetMapping("/book/register")
	public String registerForm() {
		//ModelAndView mv = new ModelAndView();
		//mv.setViewName("/BookStore/book/register");
		
		System.out.println("registerForm...");
		
		return "/book/register";
	}
	
	@PostMapping("/book/register")
	public String register(BookVo book) {
		//ModelAndView mv = new ModelAndView();
		bookService.register(book);
		//mv.setViewName("redirect:/book/list");
		return "redirect:/book/list";
	}
	
	@GetMapping("/book/modifyForm")
	public String modifyForm(Model model,int bookId) {
		//ModelAndView mv= new ModelAndView();
		BookVo vo = bookService.find(bookId);
		//mv.addObject("vo",vo);
		//mv.setViewName("/book/modify");
		model.addAttribute("vo",vo);
		return "/book/modify";
	}
	

	@PostMapping("/book/modify")
	public String modify(Model model, BookVo book) {
		//ModelAndView mv= new ModelAndView();
		bookService.modify(book);
	//	mv.setViewName("redirect:/book/list");
		return "redirect:/book/list";
	}
	
	@GetMapping("/book/delete")
	public String delete(int bookId) {
		//ModelAndView mv = new ModelAndView();
		bookService.delete(bookId);
		//mv.setViewName("redirect:/book/list");
		return "redirect:/book/list";
	}
	
	
	
	
}
