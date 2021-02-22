package com.user.app.entities;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tbl_event")
@DynamicUpdate
@Getter
@Setter
@ToString
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String title;
	private String description;
	private Date date;
	
	public Event(String title, String description, Date date) {
		this.title = title;
		this.description = description;
		this.date = date;
	}
	public Event() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
