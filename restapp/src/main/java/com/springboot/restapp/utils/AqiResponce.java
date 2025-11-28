package com.springboot.restapp.utils;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AqiResponce {

	private String status;

	private Data data;

	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	public Data getData() {
		return data;
	}

	@JsonProperty("data")
	public void setData(Data data) {
		this.data = data;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Data {
		private Integer aqi;
		private City city;
		private String error;

		public Integer getAqi() {
			return aqi;
		}

		public void setAqi(Integer aqi) {
			this.aqi = aqi;
		}

		public City getCity() {
			return city;
		}

		public void setCity(City city) {
			this.city = city;
		}

		public String getError() {
			return error;
		}

		public void setError(String error) {
			this.error = error;
		}
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class City {

		private List<Double> geo;
		private String name;
		private String url;
		private String location;

		public List<Double> getGeo() {
			return geo;
		}

		public void setGeo(List<Double> geo) {
			this.geo = geo;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}
	}
}
