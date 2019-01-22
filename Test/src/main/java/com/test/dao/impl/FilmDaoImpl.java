package com.test.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.data.querydsl.QSort;
import org.springframework.stereotype.Service;

import com.test.dao.IFilmDao;
import com.test.model.Film;

@Service
public class FilmDaoImpl {

	@Autowired
	IFilmDao fimlDao;
	
	public List<Film> findAll() {
		List<Film> flmLst = new ArrayList<>();
		fimlDao.findAll().forEach(flmLst :: add);
		return flmLst;
	}
	
	public Page<Film> findJsonDataByCondition(String orderBy, String direction, int page, int size) {
		System.out.println("direction :"+direction);
		System.out.println("orderBy : "+orderBy);
		System.out.println("page : "+ page);
		System.out.println("size : "+ size);
		Page<Film> data = null;
		if (direction.equalsIgnoreCase("ASC")) {
			data = fimlDao.findAll(PageRequest.of(page, size, Direction.ASC, orderBy));
		}

		if (direction.equalsIgnoreCase("DESC")) {
			data = fimlDao.findAll(PageRequest.of(page, size, Direction.DESC, orderBy));
		}
		return data;
	}
	
	
}
