package org.springify.placesapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springify.placesapi.converters.GoogleMapsPlacesDtoToPlacesConverter;

@Configuration
public class ConverterConfig {

    @Bean
    public ConversionService conversionService() {
        DefaultConversionService defaultConversionService = new DefaultConversionService();
        defaultConversionService.addConverter(new GoogleMapsPlacesDtoToPlacesConverter());
        return defaultConversionService;
    }

}
