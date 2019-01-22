package com.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "FILM")
@EntityListeners(AuditingEntityListener.class)
public class Film {

	@Id
	@Column(name = "FILM_ID")
	private Long filmId;
	
	@Column(name = "LANGUAGE_ID")
	private Long languageId;
	
	@Column(name = "RELEASE_YEAR")
	private Long releaseYear;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "RATING")
	private String rating;
	
	@Column(name = "DESCRIPTION")
	private String descritption;
	
	public Film() {
		
	}

	public Film(Long filmId, Long languageId, Long releaseYear, String title, String rating, String descritption) {
		super();
		this.filmId = filmId;
		this.languageId = languageId;
		this.releaseYear = releaseYear;
		this.title = title;
		this.rating = rating;
		this.descritption = descritption;
	}

	public Long getFilmId() {
		return filmId;
	}
	public void setFilmId(Long filmId) {
		this.filmId = filmId;
	}

	public Long getLanguageId() {
		return languageId;
	}
	public void setLanguageId(Long languageId) {
		this.languageId = languageId;
	}

	public Long getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(Long releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getDescritption() {
		return descritption;
	}
	public void setDescritption(String descritption) {
		this.descritption = descritption;
	}
	
	
}
