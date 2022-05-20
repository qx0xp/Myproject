package org.mymy.service;

import java.util.ArrayList;

import org.mymy.dao.AttachFileDAO;
import org.mymy.dao.BoardDAO;
import org.mymy.dao.GoodDAO;
import org.mymy.model.AttachFileDTO;
import org.mymy.model.BoardDTO;
import org.mymy.model.Criteria;
import org.mymy.model.GoodDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDAO bdao;
	@Autowired
	GoodDAO gdao;
	@Autowired
	AttachFileDAO adao;
	
	// 게시글 작성
	public void boardWritePost(BoardDTO bdto) {
		bdao.boardWritePost(bdto);
		
		// 파일 첨부
		if(bdto.getAttach()==null) {
			return;
		}
		
		bdto.getAttach().forEach(attach->{
			attach.setBno(bdto.getBno()); // bdto의 bno 저장
			adao.addBoardAttach(attach);
		});
	}
	
	// 게시판 리스트 불러오기
	public ArrayList<BoardDTO> boardList(Criteria cri){
		return bdao.boardList(cri);
	}
	
	// 게시판 전체 건 수 조회(검색 고려)
	public int getTotalCnt(Criteria cri) {
		return bdao.getTotalCnt(cri);
	}
	
	// 게시글 상세 페이지 조회
	@Transactional
	public BoardDTO boardDetail(BoardDTO bdto) {
		bdao.boardCntUp(bdto);
		return bdao.boardDetail(bdto);
	}
	
	// 게시글 수정
	public void boardModifyPost(BoardDTO bdto) {
		bdao.boardModifyPost(bdto);
		
		// 파일 첨부
		if(bdto.getAttach()==null) {
			return;
		}
		
		bdto.getAttach().forEach(attach->{
			attach.setBno(bdto.getBno()); // bdto의 bno 저장
			adao.removeBoardAttach(attach); // 수정 전, 데이터 삭제
			adao.addBoardAttach(attach);
		});
	}
	
	// 게시글 삭제
	public void boardRemove(BoardDTO bdto) {
		bdao.boardRemove(bdto);
	}
	
	// 좋아요 추가
	public void addGood(GoodDTO gdto) {
		gdao.addGood(gdto);
		gdao.updateGood(gdto);
	}
	
	// 좋아요 삭제
	public void deleteGood(GoodDTO gdto) {
		gdao.deleteGood(gdto);
		gdao.updateGood(gdto);
	}
	
	// 좋아요 여부 확인
	public int selectGood(GoodDTO gdto) {
		return gdao.selectGood(gdto);
	}
	
	// 해당 게시글 좋아요 총 개수 확인
	public int getGoodCnt(int bno) {
		return gdao.getGoodCnt(bno);
	}
	
	// 첨부파일 리스트 조회(여러건)
	public ArrayList<AttachFileDTO> getAttachList(int bno){
		return bdao.getAttachList(bno);
	}
}
