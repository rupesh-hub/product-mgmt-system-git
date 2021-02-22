package com.user.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.user.app.entities.Event;

@Repository
public interface EventRepos extends JpaRepository<Event, Long> {
	@Query("SELECT e FROM Event e "
			+ "where e.title LIKE %?1% " 
			+ "OR e.description LIKE %?1% " 
			+ "OR e.date LIKE %?1% ")
	public Page<Event> findAll(Pageable pageable, String keyword);
}
