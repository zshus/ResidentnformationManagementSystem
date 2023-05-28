package kr.ac.green.cmd;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import kr.ac.green.dao.ResidentDAO;
import kr.ac.green.dao.SqlResidentDao;

public class GetAllCmd implements ICmd {

	@Override
	public void action(HttpServletRequest request) {
		//System.out.println("list: "+ResidentDAO.getAll());
		SqlResidentDao dao=SqlResidentDao.getInstance();
		Connection con=dao.connect();
		request.setAttribute("list", dao.getAll(con));
		dao.disconnect(con);
		//contentPage="pages/list.jsp";		
		request.setAttribute("contentPage", "pages/list.jsp");

	}

}
