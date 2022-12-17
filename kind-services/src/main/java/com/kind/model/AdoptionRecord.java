package com.kind.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor 
@ToString
public class AdoptionRecord {
	
	String emailAddress;
	
	String phoneNumber;
	
	String description;
	
	MultipartFile file;

}
