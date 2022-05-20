package org.mymy.model;

public class ReplyDTO {
	private int rno;
	private String reply;
	private String replyer;
	private String replyDate;
	private int bno;
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public String getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	
	@Override
	public String toString() {
		return "ReplyDTO [rno=" + rno + ", reply=" + reply + ", replyer=" + replyer + ", replyDate=" + replyDate
				+ ", bno=" + bno + "]";
	}
}
