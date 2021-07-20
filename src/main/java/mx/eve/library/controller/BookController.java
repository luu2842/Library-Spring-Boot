package mx.eve.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.eve.library.domain.Book;
import mx.eve.library.dto.BookDto;
import mx.eve.library.service.interfaces.BookI;

@RestController
@RequestMapping("book")
public class BookController {
	
	@Autowired
	BookI service;
	
	@GetMapping()
	public ResponseEntity<List<Book>> index() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> show(
			@PathVariable Long id ){
		return new ResponseEntity<>(service.get(id), HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Book> save(@RequestBody BookDto dto){
		return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Book> update(
			@PathVariable Long id, @RequestBody BookDto dto){
				return new ResponseEntity<>(service.update(id, dto) , HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(
			@PathVariable Long id){
		service.delete(id);
		return new ResponseEntity<>("Book was deleted", HttpStatus.ACCEPTED);
	}
	
	



}
