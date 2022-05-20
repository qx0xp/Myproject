package org.mymy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mymy.model.AttachFileDTO;
import org.mymy.model.BoardDTO;
import org.mymy.model.Criteria;
import org.mymy.model.GoodDTO;
import org.mymy.model.MemberDTO;
import org.mymy.model.PageDTO;
import org.mymy.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {
	@Autowired
	BoardService bservice;
	
	// 게시글 작성 페이지
	@RequestMapping(value="/board/write", method=RequestMethod.GET)
	public String boardWriteGet(HttpServletRequest request, Model model) {
		String bgno=request.getParameter("bgno");
		model.addAttribute("bgno", bgno);
		return "board/boardWrite";
	}
	
	// 게시글 작성
	@RequestMapping(value="/board/write", method=RequestMethod.POST)
	public String boardWritePost(Model model, BoardDTO bdto) {		
		if(bdto.getAttach()!=null) {
			// 첨부파일 값이 있다면
			bdto.getAttach().forEach(attach->System.out.println("수정 : "+attach)); // 파일 확인용
		}
		bservice.boardWritePost(bdto);
		System.out.println(bdto); // 확인용
		return "redirect:/board?bgno="+bdto.getBgno();
	}
	
	// 게시판 리스트 불러오기
	@RequestMapping(value="/board", method=RequestMethod.GET)
	public String boardList(Model model, Criteria cri){
		model.addAttribute("blist", bservice.boardList(cri));
		model.addAttribute("paging", new PageDTO(cri, bservice.getTotalCnt(cri)));
		System.out.println("조회 글 개수 : "+bservice.getTotalCnt(cri));
		return "board/boardList";
	}
	
	// 게시글 상세 페이지 조회
	@RequestMapping(value="/board/detail", method=RequestMethod.GET)
	public String boardDetail(BoardDTO bdto, Model model, HttpSession session, GoodDTO gdto) {
		model.addAttribute("bdetail", bservice.boardDetail(bdto));
		
		if(session.getAttribute("login")!=null) {
			String memberId=((MemberDTO) session.getAttribute("login")).getId();
			gdto.setBno(bdto.getBno());
			gdto.setMemberId(memberId);
		}
		
		model.addAttribute("goodChk", bservice.selectGood(gdto));
		model.addAttribute("goodCnt", bservice.getGoodCnt(bdto.getBno()));
		
		return "board/boardDetail";
	}
	
	// 게시글 수정 페이지
	@RequestMapping(value="/board/modify", method=RequestMethod.GET)
	public String boardModifyGet(BoardDTO bdto, Model model) {
		if(bdto.getAttach()!=null) {
			// 첨부파일 값이 있다면
			bdto.getAttach().forEach(attach->System.out.println(attach)); // 파일 확인용
		}
		model.addAttribute("bmodify", bservice.boardDetail(bdto));
		return "board/boardModify";
	}
	
	// 게시글 수정
	@RequestMapping(value="/board/modify", method=RequestMethod.POST)
	public String boardModifyPost(BoardDTO bdto) {
		bservice.boardModifyPost(bdto);
		return "redirect:/board/detail?bno="+bdto.getBno();
	}
	
	// 게시글 삭제
	@RequestMapping(value="/board/remove", method=RequestMethod.GET)
	public String boardRemove(BoardDTO bdto) {
		String bgno=bdto.getBgno();
		bservice.boardRemove(bdto);
		return "redirect:/board?bgno="+bgno;
	}
	
	// 좋아요 기능
	@ResponseBody
	@RequestMapping(value="/good", method=RequestMethod.POST, produces="application/json")
	public HashMap<String, Integer> good(@RequestBody Map<String, Object> param, GoodDTO gdto, Model model, HttpSession session) throws Exception{
		int goodVal=Integer.parseInt(String.valueOf(param.get("goodVal")));
		int bno=Integer.parseInt(String.valueOf(param.get("bno")));
		
		if(session.getAttribute("login")!=null) {
			String memberId=((MemberDTO) session.getAttribute("login")).getId();
			gdto.setBno(bno);
			gdto.setMemberId(memberId);
		}
		
		if(goodVal>0) {
			bservice.deleteGood(gdto);
			goodVal=0;
		} else {
			bservice.addGood(gdto);
			goodVal=1;
		}
		
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		map.put("goodVal", goodVal);
		map.put("goodCnt", bservice.getGoodCnt(bno));
		return map;
	}
	
	// 파일 업로드 화면 출력
	@RequestMapping(value="/board/attach", method=RequestMethod.GET)
	public ResponseEntity<ArrayList<AttachFileDTO>> getAttachList(int bno){
		System.out.println("파일첨부:"+bno); // 확인
		return new ResponseEntity<>(bservice.getAttachList(bno), HttpStatus.OK);
	}
}