package io.brains.springbootstarter.model;

import io.swagger.annotations.ApiModelProperty;

public class Topic {
	@ApiModelProperty(notes = "The database generated topic ID")
	private String id;
	 @ApiModelProperty(notes = "The database generated topic name")
	private String name;
	 @ApiModelProperty(notes = "The database generated topic description")
	private String description;
	
	
	public Topic() {
		
	}
	public Topic(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
