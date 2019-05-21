package org.springify.placesapi.accessors;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springify.placesapi.config.GoogleMapsFeignConfig;
import org.springify.placesapi.dto.googlemapsdto.GoogleMapsPlacesDto;

@FeignClient(name = "GoogleMapsPlacesService", url = "${placesapi.base_url}", configuration = GoogleMapsFeignConfig.class)
public interface GoogleMapPlaceApiAccessor {

    @GetMapping("/findplacefromtext/json")
    GoogleMapsPlacesDto findPlaceFromText(@RequestParam("input") String place, @RequestParam("inputtype") String inputType, @RequestParam("fields") String fields);

    @GetMapping("/nearbysearch/json")
    GoogleMapsPlacesDto searchPlacesByCategories(@RequestParam("type") String type, @RequestParam("location") String location, @RequestParam("rankby") String rankby);
}
