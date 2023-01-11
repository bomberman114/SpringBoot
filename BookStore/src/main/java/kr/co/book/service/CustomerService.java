package kr.co.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.book.dao.CustomerDao;
import kr.co.book.vo.CustomerVo;

@Service("CustomerService")
public class CustomerService {
	@Autowired
	private CustomerDao customerDao;

	public List<CustomerVo> cuslist() {
		List<CustomerVo> cuslist = customerDao.cuslist();
		return cuslist;
	}

	public void cusregister(CustomerVo vo) {
		customerDao.cusregister(vo);

	}

	public void cusmodify(CustomerVo vo) {
		customerDao.cusmodify(vo);

	}

	public void cusdelte(int custId) {
		customerDao.cusdelte(custId);

	}

	public CustomerVo find(int custId) {
		 CustomerVo find= customerDao.find(custId);
		return find;
	}

}
