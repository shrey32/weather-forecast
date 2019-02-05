package com.shrey.weatherforecast.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shrey.weatherforecast.pojo.AverageForecastedData;
import com.shrey.weatherforecast.pojo.City;
import com.shrey.weatherforecast.pojo.Data;
import com.shrey.weatherforecast.pojo.ForecastedData;
import com.shrey.weatherforecast.util.Constants;
import com.shrey.weatherforecast.util.Utility;

@Service
public class WeatherForecastService {

	@Autowired
	RestTemplate restTemplate;

	/**
	 * get city Id from city name uses openweather api to get this information
	 * 
	 * @param cityName
	 * @return
	 */
	public String getCityIdFromName(String cityName) {
		String url = Constants.FIND_CITY_BASE_URL + "q=" + cityName
				+ "&type=like&sort=population&cnt=30&appid="
				+ Constants.API_KEY;
		ResponseEntity<City> response = restTemplate.getForEntity(url,
				City.class);
		City city = response.getBody();
		return !city.getList().isEmpty() ? city.getList().get(0).getId() : "";
	}

	/**
	 * 
	 * @param cityId
	 * @return
	 */
	public List<AverageForecastedData> getForecastForNextThreeDays(String cityId) {
		String url = Constants.DAILY_FORECAST_URL + "appid="
				+ Constants.API_KEY + "&id=" + cityId + "&units=metric";
		ResponseEntity<ForecastedData> response = restTemplate.getForEntity(
				url, ForecastedData.class);
		List<AverageForecastedData> resultList = new ArrayList<>();
		response.getBody().getList().stream().limit(4).forEach(data -> {
			resultList.add(getAvgForecastFromData(data));
		});
		return resultList;
	}

	/**
	 * Convert data to avgForecastedData
	 * 
	 * @param data
	 * @return
	 */
	private AverageForecastedData getAvgForecastFromData(Data data) {
		AverageForecastedData avgData = new AverageForecastedData();
		avgData.setAvgTempOfDay((data.getTemp().getDay() + data.getTemp()
				.getMorn()) / 2);
		avgData.setAvgTempOfNight((data.getTemp().getEve() + data.getTemp()
				.getNight()) / 2);
		avgData.setPressure(data.getPressure());
		avgData.setDate(Utility.getStringDateFromTimeStamp(data.getDt()));
		return avgData;
	}
}
