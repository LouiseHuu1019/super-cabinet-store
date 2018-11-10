package com.backend.supercabinetstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.supercabinetstore.service.MailSendService;

@RestController()
@RequestMapping("/email")
public class SendEmailController {
	@Autowired
	MailSendService mailSendService;
	
	@GetMapping
	public void sendEmail(){
		mailSendService.sendEmail();
	}
}
