package com.kind.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor 
@ToString
public class AdoptionRecordDto {
	
	String emailAddress;
	
	String phoneNumber;
	
	String description;
	
	MultipartFile file;

}
