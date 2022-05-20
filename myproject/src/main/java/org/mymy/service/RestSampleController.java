package org.mymy.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestSampleController {
	@RequestMapping(value="getText", method=RequestMethod.GET)
	public String getText() {
		return "방가방가햄토리";
	}
}
