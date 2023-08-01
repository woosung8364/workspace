package ezen.fileupload;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * 파일 업로드 서블릿
 */
@WebServlet("/upload2")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 1, 
		maxFileSize = 1024 * 1024 * 10, 
		maxRequestSize = 1024 * 1024* 15, 
		location = "C:/ezen-fullstack")
public class MultiFileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String uploadPath;
	
	@Override
		public void init() throws ServletException {
		 uploadPath=getServletContext().getInitParameter("fileStorage");
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uploader = request.getParameter("uploader");
		
		init();
		File file = new File(uploadPath);
		if (!file.exists()) {
			file.mkdirs();
		}

		
		List<String> fileNames = new ArrayList<String>();
		// 멀티 파일 업로드 파일인 경우...
		for (Part part : request.getParts()) {
			System.out.println("---------- 업로드 파일 정보 ----------");
			System.out.println("ContentType : " + part.getContentType());
			System.out.println("File Size : " + part.getSize());

			
			// 업로드 파일명 추출
			String fileName = part.getSubmittedFileName();
			fileNames.add(fileName);
			System.out.println("업로드 파일명: " + fileName);
			if (fileName != null) {
				try {
					part.write(uploadPath + fileName);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
//		업로드 결과를 보여주는 JSP forwoard
		request.setAttribute("uploader", uploader);
		request.setAttribute("uploadFiles", fileNames);
		request.getRequestDispatcher("/file/upload-result.jsp")
		.forward(request, response);
	}
}
