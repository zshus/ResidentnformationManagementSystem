<%@page import="org.bean.Resident"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
Vector<Resident> list=(Vector<Resident>)request.getAttribute("list");
session.setAttribute("size", list.size()-1);
int idx=(int)session.getAttribute("page");
int startIdx=idx*4-4;
int endIdx=idx*4;
%>

<jsp:include page="find.jsp">
<jsp:param value="getAll" name="cmd"/>
</jsp:include>

<table>
<caption> </caption>
<thead>
<tr>
<th id="idCol">ID</th>
<th id="nameCol">NAME</th>
<th id="telCol">TEL</th>
<th id="gradeCol">ADDRESS</th>
<th id="classCol">MEMBERS</th>
</tr>
</thead>
<tfoot>
<tr>
<th colspan="5">
<%
for(int i=1; i<=list.size()/4+1;i++){
	%>
	<%=i%>
	<%
}
%>
</th>
</tr>

</tfoot>

<tbody>
<%
if(list.size()!=0){	
	for(int i=startIdx;i<endIdx && i<list.size();i++){
		Resident s=list.get(i);
		%>
		<tr>
		<td><%=s.getS_id() %></td>
		<td><%=s.getS_name() %></td>
		<td><%=s.getS_tel() %></td>
		<td><%=s.getS_grade() %></td>
		<td><%=s.getS_class() %></td>
		</tr>
		<%
	}
}else{
%>
<tr>
<td colspan="5"> no data</td>
</tr>
<%
}
%>

</tbody>

</table>
<br>
<form action="getAll.resident" method="post">
<div class="button">
<input type="submit" value="before" name="btnwhat" />
<input type="submit" value="next" name="btnwhat"  />
</div>
</form>
<style>
.button {
margin-left: 5em;
width: 485px;
display: flex;
flex-direction:row;
justify-content: space-between;
}
</style>
