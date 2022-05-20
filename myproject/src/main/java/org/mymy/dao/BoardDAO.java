package org.mymy.dao;

import java.util.ArrayList;

import org.mymy.model.AttachFileDTO;
import org.mymy.model.BoardDTO;
import org.mymy.model.Criteria;

public interface BoardDAO {
	// 게시글 작성
	public void boardWritePost(BoardDTO bdto);
	
	// 게시판 리스트 불러오기
	public ArrayList<BoardDTO> boardList(Criteria cri);
	
	// 게시판 전체 건 수 조회(검색 고려)
	public int getTotalCnt(Criteria cri);
	
	// 게시글 상세 페이지 조회
	public BoardDTO boardDetail(BoardDTO bdto);
	
	// 게시글 조회 시, 조회수 증가
	public void boardCntUp(BoardDTO bdto);
	
	// 게시글 수정
	public void boardModifyPost(BoardDTO bdto);
	
	// 게시글 삭제
	public void boardRemove(BoardDTO bdto);
	
	// 첨부파일 리스트 불러오기
	public ArrayList<AttachFileDTO> getAttachList(int bno);
}
