package com.sandeep.ws.services;

import java.util.Optional;

import com.sandeep.ws.model.Data;

public interface DataService {

	Iterable findAll();
	Optional<Data> findById(Long id);
}
