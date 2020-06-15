package com.sandeep.ws.model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_data")
public class Data {

	@Id
	private Long id;
	@Column(name = "parentid")
	private Long parentId;
	@Column(name = "name")
	private String name;
	@Column(name = "colour")
	private String colour;

	public Data() {
	}

	public Data(Long id, Long parentId, String name, String colour) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.name = name;
		this.colour = colour;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	@Override
	public String toString() {
		return "Data [id=" + id + ", parentId=" + parentId + ", name=" + name + ", colour=" + colour + "]";
	}

}
