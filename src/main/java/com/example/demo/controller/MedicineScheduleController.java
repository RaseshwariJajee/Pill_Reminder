package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.MedicineScheduleImpl;
import com.example.demo.entities.MedicineSchedule;

@RestController
public class MedicineScheduleController {
	MedicineScheduleImpl mdImpl = new MedicineScheduleImpl();
	
	@CrossOrigin
    @GetMapping("/home")
    public List<MedicineSchedule> checkhistory(){	
		
			mdImpl.connect();
		
			return mdImpl.DisplaySchedule();
			
		}
}
