package kr.co.ch08.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.ch08.vo.User1Vo;

public interface User1Repo extends JpaRepository<User1Vo, String> {

	public User1Vo findUser1VOByUidAndPass(String uid, String pass);

}