package com.ezen.springmvc.web.demo.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UploadFile {

//	파일 업로드시 a.txt 가 이미 존재하고 있을시 기존 파일은 살려두고 
private String uploadFileName;
private String storeFileName;

}
