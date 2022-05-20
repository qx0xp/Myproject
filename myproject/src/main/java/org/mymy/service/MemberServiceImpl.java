package org.mymy.service;

import org.mymy.dao.MemberDAO;
import org.mymy.model.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	MemberDAO mdao;
	
	// 로그인 후 세션 저장
	public MemberDTO loginPost(MemberDTO mdto) {
		return mdao.loginPost(mdto);
	}
	
	// 회원가입 회원 정보 작성
	public void joinPost(MemberDTO mdto) {
		mdao.joinPost(mdto);
	}
	
	// 아이디 중복 체크
	public int checkId(String id) {
		return mdao.checkId(id);
	}
	
	// 회원정보 수정 조회
	public MemberDTO editInfoGet(MemberDTO mdto) {
		return mdao.editInfoGet(mdto);
	}
	
	
	// 회원정보 수정
	public void editInfoPost(MemberDTO mdto) {
		mdao.editInfoPost(mdto);
	}
	
	// 회원탈퇴
	public void deleteAccountPost(MemberDTO mdto) {
		mdao.deleteAccountPost(mdto);
	}
}
