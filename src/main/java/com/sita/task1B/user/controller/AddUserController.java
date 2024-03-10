package com.sita.task1B.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sita.task1B.user.dao.UserInfo;
import com.sita.task1B.user.dao.UserRepo;

@RestController
public class AddUserController {

	private static final Logger logger = LoggerFactory.getLogger(AddUserController.class);

	@Autowired
	UserRepo userRepo;

	@PostMapping("/addUserInfo")
	public ResponseEntity<Map<String, String>> addUser(@RequestBody Map<String, String> request) {

		logger.info("Entering into userDetail controller.");

		Map<String, String> response = new HashMap<>();
		UserInfo userInfo = new UserInfo();

		String user;
		String workStation;
		String status;
		String message;

		try {
			if (MapUtils.isNotEmpty(request)) {
				if (request.containsKey("user")) {
					user = request.get("user");
					userInfo.setUserName(user);
				}
				if (request.containsKey("workStation")) {
					workStation = request.get("workStation");
					userInfo.setWorkStation(workStation);
				}
				if (request.containsKey("status")) {
					status = request.get("status");
					userInfo.setStatus(status);
				}
				if (request.containsKey("message")) {
					message = request.get("message");
					userInfo.setMessage(message);
				}
				userRepo.save(userInfo);
				response.put("Staus", "User info successfully added.");
			} else {
				response.put("message", "User not found.");
				return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			logger.error("Exception occured due to: {}", e.getMessage());
		}
		logger.info("End userDetail controller.");
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

}
