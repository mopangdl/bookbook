package com.book.book.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.book.book.dao.IgLikeDao;
import com.book.book.dao.IgPostDao;
import com.book.book.dao.impl.IgLikeDaoImpl;
import com.book.book.dao.impl.IgPostDaoImpl;
import com.book.book.service.IgPostService;
import com.book.book.vo.IgLikeVO;
import com.book.book.vo.IgPostVO;
import com.google.gson.Gson;
import com.google.gson.JsonParser;

import mybatis.config.MyBatisConnectionFactory;

public class IgPostServiceImpl implements IgPostService {
	
	private IgPostDao igPostDao = new IgPostDaoImpl();
	private IgLikeDao igLikeDao = new IgLikeDaoImpl();
	private Gson gson = new Gson();

	@Override
	public Map<String, Object> insertPost(HttpServletRequest request) {
		Map<String,Object> result = new HashMap<>();
		result.put("result", "fail");
		result.put("reason", "post is null");
		IgPostVO IgPost = parseIgPostVOFromReqeust(request);
		if(IgPost != null) {
			String postIp = getRemoteAddr(request);
			System.out.println(postIp);
			IgPost.setPost_ip(postIp);
			if(igPostDao.insertPost(IgPost) > 0) {
				result.put("result", "success");
				result.put("reason", "insert");
			}else {
				result.put("reason", "insertPost fail");
			}
		}
		return result;
	}

	@Override
	public IgPostVO selectPost(HttpServletRequest request) {
		IgPostVO IgPost = new IgPostVO();
		Object idObj = request.getParameter("postId");
		if(idObj instanceof Integer) {
			Integer postId = Integer.parseInt(request.getParameter("postId"));
			IgPost.setPost_id(postId);
			return igPostDao.selectPost(IgPost);	
		}
		return IgPost;
	}

	@Override
	public List<IgPostVO> selectPostList(HttpServletRequest request) {
		IgPostVO IgPost = new IgPostVO();
		String postTitle = request.getParameter("post_title");
		String postUserId = request.getParameter("post_user_id");
//		Object deleteYnOjb = request.getParameter("postDeleteYn");
//		Integer postDeleteYn = 0;
//		if(deleteYnOjb instanceof Integer) {
//			postDeleteYn = Integer.parseInt(deleteYnOjb.toString());
//		}
		if(postTitle != null && !"".equals(postTitle)) {
			IgPost.setPost_title(postTitle);
		}
		if(postUserId != null && !"".equals(postUserId)) {
			IgPost.setPost_user_id(postUserId);
		}
//		if(postDeleteYn != null) {
//			IgPost.setPost_delete_yn(postDeleteYn);
//		}
		List<IgPostVO> result = igPostDao.selectPostList(IgPost);
		return result;
	}

	@Override
	public Map<String, Object> updateLike(HttpServletRequest request) {
		SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
		SqlSession session = null;
		Map<String,Object> result = new HashMap<>();
		result.put("result", "fail");
		result.put("reason", "post is null!");
		IgPostVO IgPost = parseIgPostVOFromReqeust(request);
		if(IgPost != null) {
			try {
				session = sqlSessionFactory.openSession(false);
				IgLikeVO like = new IgLikeVO();
				like.setPost_id(IgPost.getPost_id());
				like.setLike_ip(getRemoteAddr(request));
				if(igLikeDao.insertLike(like,session) > 0) {
					if(igPostDao.updateLikePost(IgPost,session) > 0) {
						result.put("result", "success");
						session.commit();
						return result;
					}else {
						result.put("reason", "updatePost fail!");
						session.rollback();
					}
				}else {
					result.put("reason", "insertLike fail!");
					session.rollback();
				}	
			}catch(Exception e) {
				
			}finally {
				if(session != null) {
					session.close();
					
				}
			}
		}
		return result;
	}
	
	private IgPostVO parseIgPostVOFromReqeust(HttpServletRequest request) {
		JsonParser parser = new JsonParser();
		try {
			BufferedReader br = request.getReader();
			String line = null;
			StringBuffer sb = new StringBuffer();
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			return gson.fromJson(parser.parse(sb != null ? sb.toString() : ""), IgPostVO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private String getRemoteAddr(HttpServletRequest request) {
		return request.getHeader("X-FORWARDED-FOR") != null ? request.getHeader("X-FORWARDED-FOR") : request.getRemoteAddr();
	}

}
