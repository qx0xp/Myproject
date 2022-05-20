package org.mymy.controller;

import java.util.ArrayList;

import org.mymy.model.ReplyDTO;
import org.mymy.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReplyController {
	@Autowired
	ReplyService rservice;
	
	// 댓글 삽입
	@RequestMapping(value="/replies/new", method=RequestMethod.POST, consumes="application/json", produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> add(@RequestBody ReplyDTO rdto) {
		System.out.println(rdto);
		// 성공적으로 삽입, result=1
		int result=rservice.add(rdto);
		return result==1?new ResponseEntity<>("success", HttpStatus.OK):new ResponseEntity<>("error", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 댓글 목록 불러오기
	@RequestMapping(value="/replies/list/{bno}", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<ArrayList<ReplyDTO>> list(@PathVariable("bno") int bno, Model model) {
		// @PathVariable : url에 변수 들어갈 때 추가 {bno}
		// 통신이 정상적이면 get() 결과를 comment.js의 ajax 함수 success로 보내라
		return new ResponseEntity<>(rservice.list(bno), HttpStatus.OK);
	}
	
	// 댓글 옵션 클릭시, 모달창에 내용 불러오기
	@RequestMapping(value="/replies/detail/{rno}", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<ReplyDTO> rplGet(@PathVariable("rno") int rno) {
		return new ResponseEntity<>(rservice.rplGet(rno), HttpStatus.OK);
	}
	
	// 댓글 수정
	@RequestMapping(value="/replies/modify", method=RequestMethod.PUT, consumes="application/json", produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modify(@RequestBody ReplyDTO rdto){
		int result=rservice.modify(rdto);
		return result==1?new ResponseEntity<>("success", HttpStatus.OK):new ResponseEntity<>("error", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 댓글 삭제
	@RequestMapping(value="/replies/remove/{rno}", method=RequestMethod.DELETE, produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@PathVariable("rno") int rno, ReplyDTO rdto) {
		int result=rservice.remove(rdto);
		return result==1?new ResponseEntity<>("success", HttpStatus.OK):new ResponseEntity<>("error", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
