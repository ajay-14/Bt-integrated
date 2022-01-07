package com.bugtracking.serviceTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.bugtracking.dto.BugDto;
import com.bugtracking.entities.Bug;
import com.bugtracking.entities.Employee;
import com.bugtracking.entities.Project;
import com.bugtracking.mapper.BugMapper;
import com.bugtracking.repository.IBugRepository;
import com.bugtracking.service.BugServiceImpl;

class BugServiceImplTest {

	@Mock
	IBugRepository br;

	@InjectMocks
	BugServiceImpl bsi;

	@Mock
	BugDto bugDto;

	@Mock
	Bug bug;

	@Mock
	List<BugDto> bugDtol;

	@Mock
	List<Bug> bugl;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		Project project = new Project();
		project.setProjId(12);

		Employee e = new Employee();
		e.setEmpId(83);
		//e.setEmpName("ajay");

		bugDto.setBid(12l);
		bugDto.setBugDesc("aaa");
		bugDto.setEndDate(null);
		bugDto.setPriority("ss");
		bugDto.setProject(project);
		bugDto.setStartDate(null);
		bugDto.setStatus("as");
		bugDto.setType("sss");
		bugDto.setEmployee(e);

		}

	@Test
	void testbugById() {
		Mockito.when(br.findById(12l)).thenReturn(Optional.of(bug));
		BugDto bugDto1 = BugMapper.toBugDto(bug);
		assertEquals(bugDto1.getBid(), bsi.getbug(12l).getBid());
		Mockito.verify(br, times(1)).findById(12l);
	}

	@Test
	void testAddBug() {
		Mockito.when(br.save(any(Bug.class))).thenReturn(bug);
		BugDto bugDto1 = BugMapper.toBugDto(bug);
		BugDto bugDto2 = bsi.createbug(bugDto1);
		assertEquals(bugDto1.getBid(), bugDto2.getBid());
		Mockito.verify(br, times(1)).save(any(Bug.class));
	}

	@Test
	void testupdateBug() {
		Mockito.when(br.existsById(12l)).thenReturn(true);
		Mockito.when(br.save(any(Bug.class))).thenReturn(bug);
		BugDto bugDto1 = BugMapper.toBugDto(bug);
		assertEquals(bug.getBid(),bsi.updatebug(12l, bugDto1).getBid());
		Mockito.verify(br, times(1)).save(any(Bug.class));
	}

	@Test
	void testallbugs() {
		Mockito.when(br.findAll()).thenReturn(bugl);
		List<BugDto> bugDtol = BugMapper.toBugDtoList(bugl);
		assertEquals(bugDtol, bsi.getall());
		Mockito.verify(br, times(1)).findAll();
	}

	@Test
	void getbugsbystatus() {
		Mockito.when(br.findByStatus(bug.getStatus())).thenReturn(bugl);
		assertEquals(bugl, br.findByStatus(bug.getStatus()));
		Mockito.verify(br, times(1)).findByStatus(bug.getStatus());
	}

	@Test
	void testdeletebyid() {
		Mockito.when(br.existsById(12l)).thenReturn(true);
		Mockito.when(br.getById(12l)).thenReturn(bug);
		assertEquals(bug.getBid(), bsi.deletebug(12l).getBid());
		Mockito.verify(br, times(1)).existsById(12l);
	}

}
