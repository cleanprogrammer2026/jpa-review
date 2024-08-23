package com.pallysystems.datajpa;

import com.pallysystems.datajpa.utils.response.ApiResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@SpringBootApplication
public class DataJPAApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataJPAApplication.class, args);
	}

}
