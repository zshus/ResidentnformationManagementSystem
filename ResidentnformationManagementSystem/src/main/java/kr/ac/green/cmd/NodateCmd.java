package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;

public class NodateCmd implements ICmd {

	@Override
	public void action(HttpServletRequest request) {
		//contentPage="pages/nodata.jsp";
		request.setAttribute("contentPage", "pages/nodata.jsp");

	}

}
