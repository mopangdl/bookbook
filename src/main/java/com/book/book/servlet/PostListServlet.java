package com.book.book.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.book.service.IgPostService;
import com.book.book.service.impl.IgPostServiceImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class PostListServlet
 */
@WebServlet("/ajax/IgPost/*")
public class PostListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gson = new Gson();
	private IgPostService IgPostService = new IgPostServiceImpl();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		String pattern = request.getRequestURI().replace("/ajax/IgPost/", "");
		if("getPost".equals(pattern)) {
			response.getWriter().write(gson.toJson(IgPostService.selectPost(request)));
		}else if("getPostList".equals(pattern)) {
			response.getWriter().write(gson.toJson(IgPostService.selectPostList(request)));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		String pattern = request.getRequestURI().replace("/ajax/IgPost/", "");
		if("insertPost".equals(pattern)) {
			response.getWriter().write(gson.toJson(IgPostService.insertPost(request)));
		}
	}

}
