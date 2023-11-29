package com.alumnosrestapisql.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alumnosrestapisql.app.entity.Alumnos;
import com.alumnosrestapisql.app.service.IAlumnosService;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("api/alumnos")
public class AlumnosController {
	
	@Autowired
	private IAlumnosService alumnosService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Alumnos alumnos){
		return ResponseEntity.status(HttpStatus.CREATED).body(alumnosService.save(alumnos));
	}
	
	@GetMapping("/alumnos")
	public ResponseEntity<List<Alumnos>> getAllAlumnos(@RequestParam(required = false) String title) {
		try {
			List<Alumnos> alumnos = new ArrayList<Alumnos>();
 
			if (title == null)
				alumnosService.findAll().forEach(alumnos::add);
			else
				//alumnosRepository.findByTitleContaining(title).forEach(tutorials::add);
 
			if (alumnos.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
 
			return new ResponseEntity<>(alumnos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value="id") Long alumnosId){
		Optional<Alumnos> oAlumnos=alumnosService.findById(alumnosId);
		
		if(!oAlumnos.isPresent()) {
			return ResponseEntity.notFound().build();
		}
			
		return ResponseEntity.ok(oAlumnos);
	}
}
