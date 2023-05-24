package kr.ac.green;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentServlet
 */
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
		
		//System.out.println(cmd);//  /getAll.student
		
		CmdFactory.action(request, cmd);
		
		String contentPage=(String)request.getAttribute("contentPage");
		
		
		if(contentPage==null)contentPage="pages/list.jsp";
		//System.out.println(contentPage);
		//System.out.println( request.getAttribute("isRedirect"));
		
		request.setAttribute("cmd", cmd);
//		request.getRequestDispatcher("main.jsp").forward(request, response);
		if(request.getAttribute("isRedirect")!=null) {
//			RequestDispatcher rd=request.getRequestDispatcher("main.jsp");
//			rd.forward(request, response);
			response.sendRedirect("index.jsp");
		}else {
//			response.sendRedirect("main.jsp");
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}
		
		
		
		
	}

}
