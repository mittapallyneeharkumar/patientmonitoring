<%@page import="com.voidmain.pm.form.User"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.voidmain.pm.form.DischargeForm"%>
<%@page import="com.voidmain.pm.form.SurgaryForm"%>
<%@page import="com.voidmain.pm.form.DailyForm"%>
<%@page import="com.voidmain.pm.form.CurrentStatusForm"%>
<%@page import="com.voidmain.pm.dao.AppDAO"%>
<%@page import="com.voidmain.pm.form.Reports"%>
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
					<li><a class="current" href="patienthome.jsp">Medical Records</a></li>
					<li><a class="current" href="issueaccess.jsp">Issue Access</a></li>
					<li><a class="current" href="viewaccess.jsp">View Access</a></li>
					<li><a class="current" href="logout.jsp">Logout</a></li>
				</ul>
			</div>
		</div>
		<div id="site_content">
			
			<div id="content">
				<!-- insert the page content here -->
				
				<%
					String status=request.getParameter("status");
							
					if(status!=null)
					{
				%>
						<h1><%=status%></h1>
				<%		
					}
					else
					{
				%>
					 <h1>Patient Registration Form</h1>
				<%		
					}
				%>
				
				<form action="issueaccess.jsp" name="ff" method="post"
					onsubmit="return check()">
					
					<div class="form_settings">
						
						<p>
							<span>Select Hospital</span>
							<select name="hospital" required="required">
								<option>--select--</option>
								
								<%
									for(User user : AppDAO.getUsersByType("hospital"))
									{
								%>
										<option value="<%=user.getUserName()%>"><%=user.getUserName()%></option>
								<%		
									}
								%>
								
							</select>
						</p>
						
						<p style="padding-top: 15px">
							<span>&nbsp;</span><input class="submit" type="submit"
								name="contact_submitted" value="Issue Access"/>
						</p>
						
					</div>
				</form>
	
			</div>
			
		</div>
		
		<%
			String hospital=request.getParameter("hospital");
			
			if(hospital!=null)
			{
				if(AppDAO.addAccess((String)request.getSession().getAttribute("username"),hospital)==1)
				{
					response.sendRedirect("viewaccess.jsp?status=success");
				}
				else
				{
					response.sendRedirect("viewaccess.jsp?status=failed");
				}
			}
		%>
		<div id="footer">
			<p>
				Copyright &copy; | <a href="http://www.voidmaintechnologies.com">info</a>
			</p>
		</div>
	</div>
</body>
</html>