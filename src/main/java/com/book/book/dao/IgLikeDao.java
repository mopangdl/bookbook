package com.book.book.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.book.book.vo.IgLikeVO;

public interface IgLikeDao {
	public int insertLike(IgLikeVO like, SqlSession session);
	public IgLikeVO selectLike(IgLikeVO like);
	public List<IgLikeVO> selectLikeList(IgLikeVO like);
}
