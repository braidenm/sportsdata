package com.braidenmiller.sportsdata.client;

import com.braidenmiller.sportsdata.config.SportsIOClientConfig;
import com.braidenmiller.sportsdata.config.WeatherClientConfig;
import com.braidenmiller.sportsdata.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(
        name = "weather.visualcrossing",
        url = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/",
        configuration = WeatherClientConfig.class
)
public interface WeatherClient {

    @GetMapping(path = "timeline/{latLong}/{localDateTime}?include=current",
            produces = MediaType.APPLICATION_JSON_VALUE)
    WeatherDTO getWeather(@PathVariable String latLong,
                          @PathVariable String localDateTime);
}
