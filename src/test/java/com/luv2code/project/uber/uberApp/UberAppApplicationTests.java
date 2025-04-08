package com.luv2code.project.uber.uberApp;

import com.luv2code.project.uber.uberApp.services.EmailSenderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UberAppApplicationTests {

	@Autowired
	private EmailSenderService emailSenderService;

	@Test
	void contextLoads() {
		emailSenderService.sendEmail(
				"wapisi6133@provko.com",
				"This is the Testing email",
				"Body of my email");
	}

	@Test
	void sendEmailMultiple() {
		String[] emails={"wapisi6133@provko.com",""};
		emailSenderService.sendEmail(
				emails,
				"Hello from the Uber App Demo",
				"Body of my email");
	}

}
