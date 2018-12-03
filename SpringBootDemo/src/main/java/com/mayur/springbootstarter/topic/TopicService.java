package com.mayur.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(new Topic("1", "Maths", "Calculus, trignometery"),
			new Topic("2", "Maths", "Calculus, trignometery")));

	public List<Topic> getAllTopics() {
		return topics;
	}

	public Topic getTopicById(String id) {
		Topic topic = null;
		for (Topic t : topics) {
			if (t.getId().equals(id)) {
				return t;
			}
		}
		return null;
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(Topic topic, String id) {
		for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if (t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}
}
