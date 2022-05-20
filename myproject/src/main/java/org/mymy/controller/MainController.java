package org.mymy.controller;

import org.mymy.model.MainCriteria;
import org.mymy.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	@Autowired
	MainService mservice;
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String mainGet(Model model, MainCriteria mcri) {
		model.addAttribute("blist", mservice.boardList(mcri));
		model.addAttribute("nlist", mservice.newsList(mcri));
		model.addAttribute("tlist", mservice.talkList(mcri));
		return "/main";
	}
}