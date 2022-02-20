package com.study.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springboot.jdbc.MyUserDAO;

@Controller
public class MyController {
	
	@Autowired
	private MyUserDAO userDao;
	// @Repository로 등록한 한가지 빈 만이 자동 주입 가능
	
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception{
		return "JdbcTemplate 사용하기";
	}
	
	// @GetMapping("/user")
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String userlistPage(Model model) {
		model.addAttribute("users", userDao.list());
		// userDao list() methodのdataをreturnしてmodel変数に込める。
		// userDao객체 변수의 list() method의data를return하여model변수에 담는다.
		return "userlist";
	}
	
}
