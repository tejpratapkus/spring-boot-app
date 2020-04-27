package com.tej.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tej.auth.modal.AuthConfiguration;

@Controller
public class ProfileController {

	@Autowired
	private AuthConfiguration authConfiguration;

	@RequestMapping("/profile")
	public String getConfig(Model model) {
		model.addAttribute("model", authConfiguration.getDefaultModel());
		model.addAttribute("min", authConfiguration.getMinimumRent());
		return "mprofile";

	}
}
