package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;

public class InputCmd implements ICmd {

	@Override
	public void action(HttpServletRequest request) {
		//contentPage="pages/input.jsp";
		request.setAttribute("contentPage", "pages/input.jsp");

	}

}
