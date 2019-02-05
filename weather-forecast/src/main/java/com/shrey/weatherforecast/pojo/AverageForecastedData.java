package com.shrey.weatherforecast.pojo;

public class AverageForecastedData {

	private String date;
	private float avgTempOfDay, avgTempOfNight;
	private float pressure;

	public AverageForecastedData() {
	}
	
	public AverageForecastedData(String date, float avgTempOfDay,
			float avgTempOfNight, float pressure) {
		super();
		this.date = date;
		this.avgTempOfDay = avgTempOfDay;
		this.avgTempOfNight = avgTempOfNight;
		this.pressure = pressure;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public float getAvgTempOfDay() {
		return avgTempOfDay;
	}

	public void setAvgTempOfDay(float avgTempOfDay) {
		this.avgTempOfDay = avgTempOfDay;
	}

	public float getAvgTempOfNight() {
		return avgTempOfNight;
	}

	public void setAvgTempOfNight(float avgTempOfNight) {
		this.avgTempOfNight = avgTempOfNight;
	}

	public float getPressure() {
		return pressure;
	}

	public void setPressure(float pressure) {
		this.pressure = pressure;
	}

}
