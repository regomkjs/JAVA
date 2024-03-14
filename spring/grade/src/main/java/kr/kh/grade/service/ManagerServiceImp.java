package kr.kh.grade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.grade.repository.ManagerRepository;

@Service
public class ManagerServiceImp implements ManagerService {
	
	@Autowired
	private ManagerRepository managerRepository;
}
