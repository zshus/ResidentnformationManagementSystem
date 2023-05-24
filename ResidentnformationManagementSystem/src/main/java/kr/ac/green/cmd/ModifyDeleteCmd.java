package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;

public class ModifyDeleteCmd implements ICmd {

	@Override
	public void action(HttpServletRequest request) {
		//contentPage="pages/find.jsp";
		request.setAttribute("contentPage", "pages/find.jsp");

	}

}
