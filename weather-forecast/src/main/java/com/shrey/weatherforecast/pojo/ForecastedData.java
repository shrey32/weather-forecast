package com.shrey.weatherforecast.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastedData {

	private List<Data> list;

	public List<Data> getList() {
		return list;
	}

	public void setList(List<Data> data) {
		this.list = data;
	}

}
