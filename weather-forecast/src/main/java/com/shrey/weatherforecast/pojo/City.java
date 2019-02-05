package com.shrey.weatherforecast.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class City {

	private List<CityDetails> list;

	public List<CityDetails> getList() {
		return list;
	}

	public void setList(List<CityDetails> list) {
		this.list = list;
	}

}
