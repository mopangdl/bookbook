package com.book.book.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.book.book.dao.IgPostDao;
import com.book.book.vo.IgPostVO;

import mybatis.config.MyBatisConnectionFactory;

public class IgPostDaoImpl implements IgPostDao {
	
	SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();

	@Override
	public int insertPost(IgPostVO IgPost) {
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			return session.insert("com.book.book.dao.IgPostDao.insertPost",IgPost);
		}catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.commit();
				session.close();
			}
		}
		return 0;
	}

	@Override
	public IgPostVO selectPost(IgPostVO IgPost) {
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			return session.selectOne("com.book.book.dao.IgPostDao.selectPost",IgPost);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return null;
	}

	@Override
	public List<IgPostVO> selectPostList(IgPostVO IgPost) {
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			return session.selectList("com.book.book.dao.IgPostDao.selectPostList",IgPost);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return null;
	}

	@Override
	public int updateLikePost(IgPostVO IgPost, SqlSession session) {
		try {
			return session.update("com.book.book.dao.IgPostDao.updateLikePost",IgPost);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static void main(String[] args) {
		IgPostDao postDao = new IgPostDaoImpl();
		IgPostVO post = new IgPostVO();
		post.setPost_id(15);
		post.setPost_title("제목");
		post.setPost_contents("contents");
		post.setPost_user_id("userId");
		post.setPost_password("password");
		post.setPost_ip("ip");
		int result = postDao.insertPost(post);
		System.out.println(result);
	}

}
