package com.sandeep.ws.service.impl;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import com.sandeep.ws.aop.api.advice.LogMethodParam;
import com.sandeep.ws.model.Data;
import com.sandeep.ws.model.Output;
import com.sandeep.ws.repo.DataRepository;
import com.sandeep.ws.services.DataService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DataServiceImpl implements DataService {

	@Autowired
	private DataRepository dataRepository;

	@Override
	public Iterable findAll() {
		log.info("Finding all data service");
		Iterable<Data> list = dataRepository.findAll();
		Map<Long, ArrayList<String>> hashMap = new HashMap<Long, ArrayList<String>>();
		ArrayList<String> listOfName = null;

		for (Data data : list) {

			Long parentid = data.getParentId();

			if (!hashMap.containsKey(parentid)) {
				listOfName = new ArrayList<String>();
				listOfName.add("Name : " + data.getName());
				hashMap.put(parentid, listOfName);
			} else {
				ArrayList<String> arrLst = hashMap.get(parentid);

				arrLst.add("Name : " + data.getName());
				hashMap.put(parentid, arrLst);
			}
		}
		Output output = null;
		List<Output> listOfOutput = new ArrayList<Output>();
		for (Data data : list) {

			if (hashMap.containsKey(data.getId())) {

				output = new Output();
				output.setName(data.getName());
				output.setSubClass(hashMap.get(data.getId()));
				listOfOutput.add(output);
			}
		}
		return listOfOutput;
	}

	@Override
	@LogMethodParam
	public Optional<Data> findById(Long id) {

		return dataRepository.findById(id);
	}

}
