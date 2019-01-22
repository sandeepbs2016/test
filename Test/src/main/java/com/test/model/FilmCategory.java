package com.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "FILM_CATEGORY")
@EntityListeners(AuditingEntityListener.class)
public class FilmCategory {

	@Id
	@Column(name="FILM_ID")
	private Long filmId;
	
	@Column(name="CATEGORY_ID")
	private Long categoryId;
	
	public FilmCategory () {
		
	}
	
	public FilmCategory (Long filmId, Long categoryId) {
		this.filmId = filmId;
		this.categoryId = categoryId;
	}
	
	public Long getFilmId() {
		return filmId;
	}
	public void setFilmId(Long filmId) {
		this.filmId = filmId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
	
}
