package com.voidmain.pm.servlets;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import com.voidmain.pm.dao.AppDAO;
import com.voidmain.pm.form.Reports;


@WebServlet("/AddReportsServlets")
public class AddReportsServlets extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Reports reports=new Reports();

		reports.setHospitalName((String)request.getSession().getAttribute("username"));

		String uploadFilename = "";

		// Root Directory.
		String uploadRootPath = request.getServletContext().getRealPath("")+"/documents/";
		System.out.println("uploadRootPath=" + uploadRootPath);

		File uploadRootDir = new File(uploadRootPath);
		// Create directory if it not exists.
		if (!uploadRootDir.exists()) {
			uploadRootDir.mkdirs();
		}

		boolean isUploaded = false;

		// Check that we have a file upload request
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		if(isMultipart) {
			// Create a factory for disk-based file items
			FileItemFactory factory = new DiskFileItemFactory();

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);

			try {
				// Parse the request
				List<FileItem> items = upload.parseRequest(new ServletRequestContext(request));

				for (FileItem item : items) {
					// processes only fields that are not form fields
					if (!item.isFormField()) {
						//this will be true if file field is found in the List
						uploadFilename = item.getName();

						reports.setFileName(uploadFilename);

						uploadRootPath=uploadRootPath+uploadFilename;

						try {
							File savedFile = new File(uploadRootPath);
							//out.print(savedFile.getAbsolutePath());
							item.write(savedFile);
							isUploaded = true;
						} catch(Exception e) {
							isUploaded = false;
							e.printStackTrace();
						}
					} else {

						String fieldname = item.getFieldName();
						String fieldvalue = item.getString();

						if(fieldname.equals("patientname"))
						{
							reports.setPatientName(fieldvalue);
						}
						else
						{
							if(fieldname.equals("date"))
							{
								reports.setDate(fieldvalue);
							}
							else
							{
								if(fieldname.equals("reportname"))
								{
									reports.setReportName(fieldvalue);
								}
							}
						}
					}
				}
			}//try
			catch (FileUploadException e) {
				e.printStackTrace();
			} 

			if(isUploaded){

				String status=AppDAO.addReports(reports)==1?"success":"failed";

				if(status.equals("success"))
				{
					response.sendRedirect("addreport.jsp?status=success");
				}
				else
				{
					response.sendRedirect("addreport.jsp?status=failed");
				}
			}
		}
	}
}
