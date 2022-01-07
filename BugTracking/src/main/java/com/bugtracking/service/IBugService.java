package com.bugtracking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bugtracking.dto.BugDto;
import com.bugtracking.entities.Bug;

public interface IBugService {

	List<BugDto> getall();

	BugDto getbug(long bid);

	BugDto deletebug(long bid);

	BugDto createbug(BugDto bugDto);

	BugDto updatebug(long bid,BugDto bugDto);

	List<BugDto> getbugsbystatus(String status);

}
