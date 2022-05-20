package org.mymy.controller;

import javax.servlet.http.HttpSession;

import org.mymy.model.MemberDTO;
import org.mymy.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MemberController {
	@Autowired
	MemberService mservice;
	
	// 로그인 화면 이동
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginGet(){
		return "member/login";
	}
	
	// 로그인(세션 저장)
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginPost(MemberDTO mdto, HttpSession session){
		if(mservice.loginPost(mdto)!=null) {
			// select된 결과가 있다면
			// 세션에 select된 걸 login 변수에 담고
			// index.jsp페이지로 이동
			session.setAttribute("login", mservice.loginPost(mdto));
			return "redirect:/main";
		} else {
			// select된 결과가 없다면
			// log.jsp페이지로 이동
			return "redirect:/login";
		}
	}
	
	// 로그아웃
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main";
	}
	
	// 회원가입 페이지 이동
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinGet(){
		return "member/join";
	}
	
	// 회원가입 회원 정보 작성
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String joinPost(MemberDTO mdto){
		mservice.joinPost(mdto);
		return "redirect:/main";
	}
	
	// 아이디 중복 체크
	@ResponseBody
	@RequestMapping(value="/checkId/{id}", method=RequestMethod.GET)
	public int checkId(@RequestParam("id") String id) {
		return mservice.checkId(id);
	}
	
	// 회원정보 조회
	@RequestMapping(value="/mypage", method=RequestMethod.GET)
	public String mypageGet() {
		return "/member/mypage";
	}
	
	// 회원정보 수정 페이지 이동
	@RequestMapping(value="/editInfo", method=RequestMethod.GET)
	public String editInfoGet() {
		return "/member/editInfo";
	}
	
	// 회원정보 수정
	@RequestMapping(value="/editInfo", method=RequestMethod.POST)
	public String editInfoPost(MemberDTO mdto, HttpSession session) {
		mservice.editInfoPost(mdto);
		session.setAttribute("login", mservice.editInfoGet(mdto));
//		session.invalidate();
		return "redirect:/mypage";
	}
	
	// 회원탈퇴 페이지 이동
	@RequestMapping(value="/deleteAccount", method=RequestMethod.GET)
	public String deleteAccountGet(MemberDTO mdto) {
		return "/member/deleteAccount";
	}
	
	// 회원탈퇴
	@RequestMapping(value="/deleteAccount", method=RequestMethod.POST)
	public String deleteAccountPost(MemberDTO mdto, HttpSession session, RedirectAttributes rttr) {
		MemberDTO member=(MemberDTO)session.getAttribute("login");
		// 해당 계정 비밀번호
		String sPw=member.getPassword();
		// 확인 위한 비밀번호
		String mPw=mdto.getPassword();
		
		// 빨리 종료해야 할 것 부터
		if(!sPw.equals(mPw)) {
			rttr.addFlashAttribute("msg", false);
			return "redirect:/deleteAccount";
		}
	
		mservice.deleteAccountPost(mdto);
		session.invalidate();
		return "redirect:/main";
	}
}