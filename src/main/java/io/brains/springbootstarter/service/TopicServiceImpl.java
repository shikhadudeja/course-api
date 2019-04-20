package io.brains.springbootstarter.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import io.brains.springbootstarter.model.Topic;

@Service
public class TopicServiceImpl {
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("spring","springframework","Spring Framwork Description"),
			new Topic("java","java/j2ee","java Description"),
			new Topic("js","JS","SS Framwork Description")));
	
	public List<Topic> getAllTopics(){
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topics.stream().filter(t->t.getId().equalsIgnoreCase(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
		
	}

	public void updateTopic(String id, Topic topic) {
		for(int i=0;i<topics.size();i++) {
			Topic t = topics.get(i);
			if(t.getId().equalsIgnoreCase(id)) {
				topics.set(i, topic);
				return;
			}
		}
		
	}

	public void deleteTopic(String id) {
		topics.removeIf(t->t.getId().equalsIgnoreCase(id));
		}
		
	}
