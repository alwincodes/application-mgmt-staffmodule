<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.sgca.model.Rank"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%List<Rank> logs = (List<Rank>)request.getAttribute("rankLogs"); 
  if(logs!=null){
   Iterator<Rank> ite = logs.iterator();
 %>
<table class="maintable">
    <tr>
      <th>Id</th>
      <th>Process Status</th>
      <th>User</th>
      <th>Time</th>
    </tr>
    <% while(ite.hasNext()){ 
       Rank temp = ite.next();
    %>
    <tr>
      <td><%=temp.getRankId() %></td>
      <td><%=temp.getProcess_status() %></td>
      <td><%=temp.getUser() %></td>
      <td><%=temp.getTime().toString() %></td>
    </tr>
    <% } %>
 </table>
 
 <%}%>