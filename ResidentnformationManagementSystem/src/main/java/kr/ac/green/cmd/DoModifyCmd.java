package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;

import org.bean.Resident;

import kr.ac.green.ResidentDAO;

public class DoModifyCmd implements ICmd {

	@Override
	public void action(HttpServletRequest request) {
		int s_id=Integer.parseInt(request.getParameter("s_id"));
		String s_name=request.getParameter("s_name");
		int s_grade=Integer.parseInt(request.getParameter("s_grade"));
		String s_tel=request.getParameter("s_tel");
		String s_class=request.getParameter("s_class");
		
		Resident s=new Resident();
		s.setS_id(s_id);
		s.setS_class(s_class);
		s.setS_name(s_name);
		s.setS_grade(s_grade);
		s.setS_tel(s_tel);
		
		ResidentDAO.update(s);
		
		//isRedirect=true;
		request.setAttribute("isRedirect", true);

	}

}
