
<%@page import="kr.ac.green.dao.ResidentDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%
    ResidentDAO.init(application); 
    %>
<jsp:forward page="getAll.resident"/>