package com.gyojincompany.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gyojincompany.board.dao.BDao;

public class BModifyCommand implements BCommand{
	
//	public void modifyExcute(HttpServletRequest request, HttpServletResponse response) {
//		
//		String btitle = request.getParameter("btitle");
//		String bname = request.getParameter("bname");
//		String bcontent = request.getParameter("bcontent");
//		String bid = request.getParameter("bid");
//		
//		BDao bdao = new BDao();
//		bdao.modify(bname, btitle, bcontent, bid);
//	}

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String btitle = request.getParameter("btitle");
		String bname = request.getParameter("bname");
		String bcontent = request.getParameter("bcontent");
		String bid = request.getParameter("bid");
		
		BDao bdao = new BDao();
		bdao.modify(bname, btitle, bcontent, bid);
	}

}
