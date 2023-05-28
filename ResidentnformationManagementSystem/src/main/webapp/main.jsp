<%@page import="org.bean.Resident"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ResidentInformationManagementSystem</title>

<style type="text/css">
html {
	width: 100%;
	height:100%;
}

body {
	width: 90%;
	height: 90%;
}

#whole {
	width: 60em;
	height: 35em;
	margin-top: 5%;
	margin-left: 15%;
	text-align: center;
	font-size: 0.8em;	
	
}

#find {
	border: 1px solid #9DCFFF;
	margin-top: 2em;
	margin-left: 4.5em;
	margin-right: 4.5em;
	height: 5em;

}

#menuBox {
	width: 20%;
	height: 100%;
	float: left;
	text-decoration: none;
}

#contentBox {
	width: 80%;
	height: :100%;
	float: right;
	text-align: center;
	text-decoration: none;
}

#menus {
	text-align: left;
	width: 100%;
	margin-top: 10em;
	text-align: center;
	text-decoration: none;
	
}

#menus p{
	background-color: #9DCFFF;
	width: 100%;
	margin: 0;   
    padding: 0;
	margin-left: 0.5em;
	line-height: 2em;
	font-weight: bold;
	text-align: center;
}

#menus a {
    text-decoration: none;
    color: #A84E19;
    font-weight: bold;
    background-color: #D4F4FA;
    
	margin: 0;   
    padding: 0;
    line-height: 3em;
    margin-left: 0.5em;
    margin-right: -0.5em;
    
}

.menuStyle {
	display: block;
	margin-bottom: 1em;
	cursor: pointer;
}

.menuStyle:hover {
	font-weight: bold;
}

table {
	width: 80%;
	text-align: center;
	margin-top: 5%;
	margin-left: 10%;
}

#infoTable {
	margin-top: 10em;
	width: 60%;
	margin-left: 20%;
}

#infoHeader {
	width: 40%;
}

caption {
	font-size: 1em;
	font-weight: bold;
}

th {
	background-color: #9DCFFF;
}

input[type="text"]{
	height: 1.2em;
	border: 1px solid gray;
	text-align: center;
}

select, input[type="submit"]{
	width: 5em;
	height: 1.5em;
	border: 1px solid gray;
}

#nodata {
	margin-top: 20%;
	font-size: 3em;
	text-align: center;
	font-style: italic;
	color:red;
	font-weight: bold;
}

</style>
<script src="scripts/script.js"></script>
</head>


<%
String contentPage=(String) request.getAttribute("contentPage");
int p=(int)session.getAttribute("page");
String what=(String) request.getParameter("btnwhat");
if(what!=null){
	if(what.equals("next")){
		Vector<Resident> list=(Vector<Resident>)request.getAttribute("list");
		if(p<list.size()/4+1){
			p++;
		}
		
	}else{
		if(p>1){
			p--;
		}		
	}
	session.setAttribute("page",p );
}else{
	session.setAttribute("page",1 );
}

%>

<body>
<div id="whole">
<h1>Resident Information Management System</h1>
<hr>
<div id="menuBox">
<jsp:include page="pages/menu.jsp"/>
</div>

<div id="contentBox">
<jsp:include page="<%=contentPage %>"/>
</div>
</div>
</body>
</html>
