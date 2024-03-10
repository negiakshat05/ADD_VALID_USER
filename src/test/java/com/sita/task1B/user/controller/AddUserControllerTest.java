package com.sita.task1B.user.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sita.task1B.user.dao.UserRepo;

@ExtendWith(MockitoExtension.class)
public class AddUserControllerTest {
	
	@InjectMocks
	AddUserController addUserController;
	
	@Mock
	UserRepo userRepo;
	
	@Test
	public void testAddUser() {
		
		Map<String, String> request = new HashMap<>();
		request.put("user", "admin");
		request.put("workStation", "CJWQG0G01");
		request.put("status", "Success");
		request.put("message", "OK");
		ResponseEntity<Map<String, String>> response = addUserController.addUser(request);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		
	}
	
	@Test
	public void testAddUser_Negative() {
		
		Map<String, String> request = new HashMap<>();
		ResponseEntity<Map<String, String>> response = addUserController.addUser(request);
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		
	}
}
