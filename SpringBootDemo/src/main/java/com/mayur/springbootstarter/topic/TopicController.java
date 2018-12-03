package com.mayur.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;

	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}

	@RequestMapping("/topics/{id}")
	public Topic getTopicById(@PathVariable String id) {
		return topicService.getTopicById(id);
	}

	@RequestMapping(value = "/topics", method = RequestMethod.POST)
	public String addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
		return "topic added success fully";
	}

	@RequestMapping(value = "/topics/{id}", method = RequestMethod.PUT)
	public String updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(topic, id);
		return "topic updated success fully";
	}

	@RequestMapping(value = "/topics/{id}", method = RequestMethod.DELETE)
	public String deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
		return "topic updated success fully";
	}
}
