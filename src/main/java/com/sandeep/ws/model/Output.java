package com.sandeep.ws.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_EMPTY)
public class Output {
	@JsonProperty("Name")
	public String name;
	@JsonProperty("Sub Classes")
	public ArrayList<Output> subClasses;

	public Output(String name) {
		this.name = name;
		subClasses = new ArrayList<Output>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Output> getSubClasses() {
		return subClasses;
	}

	public void setSubClasses(ArrayList<Output> subClasses) {
		this.subClasses = subClasses;
	}

}
