package org.mymy.model;

public class GoodDTO {
	private int gno;
	private String memberId;
	private int bno;
	
	public int getGno() {
		return gno;
	}
	public void setGno(int gno) {
		this.gno = gno;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	
	@Override
	public String toString() {
		return "GoodDTO [gno=" + gno + ", memberId=" + memberId + ", bno=" + bno + "]";
	}	
}
