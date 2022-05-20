package org.mymy.service;

import java.util.ArrayList;

import org.mymy.dao.MainDAO;
import org.mymy.model.BoardDTO;
import org.mymy.model.MainCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainServiceImpl implements MainService {
	@Autowired
	MainDAO mdao;
	
	// 게시판 리스트 불러오기
	public ArrayList<BoardDTO> boardList(MainCriteria mcri){
		return mdao.boardList(mcri);
	}
	
	// 영화 소식 목록
	public ArrayList<BoardDTO> newsList(MainCriteria mcri){
		return mdao.newsList(mcri);
	}

	// 영화 수다
	public ArrayList<BoardDTO> talkList(MainCriteria mcri){
		return mdao.talkList(mcri);
	}
}
