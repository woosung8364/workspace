package com.ezen.springmvc.web.demo.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class FileUploadController {

// @Value : application.properties 에 설정된 파일 경로를 읽어오는 애노테이션
//	String loaction = "C:/ezen-fullstack/workspace/spring_mvc/upload" 과 같음
	@Value("${file.dir}")
	private String location;

//	파일 업로드 화면 요청 : /upload 경로로 요청이 들어왔을때 아래 메소드를 실행하겠다
	@GetMapping("/upload")
	public String uploadForm() {
		
//		jsp 파일의 이름을 나타내는 view - name 리턴
		return "form";

	}

	@PostMapping("/upload")
//	@RequestParam ("파라미터이름") : 해당파라미터의 값을 메서드의 매게변수로 대입하는 역할
	public String uploadFile(@RequestParam("uploader") String uploader,

			@RequestParam("uploadfile") MultipartFile uploadfile, Model model) throws IOException {

		log.info("업로더 = {}", uploader);
		log.info("multipartFile = {}", uploadfile);
		
//		파일이 빈 파일이 아닌경우 해당 코드를 실행
//		isEmplty 와 getOrginalFilename 그리고 transferTo 은  MultipartFile 클래스의 메서드임
		if (!uploadfile.isEmpty()) {

			
			String fullPath = location + uploadfile.getOriginalFilename();
			log.info("파일 저장 fullPath = {}", fullPath);
			File uploadDir = new File(fullPath);
			if (!uploadDir.exists()) {
				uploadDir.mkdirs();

			}
			
//			업로드 파일 저장 완료
			uploadfile.transferTo(uploadDir);
			
//			모델 객체에 추가
			model.addAttribute("uploader", uploader);
			model.addAttribute("uploadfile", uploadfile.getOriginalFilename());

		}
		return "upload-result";

	}

}