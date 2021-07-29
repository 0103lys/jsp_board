package com.koreait.reply;

public class ReplyDTO {
	private int re_idx;
	private String re_userid;
	private String re_content;
	private String re_regdate;
	private int re_boardidx;
	
	
	public int getRe_idx() {
		return re_idx;
	}
	public void setRe_idx(int re_idx) {
		this.re_idx = re_idx;
	}
	public String getRe_userid() {
		return re_userid;
	}
	public void setRe_userid(String re_userid) {
		this.re_userid = re_userid;
	}
	public String getRe_content() {
		return re_content;
	}
	public void setRe_content(String re_content) {
		this.re_content = re_content;
	}
	public String getRe_regdate() {
		return re_regdate;
	}
	public void setRe_regdate(String re_regdate) {
		this.re_regdate = re_regdate;
	}
	public int getRe_boardidx() {
		return re_boardidx;
	}
	public void setRe_boardidx(int re_boardidx) {
		this.re_boardidx = re_boardidx;
	}
	@Override
	public String toString() {
		return "ReplyDTO [re_idx=" + re_idx + ", re_userid=" + re_userid + ", re_content=" + re_content
				+ ", re_regdate=" + re_regdate + ", re_boardidx=" + re_boardidx + "]";
	}
	
	
}
