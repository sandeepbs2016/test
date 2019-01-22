package com.test.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "LANGUAGE")
@EntityListeners(AuditingEntityListener.class)
public class Language {

	@Id
	@Column(name = "LANGUAGE_ID")
	private Long languageId;
	
	@Column(name = "NAME")
	private String name;
	
	public Language () {
		
	}
	
	public Language (Long languageId, String name) {
		this.languageId = languageId;
		this.name = name;
	}
	
	public Long getLanguageId() {
		return languageId;
	}
	public void setLanguageId(Long languageId) {
		this.languageId = languageId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
