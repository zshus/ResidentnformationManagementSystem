package kr.ac.green.cmd;

import java.sql.Connection;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.bean.Resident;

import kr.ac.green.dao.ResidentDAO;
import kr.ac.green.dao.SqlResidentDao;

public class GetAllCmd implements ICmd {

	@Override
	public void action(HttpServletRequest request) {
		SqlResidentDao dao=SqlResidentDao.getInstance();
		Connection con=dao.connect();	
		int pageNum=1;
		int perPage=4;
		int totalCount=dao.getToyalCount(con);
		int pageCount=totalCount/perPage;
		if(totalCount%perPage!=0) {
			pageCount++;
		}
		
		String temp=request.getParameter("pageNum");
		String btnWhat=request.getParameter("btnwhat");

		if(temp!=null) {
			pageNum=Integer.parseInt(temp);
			if(btnWhat.equals("next") && pageNum<pageCount) {
				pageNum++;
			}else if(btnWhat.equals("before") && pageNum >1) {
				pageNum--;
			}
			
		}
		
		Vector<Resident> list=dao.getList(con, pageNum, perPage);
		
		request.setAttribute("list", list);
		
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageNum", pageNum);
		dao.disconnect(con);	
		request.setAttribute("contentPage", "pages/list.jsp");
		
	}

}
