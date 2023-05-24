package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;

import org.bean.Counter;
import org.bean.Resident;

import kr.ac.green.ResidentDAO;

public class DoInsertCmd implements ICmd {

	@Override
	public void action(HttpServletRequest request) {
		
		String s_name=request.getParameter("s_name");
		int s_grade=Integer.parseInt(request.getParameter("s_grade"));
		String s_tel=request.getParameter("s_tel");
		String s_class=request.getParameter("s_class");
		Resident s=new Resident();
		
		s.setS_id(Counter.getCount());
		s.setS_name(s_name);
		s.setS_grade(s_grade);
		s.setS_tel(s_tel);
		s.setS_class(s_class);
		ResidentDAO.insert(s);
		
		System.out.println("list: "+ ResidentDAO.getAll());
		
		request.setAttribute("list",ResidentDAO.getAll());
		request.setAttribute("isRedirect", true);
		//isRedirect=true;

	}

}
