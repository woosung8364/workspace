package com.ezen.springmvc.web.demo.controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Controller
@Slf4j
public class FileUploadDownloadController {

//	application.property 파일에 저장된 파일 주소를 location 변수에 저장
	@Value("${file.dir}")
	private String location;

	private final com.ezen.springmvc.web.demo.controller.FileStore fileStore;

	@GetMapping("/upload2")
	public String uploadForm() {
		log.info(fileStore.toString());
		return "form2";

	}

	@PostMapping("/upload2")
//	@ModelAttribute : 객체 전체를 리턴
	public String uploadFiles(@ModelAttribute MemberForm memberForm, RedirectAttributes redirectAttributes)

			throws IOException {

		// 디버깅~~
		log.info("업로드 파일: {}", memberForm.getUploadfiles());

//		multipartFile들 list 불러옴
		List<UploadFile> uploadFiles = fileStore.storeFiles(memberForm.getUploadfiles());

		log.info("저장된파일명 : {}", uploadFiles);
		// 데이터베이스에 오리지날파일명과 저장파일명 저장(테이블의 컬럼이 두개 필요하다)
//		addFlashAttribute : 내용이 바뀔때마다 새로 업데이트되는 메소드
//		플래시에 추가 (키 , 값)
		redirectAttributes.addFlashAttribute("uploader", memberForm.getUploader());
		redirectAttributes.addFlashAttribute("uploadfiles", uploadFiles);
		return "redirect:/upload-result2";

	}

	@GetMapping("/upload-result2")
	public String uploadResult() {

		return "upload-result2";

	}
	
	
//	download @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

	@GetMapping("/download")
	public String download(Model model) {

//		location 변수에 저장된 디렉토리 아래 파일들을 directory 변수에 저장
		File directory = new File(location);
//		File 객체를 사용하여 파일들을 배열로 가져옴
		File[] files = directory.listFiles();
		
//		model 에 list라는 이름으로 파일들의 값 저장
		model.addAttribute("list", files);
		return "download";

	}

	
	@GetMapping("/download/{fileName}")
	public ResponseEntity<Resource> download(@PathVariable String fileName) throws IOException {
		
//		다운로드할 파일의 경로를 생성
		Path path = Paths.get(location + "/" + fileName);
//		파일의 MIME 타입을 추론하여 contentType 설정
		String contentType = Files.probeContentType(path);
		
//		HttpHeaders 파일다운로드를 위한 응답 헤더 클래스
		HttpHeaders headers = new HttpHeaders();
		
		// 응답 헤더에 파일 다운로드 정보 설정
		headers.setContentDisposition(
//				브라우저에게 서버가 반환한 데이터를 어떻게 처리할지를 알려주는 역할을 하는
//				ContentDisposition 클래스를 생성
//				.filename(fileName) : 파일의 이름 설정 
//				StandardCharsets.UTF_8 : 파일의 이름을 utf-8 로 설정
				ContentDisposition.builder("attachment").filename(fileName, StandardCharsets.UTF_8).build());

		headers.add(HttpHeaders.CONTENT_TYPE, contentType);
		
		
		// 다운로드할 파일을 읽어들이는 InputStream 생성
		org.springframework.core.io.Resource resource = new InputStreamResource(Files.newInputStream(path));
		
		// ResponseEntity를 사용하여 파일 다운로드 응답 생성
		return new ResponseEntity<org.springframework.core.io.Resource>(resource, headers, HttpStatus.OK);

	}

	// 동적 이미지의 경우 출력
	@GetMapping("/images/{name}")
	@ResponseBody
	public ResponseEntity<Resource> showImage(@PathVariable String name) throws IOException {
//		이미지 파일의 경로 지정
		Path path = Paths.get(location + "/" + name);
		
//		이미지 파일의 Mime 타입 판별
		String contentType = Files.probeContentType(path);
		
//		이미지 파일을 Resource 인터페이스를 구현한 객체로 생성합니다. 
//		이 객체를 사용하여 파일의 내용을 읽어올 수 있습니다.
		Resource resource = new FileSystemResource(path);
		
//		HttpHeaders headers = new HttpHeaders();: 
//		새로운 HttpHeaders 객체를 생성하여 응답 헤더를 설정할 준비를 합니다.
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, contentType);
		
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);

	}
}
