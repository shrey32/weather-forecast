package com.shrey.weatherforecast;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.shrey.weatherforecast.controllers.WeatherForecastController;
import com.shrey.weatherforecast.pojo.AverageForecastedData;
import com.shrey.weatherforecast.service.WeatherForecastService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = WeatherForecastController.class, secure = false)
public class WeatherForecastControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private WeatherForecastService forecastService;

	private String cityId = "2950159";

	private String resultJSON = "[{\"date\":\"05-Feb-2019\",\"avgTempOfDay\":3.0,\"avgTempOfNight\":2.125,\"pressure\":1034.15},{\"date\":\"06-Feb-2019\",\"avgTempOfDay\":-0.70000005,\"avgTempOfNight\":1.56,\"pressure\":1031.81},{\"date\":\"07-Feb-2019\",\"avgTempOfDay\":1.1700001,\"avgTempOfNight\":3.37,\"pressure\":1018.44},{\"date\":\"08-Feb-2019\",\"avgTempOfDay\":3.5749998,\"avgTempOfNight\":6.285,\"pressure\":1012.87}]";

	List<AverageForecastedData> mockedAverageForcastedData;

	@Before
	public void setup() {
		mockedAverageForcastedData = new ArrayList<>();
		mockedAverageForcastedData.add(new AverageForecastedData("05-Feb-2019",
				3.0f, 2.125f, 1034.15f));
		mockedAverageForcastedData.add(new AverageForecastedData("06-Feb-2019",
				-0.70000005f, 1.56f, 1031.81f));
		mockedAverageForcastedData.add(new AverageForecastedData("07-Feb-2019",
				1.1700001f, 3.37f, 1018.44f));
		mockedAverageForcastedData.add(new AverageForecastedData("08-Feb-2019",
				3.5749998f, 6.285f, 1012.87f));
	}

	@Test
	public void testGetAvgTemperatureForNextThreeDays() throws Exception {
		Mockito.when(forecastService.getCityIdFromName(Mockito.anyString()))
				.thenReturn(cityId);
		Mockito.when(forecastService.getForecastForNextThreeDays(cityId))
				.thenReturn(mockedAverageForcastedData);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/data/temperatureForecast/berlin").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		JSONAssert.assertEquals(resultJSON, result.getResponse()
				.getContentAsString(), false);
	}

}
