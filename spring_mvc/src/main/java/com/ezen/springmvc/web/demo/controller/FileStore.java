package com.ezen.springmvc.web.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

/**
 * 파일 업로드 처리 및 관리
 * 
 * @author i7C- 송우성
 *
 */
@Slf4j
@Component
public class FileStore {
	// 업로드 된 파일 저장 및 관리

//	C:/ezen-fullstack/workspace/spring_mvc/upload/
	@Value("${file.dir}")
	private String location;

	
//	파일경로주소에 파일이름을 붙여서 리턴
	public String getFullPath(String filename) {
		return location + filename;

	}

	public List<UploadFile> storeFiles(List<MultipartFile> multipartFiles) throws IOException {

//		UploadFile 들의 list 를 storeFileResult 변수로 선언
		List<UploadFile> storeFileResult = new ArrayList<UploadFile>();
		for (MultipartFile multipartFile : multipartFiles) {

			if (!multipartFile.isEmpty()) {
				// 업로드 파일 저장
				UploadFile uploadFile = storeFile(multipartFile);
				storeFileResult.add(uploadFile);

			}

		}
		return storeFileResult;

	}
	
	
	public UploadFile storeFile(MultipartFile multipartFile) throws IOException {
		if (multipartFile == null || multipartFile.isEmpty()) {

		return null;

		}
		String originalFilename = multipartFile.getOriginalFilename();
//										1
		String storeFileName = createStoreFileName(originalFilename);
		log.info("사용자가 업로드한 파일명 : {}",originalFilename);
		log.info("실제 저장된 파일명: {}",storeFileName);
		
		multipartFile.transferTo(new File(getFullPath(storeFileName)));
		return new UploadFile(originalFilename, storeFileName);

		}
	
//		파일 중복 체크
//														2
		private String createStoreFileName(String originalFilename) {
			
//			파일 풀네임에서 순수한 파일이름만 추출
		String ext = extractExt(originalFilename);
//			
		String uuid = UUID.randomUUID().toString();
		return originalFilename + "-" + uuid + "." + ext;

		}
		private String extractExt(String originalFilename) {
		int pos = originalFilename.lastIndexOf(".");
		return originalFilename.substring(pos + 1);

		}
}
