package com.gyojincompany.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gyojincompany.board.command.BCommand;
import com.gyojincompany.board.command.BContentviewCommand;
import com.gyojincompany.board.command.BDeleteCommand;
import com.gyojincompany.board.command.BListCommand;
import com.gyojincompany.board.command.BModifyCommand;
import com.gyojincompany.board.command.BReplyCommand;
import com.gyojincompany.board.command.BWriteCommand;
import com.gyojincompany.board.dao.BDao;

/**
 * Servlet implementation class BFrontController
 */
@WebServlet("*.do")
public class BFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();//요청주소저장(/mvc_board_project_20220630/write.do)
		String conPath = request.getContextPath();//컨텍스트패스저장(/mvc_board_project_20220630)
		String command = uri.substring(conPath.length());//실제 요청 주소 분기(command 분기)
		
		String view =null;
		BCommand comm = null;
		
		if(command.equals("/write_view.do")) {			
			
			view = "write_view.jsp";
		} else if (command.equals("/write.do")) {
			//글쓰기 명령이 실행
			request.setCharacterEncoding("utf-8");//한글 깨짐 방지
			
			comm = new BWriteCommand();
			comm.excute(request, response);
			
			view = "list.do";
		} else if (command.equals("/list.do")) {
			//글 리스트 불러오기 명령이 실행
			
			comm = new BListCommand();
			comm.excute(request, response);
			
			view = "list.jsp";
//			response.sendRedirect(view);// 데이터가 셋팅된 request 객체를 사용하지 못함
		} else if (command.equals("/content_view.do")) {
				
			comm = new BContentviewCommand();
			comm.excute(request, response);
				
				view = "content_view.jsp";				
		} else if (command.equals("/modify.do")) {
			
			request.setCharacterEncoding("utf-8");//한글 깨짐 방지
			
			comm = new BModifyCommand();
			comm.excute(request, response);
			
			view = "list.do";				
		} else if (command.equals("/delete.do")) {
			
			comm = new BDeleteCommand();
			comm.excute(request, response);
			
			view = "list.do";				
		} 
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
		
	}
		

}
