package com.user.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.app.entities.Event;
import com.user.app.services.EventService;

@RestController
@RequestMapping(path = "/api/v1")
//@CrossOrigin(origins="http://localhost:4200", allowedHeaders = "*")
public class EventController {

	@Autowired
	private EventService eventService;

	@GetMapping(path = "/get-events")
	public ResponseEntity<Page<Event>> getAll(@RequestParam("page") int page,
			@RequestParam("limit") int limit,
			@RequestParam("keyword") String keyword) {
		Pageable pageable = PageRequest.of(page-1, limit);
		return ResponseEntity.ok().body(eventService.getAll(pageable, keyword));
	}
}
