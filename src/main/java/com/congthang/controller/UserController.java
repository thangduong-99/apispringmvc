package com.congthang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.congthang.entity.MyConstants;
import com.congthang.entity.User;
import com.congthang.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
    public JavaMailSender emailSender;
	
	@GetMapping
	public String Main() {
		return "login";
	}
	@GetMapping("signUp")
	public String SignUp() {
		return "signUp";
	}
	@PostMapping("login")
	public String Login(@RequestParam("username") String username, @RequestParam("pass") String pass, ModelMap map) {
		User user = new User();
		user.setUserName(username);
		user.setPassWord(pass);
		if (userService.checkLogin(user)) {
			return "sendEmail";
		}else {
			map.addAttribute("message","Click SignUp User !");
			return "login";
		}
	}
	@PostMapping("creat")
	public String CreatUser(@RequestParam("username") String username, @RequestParam("pass") String pass, @RequestParam("repeat_pass") String repeat_pass,ModelMap modelMap) {
		if(pass.equals(repeat_pass)) {
			User user = new User();
			user.setUserName(username);
			user.setPassWord(pass);
			userService.save(user);
			modelMap.addAttribute("message","Creat User Success !");
			return "login";
		}else {
			modelMap.addAttribute("message","Creat User false!");
			return "signUp";
		}
	}
	@GetMapping("sendEmail")
    public String sendSimpleEmail(@RequestParam("email")String email,@RequestParam("subject") String subject,@RequestParam("message") String message,ModelMap map) {
 
        // Create a Simple MailMessage.
        SimpleMailMessage message1 = new SimpleMailMessage();
        MyConstants my = new MyConstants();
         
        message1.setTo(email);
        message1.setSubject(subject);
        message1.setText(message);
 
        // Send Message!
        this.emailSender.send(message1);
        map.addAttribute("message","Send Mail Success !");
        return "sendEmail";
    }
 
}
