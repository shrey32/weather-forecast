# weather-forecast
weather-forecast microservices

# Deployment and Run

1) simply download or clone this project and import as a maven project in eclipse.

2) Project is an Spring-Boot Application, It has an Application.java file

3) Right Click and run Application.java to run this project

4) project takes the default host port i.e localhost:8080

5) Once the project runs successfully you can access the below api
   http://localhost:8080/data/temperatureForecast/{city} 
   Note: {city} can be replaced with any city name
   
# How to use   

1) There is only a single service in this project which provides Avg Temperature and Pressure data from current date to next three days

2) Service is a get request which takes city name as a path variable for example:
   http://localhost:8080/data/temperatureForecast/berlin , to get Avg Temperature and Pressure data of berlin from current date to next three days 

3) city name can be changed to any other city name for example, New York, London, Munich and so on.

# Reasoning

1) OpenWeatherMapApi is used to get all the necessary informations.

2) There is only a single controller (WeatherForecastController.java) which exposes the above get request.

3) When the api is accessed with the city name, it fetches city id from OpenWeatherMap's server. City Id is used to fetch temperature and pressure 
   information for next three days starting from today.


