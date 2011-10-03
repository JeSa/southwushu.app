package com.southwushu.app.models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="attachments")
public class Attachment {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	@Lob
	@Column(length=5000)
	private byte[] value;
	
	@ManyToMany
	@JoinTable(name="person_attachments")
	private List<Person> students; 
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
