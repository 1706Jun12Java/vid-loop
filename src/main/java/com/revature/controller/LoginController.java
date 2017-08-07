package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.User;

@Controller
public class LoginController {
//
//  @RequestMapping("/login")
//  public String login(HttpServletRequest req, Model model) {
//		// Get credentials
//		String username = req.getParameter("username");
//		String password = req.getParameter("password");
//		UserDao dao = new UserDaoImpl();
//		try {
//			User user = dao.getUserByName(username);
//			if (user.getPassword().equals(password)) {
//				HttpSession session = req.getSession();
//				session.setAttribute("user", user);
//			} else {
//				model.addAttribute("error", "Password is incorrect");
//				return "login";
//			}
//
//		} catch (Exception e) {
//			model.addAttribute("error", "Username does not exists");
//			return "login";
//		}
//		return "profile";
//}
//
//	@RequestMapping("/logout")
//	public String logout(HttpServletRequest req, Model model) {
//		HttpSession session = req.getSession();
//		session.invalidate();
//		return "index";
//	}
}

