package org.mymy.service;

import java.util.ArrayList;

import org.mymy.model.AttachFileDTO;
import org.mymy.model.BoardDTO;
import org.mymy.model.Criteria;
import org.mymy.model.GoodDTO;

public interface BoardService {
	// 게시글 작성
	public void boardWritePost(BoardDTO bdto);
	
	// 게시판 리스트 불러오기
	public ArrayList<BoardDTO> boardList(Criteria cri);
	
	// 게시판 전체 건 수 조회(검색 고려)
	public int getTotalCnt(Criteria cri);
	
	// 게시글 상세 페이지 조회
	public BoardDTO boardDetail(BoardDTO bdto);
	
	// 게시글 수정
	public void boardModifyPost(BoardDTO bdto);
	
	// 게시글 삭제
	public void boardRemove(BoardDTO bdto);
	
	// 좋아요 추가
	public void addGood(GoodDTO gdto);
	
	// 좋아요 삭제
	public void deleteGood(GoodDTO gdto);
	
	// 좋아요 여부 확인
	public int selectGood(GoodDTO gdto);
	
	// 해당 게시글 좋아요 총 개수 확인
	public int getGoodCnt(int bno);
	
	// 첨부파일 리스트 조회(여러건)
	public ArrayList<AttachFileDTO> getAttachList(int bno);
}
