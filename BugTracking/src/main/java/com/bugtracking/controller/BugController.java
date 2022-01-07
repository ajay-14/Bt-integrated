package com.bugtracking.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bugtracking.dto.BugDto;
import com.bugtracking.entities.Bug;
import com.bugtracking.responses.Responseinfo;
import com.bugtracking.service.IBugService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api
public class BugController {
	@Autowired
	IBugService bs;

	@ApiOperation("Used to fetch all bugs")
	@GetMapping("/bugs")
	public List<BugDto> allbugs() {
		return bs.getall();
	}

	@ApiOperation("Used to delete bug with particular id")
	@DeleteMapping("/bugs/{bid}")
	public BugDto deletebug(@PathVariable long bid) {
		return bs.deletebug(bid);
	}

	@ApiOperation("Used to create bug")
	@PostMapping("/bugs")
	public BugDto createbug(@Valid @RequestBody BugDto bugDto) {
		return bs.createbug(bugDto);
	}

	@ApiOperation("Used to update bug")
	@PutMapping("/bugs/{bid}")
	public BugDto updatebug(@PathVariable("bid") long bid,@Valid @RequestBody BugDto bugDto) {
		return bs.updatebug(bid,bugDto);
	}

	@ApiOperation("Used to fetch bugs by status")
	@GetMapping("/bugs/bystatus/{status}")
	public List<BugDto> bugsbystatus(@ApiParam("Enter status to search") @PathVariable String status) {
		return bs.getbugsbystatus(status);
	}

	@ApiOperation("Used to get bug with particular id")
	@GetMapping("/bugs/{bid}")
	public BugDto getbug(@PathVariable long bid) {
		return bs.getbug(bid);
	}

}
