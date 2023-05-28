package kr.ac.green.cmd;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import kr.ac.green.dao.ResidentDAO;
import kr.ac.green.dao.SqlResidentDao;

public class DoDeleteCmd implements ICmd {

	@Override
	public void action(HttpServletRequest request) {
		int s_id=Integer.parseInt(request.getParameter("s_id"));
		//ResidentDAO.delete(s_id);
		SqlResidentDao dao=SqlResidentDao.getInstance();
		Connection con=dao.connect();
		dao.deleteResident(con, s_id);
		dao.disconnect(con);
		//isRedirect=true;
		request.setAttribute("isRedirect", true);

	}

}
