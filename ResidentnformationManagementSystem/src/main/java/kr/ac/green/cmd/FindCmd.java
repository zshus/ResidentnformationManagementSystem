package kr.ac.green.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.bean.Resident;

import kr.ac.green.ResidentDAO;

public class FindCmd implements ICmd {

	@Override
	public void action(HttpServletRequest request) {
		String forWhat=request.getParameter("forWhat");
		String category=request.getParameter("category");
		String inputVal=request.getParameter("inputVal");
		
		System.out.println(inputVal);
		
		Vector<Resident> list=null;
		if(forWhat.contains("getAll")){
			if(category.equals("s_id")){
				list=new Vector<Resident>();
				Resident s=ResidentDAO.getStudentById(Integer.parseInt(inputVal));
				
				if(s!=null){
						list.add(s);
					}
				
			}else if(category.equals("s_name")){
				list=ResidentDAO.getStudentByName(inputVal);
			}else {
				list=ResidentDAO.getStudentByAddress(inputVal);
			}
			
			//contentPage="pages/list.jsp";
			request.setAttribute("contentPage", "pages/list.jsp");
			request.setAttribute("list", list);
		}else{
			Resident s =ResidentDAO.getStudentById(Integer.parseInt(inputVal));
			if(s!=null){
				if(forWhat.contains("modify")){
					//contentPage="pages/modify.jsp";
					request.setAttribute("contentPage", "pages/modify.jsp");
				}else{
					//contentPage="pages/info.jsp";
					request.setAttribute("contentPage", "pages/info.jsp");
					
				}
				request.setAttribute("resident", s);
			}else{
				//contentPage="pages/nodata.jsp";
				request.setAttribute("contentPage", "pages/nodata.jsp");
			}
		}
		

	}

}
