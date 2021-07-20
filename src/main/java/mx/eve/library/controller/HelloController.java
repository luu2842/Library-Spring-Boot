package mx.eve.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.eve.library.service.RestClient;
import mx.eve.library.service.interfaces.IHello;

@RestController
@RequestMapping("hello")
public class HelloController {
	
	@Autowired
	IHello hello;
	
	@Autowired
    RestClient restclient;

	@GetMapping(value = "/{age}")
	public ResponseEntity<String> grettings(
			@PathVariable("age") int age,
			@RequestParam(value = "name", required = true) String name ) {
		return new ResponseEntity<>( hello.grettings(name,age), HttpStatus.ACCEPTED );
	}
	

	@GetMapping(value = "/")
	public ResponseEntity<String> client() {
		return new ResponseEntity<>( restclient.get("/posts/1"), HttpStatus.OK );
	}
}
