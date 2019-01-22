package com.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.model.Film;

public interface IFilmDao extends JpaRepository<Film, Long> {

}
