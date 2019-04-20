package io.brains.springbootstarter.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.brains.springbootstarter.model.Topic;
import io.brains.springbootstarter.service.TopicServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/v1")
@Api(value="Topic API", description="operations on Topics")
public class TopicController {
	
	@Autowired
	private TopicServiceImpl topicService;
	
	@RequestMapping("/topics")
	@ApiOperation(value = "View a list of available topics", response = Topic.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved topic"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
	public List<Topic> getAllTopics() {
		
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	@ApiOperation(value = "View a list of available topic", response = Topic.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved topic"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
	public Topic getTopic( @ApiParam(value = "id", required = true) @PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	@ApiOperation(value = "Create a topic", response = Void.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 201, message = "Successfully created topic"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
	public void addTopic(@ApiParam(value = "topic", required = true) @RequestBody Topic topic) {
		topicService.addTopic(topic);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	@ApiOperation(value = "update topic", response = Void.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully updated topic"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(id,topic);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	@ApiOperation(value = "Delete topic", response = Void.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully deleted topic"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}
	
}
