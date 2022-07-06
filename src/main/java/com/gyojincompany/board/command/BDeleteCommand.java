package com.gyojincompany.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gyojincompany.board.dao.BDao;

public class BDeleteCommand implements BCommand{
//	public void deleteExcute(HttpServletRequest request, HttpServletResponse response) {
//		String bid = request.getParameter("bid");
//		
//		BDao bdao = new BDao();
//		bdao.delete(bid);
//	}

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String bid = request.getParameter("bid");
		
		BDao bdao = new BDao();
		bdao.delete(bid);
	}
}
