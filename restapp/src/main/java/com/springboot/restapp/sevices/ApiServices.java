package com.springboot.restapp.sevices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springboot.restapp.utils.AqiResponce;

@Service
public class ApiServices {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${api.key}")
	private String apiKey;

	@Value("${api.endpoint.city}")
	private String cityUrl;

	@Value("${api.endpoint.geo}")
	private String geoUrl;

	@Cacheable(value = "apiCache", key = "#AQI_ + #cityNAme")
	public AqiResponce getAqiByCity(String cityNAme) {
		String finalUrl = cityUrl.replace("CITY_NAME", cityNAme).replace("YOUR_TOKEN", apiKey);

		ResponseEntity<AqiResponce> responseEntity = restTemplate.exchange(finalUrl, HttpMethod.GET, null,
				AqiResponce.class);
		System.out.println("API CALL EXECUTED for: " + cityNAme);
		AqiResponce bodyAqiResponce = responseEntity.getBody();
		return bodyAqiResponce;
	}

	public AqiResponce getAqiByGeo(Double latitude, Double longitude) {
		String finalUrl = geoUrl.replace("LATITUDE", Double.toString(latitude))
				.replace("LONGITUDE", Double.toString(longitude)).replace("YOUR_TOKEN", apiKey);

		ResponseEntity<AqiResponce> responseEntity = restTemplate.exchange(finalUrl, HttpMethod.GET, null,
				AqiResponce.class);

		AqiResponce bodyAqiResponce = responseEntity.getBody();
		return bodyAqiResponce;
	}

}
