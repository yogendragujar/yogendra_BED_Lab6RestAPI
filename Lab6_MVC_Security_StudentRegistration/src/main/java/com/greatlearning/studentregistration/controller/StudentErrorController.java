package com.greatlearning.studentregistration.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentErrorController implements ErrorController {
	@RequestMapping("/error")
	public String handleError(HttpServletRequest httprequest) {
		Object status = httprequest.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		Object errorMsg = httprequest.getAttribute(RequestDispatcher.ERROR_MESSAGE);
		System.out.println("Error encountered " + status.toString() +" "+ errorMsg );
		return "403";
	}
}
