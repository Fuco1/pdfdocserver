package cz.muni.fi.pa165.docserver.soaptest;

import java.util.Date;

public interface WeatherService {

    /**
     * Vráti stav počasia na dnešný deň.
     *
     */
    public Weather getWeatherForToday();

    /**
     * Vráti stav počasia zodpovedajúci príslušnému dátumu.
     */
    public Weather getWeather(Date date);

    /**
     * Vráti pole stavov počasia na požadovaný počet dní dopredu.
     *
     */
    public Weather[] getWeatherPrediction(int daysCount);

    /**
     * Vráti textové informácie o tejto službe
     *
     */
    public String getServiceInfo();
}
