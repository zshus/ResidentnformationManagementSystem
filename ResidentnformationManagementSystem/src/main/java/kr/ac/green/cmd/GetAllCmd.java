package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;

import kr.ac.green.ResidentDAO;

public class GetAllCmd implements ICmd {

	@Override
	public void action(HttpServletRequest request) {
		//System.out.println("list: "+ResidentDAO.getAll());
		request.setAttribute("list", ResidentDAO.getAll());
		//contentPage="pages/list.jsp";		
		request.setAttribute("contentPage", "pages/list.jsp");

	}

}
