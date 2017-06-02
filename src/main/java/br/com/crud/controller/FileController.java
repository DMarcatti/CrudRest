package br.com.crud.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Exemplo Spring Boot, Rest, jdbcTemplate, PostGres 
 * @author Diego Marcatti
 * @version 1.0 - 30/05/17
 * @since 30/05/17
 */


@RestController
@Api(value = "file")
public class FileController {
     
	private static final String DIR_UPLOAD = "";
	
	
    @ApiOperation(value = "upload", notes = "Upload de Arquivo")
    @RequestMapping(value="/upload" , method=RequestMethod.POST)
    @CrossOrigin()
    public ResponseEntity<?> uploadFile(
    		@RequestPart(required = true) MultipartFile uploadfile)
    {
        if (uploadfile.isEmpty()) { 
            return new ResponseEntity<Object>("please select a file!", HttpStatus.OK);
        }
        try {
        	saveUploadedFiles(Arrays.asList(uploadfile), "/home/marcatti/tmp/upload/");
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Object>("Successfully uploaded - " +
                uploadfile.getOriginalFilename(), new HttpHeaders(), HttpStatus.OK);

    }
    
    @ApiOperation(value = "download", notes = "Download de Arquivo")
    @RequestMapping(value = "/download/{file_name:.+}", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> downloadFile(@PathVariable String file_name)
                                                                      throws IOException {
        //String fullPath = stuffService.figureOutFileNameFor(stuffId);
        File file = new File("/home/marcatti/tmp/upload/" + file_name);

        HttpHeaders respHeaders = new HttpHeaders();
        //respHeaders.setContentType("application/pdf");
        respHeaders.setContentLength(file.toString().length());
        respHeaders.setContentDispositionFormData("attachment", file.getName());

        InputStreamResource isr = new InputStreamResource(new FileInputStream(file));
        return new ResponseEntity<InputStreamResource>(isr, respHeaders, HttpStatus.OK);
    } 

    //save file
    private void saveUploadedFiles(List<MultipartFile> files, String fileOutpath ) throws IOException {
    	for (MultipartFile file : files) {
            if (file.isEmpty()) {
                continue; //next pls
            }
            byte[] bytes = file.getBytes();
            java.nio.file.Path path = Paths.get(fileOutpath + file.getOriginalFilename());
            Files.write(path, bytes);            
        }
    }    
    
	
}
