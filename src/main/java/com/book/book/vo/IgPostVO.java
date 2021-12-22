package com.book.book.vo;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

@Alias("IgPost")
public class IgPostVO {
	private int post_id;	//pk
    private String post_title;	//게시글 제목
    private String post_contents;
    private String post_user_id;
    private String post_password;
    private Date post_created_date;
    private Date post_updated_date;
    private int post_like;
    private int post_delete_yn;
    private String post_ip;
    
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public String getPost_title() {
		return post_title;
	}
	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}
	public String getPost_contents() {
		return post_contents;
	}
	public void setPost_contents(String post_contents) {
		this.post_contents = post_contents;
	}
	public String getPost_user_id() {
		return post_user_id;
	}
	public void setPost_user_id(String post_user_id) {
		this.post_user_id = post_user_id;
	}
	public String getPost_password() {
		return post_password;
	}
	public void setPost_password(String post_password) {
		this.post_password = post_password;
	}
	public Date getPost_created_date() {
		return post_created_date;
	}
	public void setPost_created_date(Date post_created_date) {
		this.post_created_date = post_created_date;
	}
	public Date getPost_updated_date() {
		return post_updated_date;
	}
	public void setPost_updated_date(Date post_updated_date) {
		this.post_updated_date = post_updated_date;
	}
	public int getPost_like() {
		return post_like;
	}
	public void setPost_like(int post_like) {
		this.post_like = post_like;
	}
	public int getPost_delete_yn() {
		return post_delete_yn;
	}
	public void setPost_delete_yn(int post_delete_yn) {
		this.post_delete_yn = post_delete_yn;
	}
	public String getPost_ip() {
		return post_ip;
	}
	public void setPost_ip(String post_ip) {
		this.post_ip = post_ip;
	}
	@Override
	public String toString() {
		return "IgPostVO [post_id=" + post_id + ", post_title=" + post_title + ", post_contents=" + post_contents
				+ ", post_user_id=" + post_user_id + ", post_password=" + post_password + ", post_created_date="
				+ post_created_date + ", post_updated_date=" + post_updated_date + ", post_like=" + post_like
				+ ", post_delete_yn=" + post_delete_yn + ", post_ip=" + post_ip + "]";
	}
    
}
