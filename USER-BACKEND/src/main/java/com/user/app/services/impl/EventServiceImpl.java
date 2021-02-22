package com.user.app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.user.app.entities.Event;
import com.user.app.repository.EventRepos;
import com.user.app.services.EventService;

@Service
public class EventServiceImpl implements EventService {
	
	@Autowired
	private EventRepos eventRepos;

	@Override
	public Page<Event> getAll(Pageable pageable, String keyword) {
		if (keyword.contentEquals("")) {
			return eventRepos.findAll(pageable);
		}
		return eventRepos.findAll(pageable, keyword);
	}

	@Override
	public Event getById(long id) {
		return null;
	}

	@Override
	public String deleteById(long id) {
		return null;
	}

	@Override
	public Event save(Event event) {
		return null;
	}

	@Override
	public List<Event> saveList(List<Event> listEvent) {
		return eventRepos.saveAll(listEvent);
	}

}
