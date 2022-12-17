package com.kind.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kind.dto.AdoptionRecordDto;
import com.kind.utils.Utils;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RestController 
@RequestMapping("/kind") 
public class KindController {
	
	@Autowired
	Utils utils;
	
	
	/**
	 * 1. https://medium.com/@pankajsingla_24995/multipart-request-with-request-body-using-spring-boot-and-test-using-postman-6ea46b71b75d
	 * 	  this article talks about how to make the request successful via postman but does not talk about sending both request parts as files 
	 *    even from the frontend.
	 * 2. https://stackoverflow.com/questions/50774176/sending-file-and-json-in-post-multipart-form-data-request-with-axios
	 *    First answer from the above link talks about converting the JSON object to file and sending adoptionRecord also as file.
	 * 
	 * */
	@CrossOrigin("*")
	@PostMapping(path = "/adoptionRecord", consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	@ApiOperation(notes = "", value = "The swagger request does not work,try postman and upload file and requestBody JSON as a file too")
	public String adoptionRecord(@RequestPart("document") MultipartFile document,@RequestPart("adoptionRecord") AdoptionRecordDto adoptionRecord)  {
		

	   
	    return "recieved";
	}
	


}
