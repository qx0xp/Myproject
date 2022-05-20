package org.mymy.model;

public class Criteria {
	// 검색 종류
	private String type;
	// 검색어
	private String keyword;
	// 페이지 번호
	private int pageNum;
	// 한 페이지당 보여야 할 글 수
	private int amount;
	// 카테고리
	private String bgno;
	
	
	// 초기화
	public Criteria(){
		this(1, 10);
	}
	
	public Criteria(int pageNum, int amount){
		this.pageNum=pageNum;
		this.amount=amount;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getBgno() {
		return bgno;
	}

	public void setBgno(String bgno) {
		this.bgno = bgno;
	}

	@Override
	public String toString() {
		return "Criteria [type=" + type + ", keyword=" + keyword + ", pageNum=" + pageNum + ", amount=" + amount
				+ ", bgno=" + bgno + "]";
	}
}
