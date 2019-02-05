package com.shrey.weatherforecast.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Temperature {

	private float morn, day, eve, night;

	public float getMorn() {
		return morn;
	}

	public void setMorn(float morn) {
		this.morn = morn;
	}

	public float getDay() {
		return day;
	}

	public void setDay(float day) {
		this.day = day;
	}

	public float getEve() {
		return eve;
	}

	public void setEve(float eve) {
		this.eve = eve;
	}

	public float getNight() {
		return night;
	}

	public void setNight(float night) {
		this.night = night;
	}

}
