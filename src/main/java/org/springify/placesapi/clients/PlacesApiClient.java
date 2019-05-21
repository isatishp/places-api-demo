package org.springify.placesapi.clients;

import org.springify.placesapi.model.Places;

import java.util.Optional;

public interface PlacesApiClient {
    Optional<Places> findPlacewithText(String place);

    Optional<Places> searchPlaceByCategories(String category, String location);
}
