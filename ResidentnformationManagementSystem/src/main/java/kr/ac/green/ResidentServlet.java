package kr.ac.green;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ResidentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init(ServletConfig config) throws ServletException {
		super.init();
		CmdFactory.init();		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		process(request,response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cmd=request.getRequestURI().substring(request.getContextPath().length());
		if(cmd.contains("/pages")) {
			cmd=cmd.replace("/pages","");
		}		
		CmdFactory.action(request, cmd);
		
		String contentPage=(String)request.getAttribute("contentPage");
				
		if(contentPage==null)contentPage="pages/list.jsp";		
		
		request.setAttribute("cmd", cmd);
		if(request.getAttribute("isRedirect")!=null) {
			
			response.sendRedirect("index.jsp");
		}else {
			
			request.getRequestDispatcher("main.jsp").forward(request, response);
			
		}
		
		
		
		
	}

}
