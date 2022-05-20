package org.mymy.model;

public class PageDTO {
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	private int total;

	// 변수 추가
	private Criteria cri;
	
	// 첫 번호 끝 번호
	// 1~10, 11~20, 21~30 31~40 짠다고 설정
	
	// 생성자
	public PageDTO(Criteria cri, int total) {
		this.cri=cri;
		this.total=total;
		
		// 1. 페이지 시작 번호, 끝 번호 처리
		// pageNum=1로 이미 선언됨
		this.endPage=(int)(Math.ceil(cri.getPageNum()/10.0)*10);
		this.startPage=this.endPage-9;
		
		// 결점: 만약 15페이지가 끝이라면..? 11~20 성립 안 됨
		int realEnd=(int)(Math.ceil(total*1.0/cri.getAmount()));
		
		if(realEnd<endPage) {
			this.endPage=realEnd;
		}
		
		// 2. 이전/다음 버튼 처리
		// startpage 1~10 11~20 21~30 => 1보다 크면 보여라.. 11, 21, 31
		this.prev=this.startPage>1;
		this.next=realEnd>this.endPage;
	}
	
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Criteria getCri() {
		return cri;
	}
	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	@Override
	public String toString() {
		return "PageDTO [startPage=" + startPage + ", endPage=" + endPage + ", prev=" + prev + ", next=" + next
				+ ", total=" + total + ", cri=" + cri + "]";
	}
}
