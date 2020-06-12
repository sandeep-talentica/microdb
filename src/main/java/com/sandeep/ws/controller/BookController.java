package com.sandeep.ws.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandeep.ws.aop.api.advice.LogMethodParam;
import com.sandeep.ws.model.Data;
import com.sandeep.ws.services.DataService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/books")
@Slf4j
@Api(value = "onlineBookstore", description = "You can see the author and corresponding sub-authors ")
public class BookController {

	@Autowired
	private DataService dataService;

	@ApiOperation(value = "View a list of all available books", response = Iterable.class)
	@GetMapping
	public Iterable findAll() {

		log.info("Finding all books");
		return dataService.findAll();
	}
	@ApiOperation(value = "Find book by a particular id", response = Iterable.class)
	@GetMapping(value = "/{id}")
	@LogMethodParam
	public ResponseEntity<Optional<Data>> getById(@PathVariable Long id) {

		Optional<Data> data = dataService.findById(id);
		return new ResponseEntity<Optional<Data>>(data, new HttpHeaders(), HttpStatus.OK);
	}

}
