package org.springify.placesapi.converters;

import org.springframework.core.convert.converter.Converter;
import org.springify.placesapi.dto.googlemapsdto.GoogleMapsPlacesDto;
import org.springify.placesapi.model.Place;
import org.springify.placesapi.model.Places;

import java.util.List;
import java.util.stream.Collectors;

public class GoogleMapsPlacesDtoToPlacesConverter implements Converter<GoogleMapsPlacesDto, Places> {

    @Override
    public Places convert(GoogleMapsPlacesDto source) {
        if (source == null)
            return null;

        List<Place> places = source.getCandidates().stream().map(candidate ->
                Place.builder()
                        .name(candidate.getName())
                        .address(candidate.getFormattedAddress())
                        .categories(candidate.getTypes())
                        .location(candidate.getGeometry().getLocation()).build())
                .collect(Collectors.toList());

        return Places.builder()
                .places(places)
                .build();
    }
}
