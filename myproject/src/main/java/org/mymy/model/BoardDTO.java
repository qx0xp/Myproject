package org.mymy.model;

import java.util.ArrayList;

public class BoardDTO {
	// 게시글 번호
	private int bno;
	// 게시글 제목
	private String title;
	// 게시글 내용
	private String content;
	// 게시글 등록일
	private String regdate;
	// 카테고리
	private String bgno;
	// 조회수
	private int count;
	// 좋아요
	private int good;
	// 작성자 id
	private String id;
	// 작성자명
	private String writer;
	// 첨부 파일
	private ArrayList<AttachFileDTO> attach;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getBgno() {
		return bgno;
	}
	public void setBgno(String bgno) {
		this.bgno = bgno;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getGood() {
		return good;
	}
	public void setGood(int good) {
		this.good = good;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public ArrayList<AttachFileDTO> getAttach() {
		return attach;
	}
	public void setAttach(ArrayList<AttachFileDTO> attach) {
		this.attach = attach;
	}
	
	@Override
	public String toString() {
		return "BoardDTO [bno=" + bno + ", title=" + title + ", content=" + content + ", regdate=" + regdate + ", bgno="
				+ bgno + ", count=" + count + ", good=" + good + ", id=" + id + ", writer=" + writer + ", attach="
				+ attach + "]";
	}
}
