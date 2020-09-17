package com.lazola.assessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AssessmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssessmentApplication.class, args);
	}


	@GetMapping("/conversions/ktoc")
	public ResponseEntity<String> convertKtoC(@RequestParam(value = "kelvin")Double kelvin) throws Exception{
		if(kelvin != null){
			return new ResponseEntity<>(String.format("Celcius : %.2f",Double.valueOf(kelvin) - 273.15d), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Please enter a valid kelvin value",HttpStatus.BAD_REQUEST);
		}
	}

}
