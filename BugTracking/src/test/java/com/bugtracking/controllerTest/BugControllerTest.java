package com.bugtracking.controllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.bugtracking.controller.BugController;
import com.bugtracking.dto.BugDto;
import com.bugtracking.entities.Bug;
import com.bugtracking.entities.Employee;
import com.bugtracking.entities.Project;
import com.bugtracking.service.IBugService;

public class BugControllerTest {
	long bid;
	@Mock
	public BugDto bugDto;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		Project project = new Project();
		project.setProjId(12);

		Employee e = new Employee();
		e.setEmpId(83);

		bugDto.setBid(12);
		bugDto.setBugDesc("aaa");
		bugDto.setEndDate(null);
		bugDto.setPriority("ss");
		bugDto.setProject(project);
		bugDto.setStartDate(null);
		bugDto.setStatus("as");
		bugDto.setType("sss");
		bugDto.setEmployee(e);
	}

	@InjectMocks
	BugController bugcontroller;

	@Mock
	IBugService bugservice;

	@Mock
	List<BugDto> bugDtolist;
	@Mock
	Bug bug;

	@Test
	void testAddBug() {
		Mockito.when(bugservice.createbug(bugDto)).thenReturn(bugDto);
		assertEquals(bugDto, bugcontroller.createbug(bugDto));
		Mockito.verify(bugservice,times(1)).createbug(bugDto);
	}

	@Test
	void testdelbug() {
		when(bugservice.deletebug(bid)).thenReturn(bugDto);
		assertEquals(bugDto, bugcontroller.deletebug(bid));
		Mockito.verify(bugservice, times(1)).deletebug(bid);
	}

	@Test
	void testupdateBug() {
		Mockito.when(bugservice.updatebug(bid, bugDto)).thenReturn(bugDto);
		assertEquals(bugDto, bugcontroller.updatebug(bid, bugDto));
		Mockito.verify(bugservice,times(1)).updatebug(bid, bugDto);
	}

	@Test
	void testgetbug() {
		Mockito.when(bugservice.getbug(bid)).thenReturn(bugDto);
		assertEquals(bugDto, bugcontroller.getbug(bid));
		Mockito.verify(bugservice,times(1)).getbug(bid);
	}

	@Test
	void testgetallbug() {
		Mockito.when(bugservice.getall()).thenReturn(bugDtolist);
		assertEquals(bugDtolist, bugcontroller.allbugs());
		Mockito.verify(bugservice,times(1)).getall();
	}

	@Test
	void testgetbugbystatus() {
		Mockito.when(bugservice.getbugsbystatus("hi")).thenReturn(bugDtolist);
		assertEquals(bugDtolist, bugcontroller.bugsbystatus("hi"));
		Mockito.verify(bugservice,times(1)).getbugsbystatus("hi");
	}

}
