package org.mymy.dao;

import org.mymy.model.GoodDTO;

public interface GoodDAO {
	// 좋아요 추가
	public void addGood(GoodDTO gdto);
	
	// 좋아요 삭제
	public void deleteGood(GoodDTO gdto);
	
	// 좋아요 여부 확인
	public int selectGood(GoodDTO gdto);
	
	// tbl_board 좋아요 업데이트
	public void updateGood(GoodDTO gdto);
	
	// 해당 게시글 좋아요 총 개수 확인
	public int getGoodCnt(int bno);
}
