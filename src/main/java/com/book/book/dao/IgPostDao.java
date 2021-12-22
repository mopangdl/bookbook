package com.book.book.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.book.book.vo.IgPostVO;

public interface IgPostDao {
	public int insertPost(IgPostVO IgPost);
	public IgPostVO selectPost(IgPostVO IgPost);
	public List<IgPostVO> selectPostList(IgPostVO IgPost);
	public int updateLikePost(IgPostVO IgPost, SqlSession session);
}
