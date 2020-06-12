package com.sandeep.ws.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sandeep.ws.model.Data;

public interface DataRepository extends CrudRepository<Data, Long>  {

	 Optional<Data> findById(Long id);
}
