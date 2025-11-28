package com.springboot.restapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restapp.sevices.ApiServices;
import com.springboot.restapp.utils.AqiResponce;

@RequestMapping("/api/v1")
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class AqiController {

	@Autowired
	ApiServices apiServices;

	@GetMapping("/aqi/{city}")
	public AqiResponce getDataByCity(@PathVariable String city) {
		AqiResponce response = apiServices.getAqiByCity(city);

		return response;

	}

	@GetMapping("/aqi/geo/{latitude}/{longitude}")
	public AqiResponce getDataByGeo(@PathVariable Double latitude, @PathVariable Double longitude) {

		return apiServices.getAqiByGeo(latitude, longitude);
	}

}
