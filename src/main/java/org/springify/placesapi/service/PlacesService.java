package org.springify.placesapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springify.placesapi.clients.PlacesApiClient;
import org.springify.placesapi.model.Places;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlacesService {

    private final PlacesApiClient placesApiClient;

    public Optional<Places> findPlaceWithText(String place) {
        return placesApiClient.findPlacewithText(place);
    }

    public Optional<Places> searchByCategories(String category, String location) {
        return placesApiClient.searchPlaceByCategories(category, location);
    }
}
