package com.sandeep.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandeep.ws.repo.BookRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/books")
@Slf4j
@Api(value="onlineBookstore", description="Operations pertaining to products in Online Store")
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	@ApiOperation(value = "View a list of available products", response = Iterable.class)
	@GetMapping
	public Iterable findAll() {

		log.info("Finding all books");
		return bookRepository.findAll();
	}

	@GetMapping(value = "/check")
	public String check() {

		return "Running fine";
	}

}
