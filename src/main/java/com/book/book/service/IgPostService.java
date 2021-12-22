package com.book.book.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.book.book.vo.IgPostVO;

public interface IgPostService {
	public Map<String,Object> insertPost(HttpServletRequest request);
	public IgPostVO selectPost(HttpServletRequest request);
	public List<IgPostVO> selectPostList(HttpServletRequest request);
	public Map<String,Object> updateLike(HttpServletRequest request);
}
