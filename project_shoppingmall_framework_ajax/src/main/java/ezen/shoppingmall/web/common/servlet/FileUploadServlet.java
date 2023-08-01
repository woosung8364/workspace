package ezen.shoppingmall.web.common.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * 파일 업로드 서블릿
 * 서블릿(Servlet) 클래스에 @WebServlet 어노테이션과 
 * @MultipartConfig 어노테이션을 사용하여 파일 업로드를 처리하는 설정을 하고 있습니다.
 */

@WebServlet("/upload")

//파일 업로드를 처리하는 데 필요한 설정을 지정하는 어노테이션입니다.
@MultipartConfig(
//		1024 * 1024 * 1(1mb): 파일 데이터를 메모리에 유지하는 임계값으로, 이 크기 이상의 파일은 임시 파일로 디스크에 저장됩니다. 
		fileSizeThreshold = 1024 * 1024 * 1, 
//		maxFileSize = 1024 * 1024 * 10(10mb): 업로드 가능한 최대 파일 크기로, 이 크기를 초과하는 파일은 업로드가 거부됩니다. 
		maxFileSize = 1024 * 1024 * 10, 
//		요청 전체의 최대 크기로, 파일 데이터와 함께 전송되는 전체 요청 크기를 제한합니다. 여기서는 15MB를 설정하였습니다.
		maxRequestSize = 1024 * 1024* 15, 
//		업로드된 파일이 저장될 디렉토리 경로를 지정합니다. 
		location = "C:/ezen-fullstack")

public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String uploadPath ;
	
	@Override
	public void init() throws ServletException {
//		fileStorage라는 이름의 초기화 매개변수를 가져옵니다. 초기화 매개변수는 web.xml 파일에 설정되어 있는데, 서블릿의 설정 정보를 담고 있는 파일입니다.
		uploadPath = getServletContext().getInitParameter("fileStorage");
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		 응답(response)의 Content-Type을 설정합니다. 여기서는 "text/plain" 콘텐츠 타입을 사용합니다
		response.setContentType("text/plain; charset=utf-8");
//		응답(response)으로부터 문자열을 출력하기 위한 PrintWriter 객체를 생성합니다. 이를 사용하여 문자열을 클라이언트로 전송합니다.
		PrintWriter out = response.getWriter();
		
		//	요청(request)의 문자 인코딩을 "utf-8"로 설정합니다. 
		//	이렇게 함으로써 클라이언트로부터 전달받은 데이터가 UTF-8로 인코딩되어 있음을 명시합니다.
		request.setCharacterEncoding("utf-8");
		String comments = request.getParameter("comments");
		System.out.println("comments : " + comments);

		//	서버에 업로드할 파일들을 저장할 디렉토리를 가리키는 File 객체를 생성합니다. uploadPath 변수에 저장된 경로를 기반으로 디렉토리를 가리키게 됩니다.
		File file = new File(uploadPath);
		
//		만약 해당 디렉토리가 존재하지 않으면, mkdirs() 메서드를 사용하여 디렉토리를 생성합니다. 
//		이렇게 함으로써 파일을 저장할 디렉토리가 미리 생성되어 있도록 합니다.
		if (!file.exists()) {
			file.mkdirs();
		}
		
		// 멀티 파일 업로드 파일인 경우...
//		업로드된 파일들의 이름을 저장하기 위한 문자열 리스트인 fileNames를 생성합니다.
		List<String> fileNames = new ArrayList<String>();
//		클라이언트로부터 전달된 모든 파일의 정보를 얻어옵니다. 
//		멀티 파일 업로드를 처리하기 위해 반복문을 사용하여 각 파일에 대한 처리를 수행합니다.
		for (Part part : request.getParts()) {
//			현재 처리 중인 파일에 대한 이름을 얻어옵니다
			String fileName = part.getSubmittedFileName();
//			리스트에 현재 파일의 이름을 추가합니다. 이렇게 함으로써 업로드된 모든 파일들의 이름을 리스트에 저장하게 됩니다.
			fileNames.add(fileName);
//			현재 파일이 업로드된 경우에만 처리를 수행합니다.
			if (fileName != null) {
				try {
					/*
					현재 파일을 서버에 지정된 uploadPath에 저장합니다. uploadPath는 파일이 업로드될 디렉토리 경로를 나타내며, 
					파일의 이름은 클라이언트로부터 얻어온 원래 파일의 이름을 사용합니다. 따라서 업로드된 파일들이 지정된 디렉토리에 저장되게 됩니다.
					*/
					part.write(uploadPath + fileName);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		out.println("파일 처리 완료!!!");
	}
}




