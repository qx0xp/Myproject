package org.mymy.service;

import java.util.ArrayList;

import org.mymy.dao.ReplyDAO;
import org.mymy.model.ReplyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReplyServiceImpl implements ReplyService{
	@Autowired
	ReplyDAO rdao;
	
	// 댓글 작성
	@Transactional
	public int add(ReplyDTO rdto) {
		return rdao.add(rdto);
	}
	
	// 댓글 리스트
	public ArrayList<ReplyDTO> list(int bno){
		return rdao.list(bno);
	}
	
	// 수정 시, 댓글 내용 불러오기
	public ReplyDTO rplGet(int rno) {
		return rdao.rplGet(rno);
	}
	
	// 댓글 수정
	public int modify(ReplyDTO rdto) {
		return rdao.modify(rdto);
	}
	
	// 댓글 삭제
	@Transactional
	public int remove(ReplyDTO rdto) {
		return rdao.remove(rdto);
	}
}
