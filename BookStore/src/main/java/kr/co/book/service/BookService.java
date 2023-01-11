package kr.co.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.book.dao.BookDao;
import kr.co.book.vo.BookVo;
import kr.co.book.vo.CustomerVo;

@Service("BookService")
public class BookService {
	
	@Autowired
	private BookDao bookDao;

	public List<BookVo> list() {
		List<BookVo> list = bookDao.list();
		return list;
	}

	public void register(BookVo book) {
		bookDao.register(book);
		
	}

	public void modify(BookVo book) {
		bookDao.modify(book);
		
	}

	public void delete(int bookId) {
		bookDao.delete(bookId);
		
	}

	public BookVo find(int bookId) {
		BookVo find = bookDao.find(bookId);
		return find;
	}


}
