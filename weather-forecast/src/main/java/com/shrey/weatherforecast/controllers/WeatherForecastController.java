package com.shrey.weatherforecast.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shrey.weatherforecast.pojo.AverageForecastedData;
import com.shrey.weatherforecast.service.WeatherForecastService;

@RestController
public class WeatherForecastController {

	@Autowired
	WeatherForecastService forecastService;

	@GetMapping("/data/temperatureForecast/{city}")
	public List<AverageForecastedData> getAvgTemperatureForNextThreeDays(
			@PathVariable String city) {
		String cityId = forecastService.getCityIdFromName(city);
		return forecastService.getForecastForNextThreeDays(cityId);
	}

}
