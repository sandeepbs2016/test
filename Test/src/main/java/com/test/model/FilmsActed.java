package com.test.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "FILM_ACTOR")
@EntityListeners(AuditingEntityListener.class)
public class FilmsActed {

	@Id
	@Column(name = "FILM_ID")	
	private Long filmId;
	
	@Column(name = "ACTOR_ID")
	private Long actorId;

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "actorId", cascade = CascadeType.ALL)
//	private List<Film> filmList;
//	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "filmId", cascade = CascadeType.ALL)
//	private List<Actor> actorList;
	
	public FilmsActed() {

	}

	public FilmsActed(Long filmId, Long actorId) {
		super();
		this.filmId = filmId;
		this.actorId = actorId;
	}

	public Long getFilmId() {
		return filmId;
	}
	public void setFilmId(Long filmId) {
		this.filmId = filmId;
	}

	public Long getActorId() {
		return actorId;
	}
	public void setActorId(Long actorId) {
		this.actorId = actorId;
	}
	
}
