package com.bugtracking.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.bugtracking.dto.BugDto;
import com.bugtracking.entities.Bug;

public class BugMapper {

	public static Bug toBug(BugDto bugDto) {
		Bug bug = new Bug();
		bug.setBid(bugDto.getBid());
		bug.setBugDesc(bugDto.getBugDesc());
		bug.setEmployee(bugDto.getEmployee());
		bug.setEndDate(bugDto.getEndDate());
		bug.setPriority(bugDto.getPriority());
		bug.setProject(bugDto.getProject());
		bug.setStartDate(bugDto.getStartDate());
		bug.setStatus(bugDto.getStatus());
		bug.setType(bugDto.getType());
		return bug;
	}

	public static BugDto toBugDto(Bug bug) {
		BugDto bugDto = new BugDto();
		bugDto.setBid(bug.getBid());
		bugDto.setBugDesc(bug.getBugDesc());
		bugDto.setEmployee(bug.getEmployee());
		bugDto.setEndDate(bug.getEndDate());
		bugDto.setPriority(bug.getPriority());
		bugDto.setProject(bug.getProject());
		bugDto.setStartDate(bug.getStartDate());
		bugDto.setStatus(bug.getStatus());
		bugDto.setType(bug.getType());
		return bugDto;
	}

	public static List<BugDto> toBugDtoList(List<Bug> bugs) {
		return bugs.stream().map(BugMapper::toBugDto).collect(Collectors.toList());
	}

}
