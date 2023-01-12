package kr.co.ch08.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.ch08.vo.User2Vo;

public interface User2Repo extends JpaRepository<User2Vo, String> {
	public User2Vo findUser2VOByUidAndPass(String uid, String pass);
}