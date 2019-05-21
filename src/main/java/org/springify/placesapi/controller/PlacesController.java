package org.springify.placesapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springify.placesapi.core.ErrorCode;
import org.springify.placesapi.exception.PlaceNotFoundException;
import org.springify.placesapi.model.Places;
import org.springify.placesapi.service.PlacesService;

@RestController
@RequestMapping(PlacesController.PLACES_BASE_PATH)
@RequiredArgsConstructor
public class PlacesController {

    static final String PLACES_BASE_PATH = "/places";

    private final PlacesService placesService;

    @GetMapping("/{place}")
    public ResponseEntity<Places> findPlace(@PathVariable String place) {
        Places places = placesService.findPlaceWithText(place)
                .orElseThrow(() -> new PlaceNotFoundException(String.format(ErrorCode.PLACE_NOT_FOUND.getMessage(), place)));
        return ResponseEntity.ok(places);
    }

    @GetMapping
    public ResponseEntity<Places> searchByCategories(@RequestParam("category") String category,
                                                     @RequestParam("location") String location) {

        Places places = placesService.searchByCategories(category, location)
                .orElseThrow(() -> new PlaceNotFoundException(String.format(ErrorCode.PLACE_WITH_CATEGORY_NOT_FOUND.getMessage(), category)));

        return ResponseEntity.ok(places);
    }



}
