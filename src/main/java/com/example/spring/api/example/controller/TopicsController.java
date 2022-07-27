package com.example.spring.api.example.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.spring.api.example.controller.dto.TopicDetailDto;
import com.example.spring.api.example.controller.dto.TopicDto;
import com.example.spring.api.example.controller.form.TopicForm;
import com.example.spring.api.example.controller.form.UpdateTopicForm;
import com.example.spring.api.example.model.TopicModel;
import com.example.spring.api.example.repository.CourseRepository;
import com.example.spring.api.example.repository.TopicRepository;

@RestController
@RequestMapping(value = "/topics")
public class TopicsController {

	@Autowired
	private TopicRepository topicRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@GetMapping
	public List<TopicDto> list(String courseName) {
		List<TopicModel> topics = new ArrayList<TopicModel>();
		
		if(courseName != null) {
			topics = topicRepository.findByCourseName(courseName);
		} else {
			topics = topicRepository.findAll();
		}
		
		return TopicDto.convert(topics);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<TopicDto> save(@RequestBody @Valid TopicForm topicForm, UriComponentsBuilder uriBuilder) {
		TopicModel topic = topicForm.convert(getCourseRepository());
		topicRepository.save(topic);
		
		URI uri = uriBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicDto(topic));
	}

	@GetMapping("/{id}")
	public ResponseEntity<TopicDetailDto> detail(@PathVariable Long id) {
		Optional<TopicModel> topic = topicRepository.findById(id);
		ResponseEntity<TopicDetailDto> result = null;
		if(topic.isPresent()) {
			result = ResponseEntity.ok(new TopicDetailDto(topic.get()));
		}
		else
		{
			result = ResponseEntity.notFound().build();
		}
		
		return result;
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<TopicDto> update(@PathVariable Long id, @RequestBody @Valid UpdateTopicForm topicForm) {
		Optional<TopicModel> optional = topicRepository.findById(id);
		ResponseEntity<TopicDto> result = null;
		
		if(optional.isPresent()) {
			TopicModel topic = topicForm.update(id, topicRepository);
			result = ResponseEntity.ok(new TopicDto(topic));
		}
		else
		{
			result = ResponseEntity.notFound().build();
		}
		
		return result;
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Optional<TopicModel> optional = topicRepository.findById(id);
		ResponseEntity<TopicDto> result = null;
		
		if(optional.isPresent()) {
			topicRepository.deleteById(id);
			result = ResponseEntity.ok().build();
		}
		else
		{
			result = ResponseEntity.notFound().build();
		}
		
		return result;
	}
	
	public TopicRepository getTopicRepository() {
		return topicRepository;
	}

	public void setTopicRepository(TopicRepository topicRepository) {
		this.topicRepository = topicRepository;
	}

	public CourseRepository getCourseRepository() {
		return courseRepository;
	}

	public void setCourseRepository(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}
}