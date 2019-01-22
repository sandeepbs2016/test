package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.dao.impl.FilmDaoImpl;
import com.test.model.Film;
import com.test.pagination.enums.OrderBy;
import com.test.pagination.enums.Direction;
import com.test.pagination.exception.PaginationSortingException;
import com.test.pagination.exception.PagingSortingErrorResponse;

@RestController
@RequestMapping("/imdb")
public class IMDBController {

	@Autowired
	private FilmDaoImpl filmDaoImpl;

	@GetMapping("/films")
	public List<Film> getAllFilms() {
		return filmDaoImpl.findAll();
	}

	@RequestMapping(value = "/pagination", params = { "orderBy", "direction", "page",
			"size" }, method = RequestMethod.GET)
	@ResponseBody
	public Page<Film> findJsonDataByPageAndSize(@RequestParam("orderBy") String orderBy,
			@RequestParam("direction") String direction, @RequestParam("page") int page,
			@RequestParam("size") int size) {

		if (!(direction.equals(Direction.ASCENDING.getDirectionCode()) 
				|| direction.equals(Direction.DESCENDING.getDirectionCode()))) {
			throw new PaginationSortingException("Invalid sort direction");
		}

//		if (!(orderBy.equals(OrderBy.ID.getOrderByCode()) || orderBy.equals(OrderBy.USERID.getOrderByCode()))) {
		if (!(orderBy.equals(OrderBy.ID.getOrderByCode()))) {
			throw new PaginationSortingException("Invalid orderBy condition");
		}

		Page<Film> list = filmDaoImpl.findJsonDataByCondition(orderBy, direction, page, size);

		return list;
	}

	@ExceptionHandler(PaginationSortingException.class)
	public ResponseEntity<PagingSortingErrorResponse> exceptionHandler(Exception ex) {
		PagingSortingErrorResponse pagingSortingErrorResponse = new PagingSortingErrorResponse();
		pagingSortingErrorResponse.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
		pagingSortingErrorResponse.setMessage(ex.getMessage());
		return new ResponseEntity<PagingSortingErrorResponse>(pagingSortingErrorResponse, HttpStatus.OK);
	}

}
