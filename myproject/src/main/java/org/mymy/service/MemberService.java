package org.mymy.service;

import org.mymy.model.MemberDTO;

public interface MemberService {
	// 로그인 후 세션 저장
	public MemberDTO loginPost(MemberDTO mdto);
	
	// 회원가입 회원 정보 작성
	public void joinPost(MemberDTO mdto);
	
	// 아이디 중복 체크
	public int checkId(String id);
	
	// 회원정보 수정 조회
	public MemberDTO editInfoGet(MemberDTO mdto);
	
	// 회원정보 수정
	public void editInfoPost(MemberDTO mdto);
	
	// 회원탈퇴
	public void deleteAccountPost(MemberDTO mdto);
}
