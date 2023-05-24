<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<div id="menus">
<p>Menu</p>

<a class="menuStyle" href="getAll.resident">Resident List</a>
<a class="menuStyle" href="input.resident">Resident Insert</a>
<a class="menuStyle" href="modify.resident">Resident Update</a>
<a class="menuStyle" href="delete.resident">Resident Delete</a>
</div>

<form name="menuForm" method="get" action="<%= request.getContextPath()%>">
<input type="hidden" name="cmd"/>
</form>