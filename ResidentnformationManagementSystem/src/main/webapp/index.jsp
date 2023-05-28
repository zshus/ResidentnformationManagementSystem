
<%@page import="kr.ac.green.dao.ResidentDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%
    ResidentDAO.init(application);
    session.setAttribute("page",1 );
   
    %>
<jsp:forward page="getAll.resident"/>