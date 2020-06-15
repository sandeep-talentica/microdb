package com.sandeep.ws.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

		Iterable<Data> dbList = dataRepository.findAll();
		Map<Long, Output> processmap = new HashMap<Long, Output>();
		Map<Long, Long> parentChildMap = new HashMap<Long, Long>();
		List<Output> outputList = null;
		for (Data data : dbList) {
			// storing item
			Long parentid = data.getParentId();
			parentChildMap.put(data.getId(), parentid);
			String name = data.getName();
			Output item = processmap.get(data.getId());
			if (item == null) {
				item = new Output(name);
				processmap.put(data.getId(), item);
			} else
				item.setName(name);

			// storing parent

			if (!processmap.containsKey(parentid))
				processmap.put(parentid, new Output(""));
			processmap.get(parentid).subClasses.add(item);
		}

		outputList = new ArrayList<Output>();
		for (Entry<Long, Output> processMapEntry : processmap.entrySet()) {

			Long key = processMapEntry.getKey();
			Long parentId = parentChildMap.get(key);
			if (parentId == null)
				continue;
			if (parentId == 0)
				outputList.add(processMapEntry.getValue());

		}
		Iterable<Output> iterable = outputList;

		return iterable;

	}

	@Override
	@LogMethodParam
	public Optional<Data> findById(Long id) {

		return dataRepository.findById(id);
	}

}
