package org.springify.placesapi.clients;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;
import org.springify.placesapi.accessors.GoogleMapPlaceApiAccessor;
import org.springify.placesapi.dto.googlemapsdto.GoogleMapsPlacesDto;
import org.springify.placesapi.exception.PlaceApiException;
import org.springify.placesapi.model.Places;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GoogleMapsPlacesClient implements PlacesApiClient {

    private final GoogleMapPlaceApiAccessor apiAccessor;

    private final ConversionService conversionService;

    @Value("${placesapi.displayedFields:formatted_address,name,geometry/location,types}")
    private String fields;

    @Override
    public Optional<Places> findPlacewithText(String place) {
        GoogleMapsPlacesDto response = apiAccessor.findPlaceFromText(place, "textquery", fields.replaceAll("\\s+",""));
        return processResponse(response);
    }

    private Optional<Places> processResponse(GoogleMapsPlacesDto response) {
        if (response.getErrorMessage() != null) {
            throw new PlaceApiException(response.getErrorMessage());
        }

        if(response.getStatus().equals("INVALID_REQUEST")) {
            throw new PlaceApiException("Invalid Request.");
        }

        if (response.getStatus().equals("ZERO_RESULTS")) {
            return Optional.empty();
        }
        return Optional.of(conversionService.convert(response, Places.class));
    }

    @Override
    public Optional<Places> searchPlaceByCategories(String category, String location) {
        GoogleMapsPlacesDto response = apiAccessor.searchPlacesByCategories(category, location, "distance");
        return processResponse(response);
    }


}
