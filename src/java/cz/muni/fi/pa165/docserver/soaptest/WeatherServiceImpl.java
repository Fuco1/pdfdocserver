package cz.muni.fi.pa165.docserver.soaptest;

import java.util.Date;

public class WeatherServiceImpl implements WeatherService {

    public Weather getWeatherForToday() {
        return getRandomWeather(new Date());
    }

    public Weather getWeather(Date date) {
        return getRandomWeather(date);
    }

    public Weather[] getWeatherPrediction(int daysCount) {
        Weather[] weathers = new Weather[daysCount];
        for (int i = 0; i < daysCount; i++) {
            Date d = new Date();
            d.setDate(d.getDay() + i);
            weathers[i] = getRandomWeather(d);
        }
        return weathers;
    }

    public String getServiceInfo() {
        return "This is WeatherService.";
    }

    private Weather getRandomWeather(Date d) {
        Weather w = new Weather();
        w.setDate(d);
        w.setTemperature(new Double((Math.random() * 45) - 10).floatValue());
        w.setTextStatus("Hmlisto.");
        w.setWindSpeed(new Double((Math.random() * 120) - 0).floatValue());

        return w;
    }
}
