<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
String cmd=(String)request.getAttribute("cmd");
//System.out.println("forwhat:"+cmd);
%>


<div id="find">
<form action="find.resident" method="post">
<table>
<tr>
<td>
검색:
</td>

<td>
<select name="category">
<option value="s_id">ID</option>
<%if(cmd.contains("getAll")){ %>
<option value="s_name">Name</option>
<option value="s_class">Class</option>
<%} %>
</select>
</td>

<td>
내용:
</td>
<td>
<input type="text" name="inputVal"/>
</td>

<td>
<input type="submit" value="go"/>
</td>
</tr>
</table>

<input type="hidden" name="cmd" value="find"/>
<input type="hidden" name="forWhat" value="<%=cmd %>"/>

</form>
</div>

