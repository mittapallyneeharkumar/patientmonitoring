<%@page import="com.voidmain.pm.service.AppService"%>
<%@page import="java.util.Map"%>
<%@page import="com.voidmain.pm.dao.AppDAO"%>
<%@page import="com.voidmain.pm.form.User"%>
<%@page import="java.util.Iterator"%>
<%@page
	import="com.sun.xml.internal.bind.v2.runtime.reflect.ListIterator"%>
<%@page import="java.util.List"%>

<!DOCTYPE HTML>
<html>

<head>
<title></title>
<meta name="description" content="website description" />
<meta name="keywords" content="website keywords, website keywords" />
<meta http-equiv="content-type"
	content="text/html; charset=windows-1252" />
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Tangerine&amp;v1" />
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Yanone+Kaffeesatz" />
<link rel="stylesheet" type="text/css" href="style/style.css" />

</head>

<body>
	<div id="main">
		<div id="header">
			<div id="logo">
				<div class="slogan">
					<font color="white" size="5">Patient Monitoring System </font>
				</div>
			</div>
			<div id="menubar">
				<ul id="menu">
					<!-- put class="current" in the li tag for the selected page - to highlight which page you're on -->
					<li><a class="current" href="patienthome.jsp">Medical Records</a></li>
					<li><a class="current" href="issueaccess.jsp">Issue Access</a></li>
					<li><a class="current" href="viewaccess.jsp">View Access</a></li>
					<li><a class="current" href="logout.jsp">Logout</a></li>
				</ul>
			</div>
		</div>
		<div id="site_content">
			<div id="content">

				<%
					String status3 = request.getParameter("status");

					if (status3 != null) {
				%>
				<h1><%=status3%></h1>
				<%
					} else {
				%>
				<h1>Issued Hospitals</h1>
				<%
					}
				%>
				
				<%
					String data="";
				
					List<String> accessInfo = AppDAO.getAccess((String) request.getSession().getAttribute("username"));
	
					for (String hospital : accessInfo) {
						data=(String) request.getSession().getAttribute("username")+":"+hospital;
					}
					
				%>
				
				Block Chain Hash Code : <%=AppService.getSHA(data)%>

				<table class="imagetable">
					<tr>
						<th>Hospital</th>
						<th>Delete</th>
					</tr>
					<%
						List<String> accessList = AppDAO.getAccess((String) request.getSession().getAttribute("username"));

						for (String hospital : accessList) {
					%>
					<tr>
						<td><%=hospital%></td>
						<td><a href="viewaccess.jsp?hospital=<%=hospital%>">Delete</a></td>
					</tr>
					<%
						}
					%>
					<%
						String hospital = request.getParameter("hospital");

						if (hospital != null) {
							
							int result = AppDAO.deleteAccess((String)request.getSession().getAttribute("username"), hospital);

							if (result == 1) {
								response.sendRedirect("viewaccess.jsp?status=success");
							} else {
								response.sendRedirect("viewaccess.jsp?status=failed");
							}
						}
					%>
				</table>
			</div>
		</div>
		<div id="footer">
			<p>
				Copyright &copy; | <a href="http://www.voidmaintechnologies.com">info</a>
			</p>
		</div>
	</div>
</body>
</html>


