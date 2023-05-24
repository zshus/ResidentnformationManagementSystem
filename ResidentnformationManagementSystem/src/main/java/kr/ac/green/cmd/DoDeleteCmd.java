package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;

import kr.ac.green.ResidentDAO;

public class DoDeleteCmd implements ICmd {

	@Override
	public void action(HttpServletRequest request) {
		int s_id=Integer.parseInt(request.getParameter("s_id"));
		ResidentDAO.delete(s_id);
		//isRedirect=true;
		request.setAttribute("isRedirect", true);

	}

}
