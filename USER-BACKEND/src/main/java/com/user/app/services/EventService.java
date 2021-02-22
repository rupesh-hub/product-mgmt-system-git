package com.user.app.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.user.app.entities.Event;

public interface EventService {

	public abstract Page<Event> getAll(Pageable pageable, String keyword);

	public abstract Event getById(long id);

	public abstract String deleteById(long id);
	
	public abstract Event save(Event event);
	
	public abstract List<Event> saveList(List<Event> listEvent);
}
