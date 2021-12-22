package com.book.book.vo;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

@Alias("like")
public class IgLikeVO {
	private int like_id;	//pk
    private int post_id;
    private int like_like_yn;
    private Date like_date;
    private String like_ip;
    
	public int getLike_id() {
		return like_id;
	}
	public void setLike_id(int like_id) {
		this.like_id = like_id;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public int getLike_like_yn() {
		return like_like_yn;
	}
	public void setLike_like_yn(int like_like_yn) {
		this.like_like_yn = like_like_yn;
	}
	public Date getLike_date() {
		return like_date;
	}
	public void setLike_date(Date like_date) {
		this.like_date = like_date;
	}
	public String getLike_ip() {
		return like_ip;
	}
	public void setLike_ip(String like_ip) {
		this.like_ip = like_ip;
	}
	
	@Override
	public String toString() {
		return "IgLikeVO [like_id=" + like_id + ", post_id=" + post_id + ", like_like_yn=" + like_like_yn
				+ ", like_date=" + like_date + ", like_ip=" + like_ip + "]";
	}
	
}
