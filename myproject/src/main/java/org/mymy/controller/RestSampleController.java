package org.mymy.controller;

import org.mymy.model.RestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestSampleController {
	@RequestMapping(value="getText", produces="text/plain; charset=utf-8", method=RequestMethod.GET)
	public String getText() {
		return "안뇽";
	}
	
	// 객체 변환(DTO)
	@RequestMapping(value="getDTO", produces= {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE}, method=RequestMethod.GET)
	public RestDTO getDTO() {
		RestDTO rdto=new RestDTO(10, "가", "나다");
		return rdto;
	}
	
	@RequestMapping(value="getResponseEntity", params="no", method=RequestMethod.GET)
	public ResponseEntity<RestDTO> check(int no){
		RestDTO rdto=new RestDTO(50, "라", "마바");
		
		ResponseEntity<RestDTO> result=null;
		if(no>=20) {
			result=ResponseEntity.status(HttpStatus.OK).body(rdto);
		} else {
			result=ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(rdto);
		}
		return result;
	}

}
