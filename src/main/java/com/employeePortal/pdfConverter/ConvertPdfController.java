package com.employeePortal.pdfConverter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeePortal.entity.ProfileInformation;
import com.employeePortal.repository.ProfileRepository;

@RestController
@RequestMapping("/api/v1/PDFConvert")
public class ConvertPdfController {
	
	@Autowired
	private ProfileRepository profileRepository;
	
	@GetMapping(value = "/Download/employees", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> employeeReport()  throws IOException {
	    List<ProfileInformation> employees = this.profileRepository.findAll();

	    ByteArrayInputStream bis = PdfService.employeePDFReport(employees);

	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Content-Disposition", "attachment; filename=employees.pdf"); // Change to attachment

	    return ResponseEntity.ok()
	            .headers(headers)
	            .contentType(MediaType.APPLICATION_PDF)
	            .body(new InputStreamResource(bis));
	}

}
