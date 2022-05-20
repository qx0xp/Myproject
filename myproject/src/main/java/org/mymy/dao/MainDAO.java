package org.mymy.dao;

import java.util.ArrayList;

import org.mymy.model.BoardDTO;
import org.mymy.model.MainCriteria;

public interface MainDAO {
	// 게시판 리스트 불러오기
	public ArrayList<BoardDTO> boardList(MainCriteria mcri);
	
	// 영화 소식 목록
	public ArrayList<BoardDTO> newsList(MainCriteria mcri);

	// 영화 수다
	public ArrayList<BoardDTO> talkList(MainCriteria mcri);
}
