package com.book.book.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.book.book.dao.IgLikeDao;
import com.book.book.vo.IgLikeVO;

public class IgLikeDaoImpl implements IgLikeDao {

	@Override
	public int insertLike(IgLikeVO like, SqlSession session) {
		try {
			if(session != null) {
				return session.insert("com.book.book.dao.IgLikeDao.insertLike",like);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public IgLikeVO selectLike(IgLikeVO like) {
//		SqlSession session = null;
//		try {
//			session = sqlSessionFactory.openSession();
//			return session.selectOne("com.innogram.dao.LikeDao.selectLike",like);
//		}catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			if(session != null) {
//				session.close();
//			}
//		}
		return null;
	}

	@Override
	public List<IgLikeVO> selectLikeList(IgLikeVO like) {
		// TODO Auto-generated method stub
		return null;
	}

}
