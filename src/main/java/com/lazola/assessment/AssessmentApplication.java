package com.lazola.assessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
	public ResponseEntity<String> convertKelvintoCelsius(@RequestParam(value = "kelvin")Double kelvin) throws Exception{
		if(kelvin != null){
			return new ResponseEntity<>(String.format("Celsius : %.2f",Double.valueOf(kelvin) - 273.15D), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Please enter a valid kelvin value",HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/conversions/ctok")
	public ResponseEntity<String> convertCelsiustoKelvin(@RequestParam(value = "celsius")Double celsius) throws Exception{
		if(celsius != null){
			return new ResponseEntity<>(String.format("Kelvin : %.2f", Double.valueOf(celsius) + 273.15D ), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Please enter a valid celsius value", HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/conversions/mtok")
	public ResponseEntity<String> convertMilesToKilometers(@RequestParam(value = "miles") Double miles) throws Exception{
		if(miles != null){
			return new ResponseEntity<>(String.format("Kilometers : %.3f", Double.valueOf(miles) * 1.609D ), HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Please enter a valid miles value", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/conversions/ktom")
	public ResponseEntity<String> convertKilometersToMiles(@RequestParam(value = "km")Double km) throws Exception{
		if(km != null){
			return new ResponseEntity<>(String.format("Miles : %.3f", Double.valueOf(km) / 1.609D), HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Please enter a valid kilometer value", HttpStatus.BAD_REQUEST);
		}
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<String> handleMissingParameter(MissingServletRequestParameterException ex){
		String name = ex.getParameterName();
		return new ResponseEntity<>(String.format("%s url parameter is missing", name),HttpStatus.BAD_REQUEST);
	}

}
