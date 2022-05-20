package org.mymy.dao;

import java.util.ArrayList;

import org.mymy.model.ReplyDTO;

public interface ReplyDAO {
	// 댓글 작성
	public int add(ReplyDTO rdto);
	
	// 댓글 리스트
	public ArrayList<ReplyDTO> list(int bno);
	
	// 수정 시, 댓글 내용 불러오기
	public ReplyDTO rplGet(int rno);
	
	// 댓글 수정
	public int modify(ReplyDTO rdto);
	
	// 댓글 삭제
	public int remove(ReplyDTO rdto);
}
