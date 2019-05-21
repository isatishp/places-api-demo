package org.springify.placesapi.core;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    PLACE_NOT_FOUND("placesapi.place.notfound", "Place with name = '%s' does not exist."),

    PLACE_WITH_CATEGORY_NOT_FOUND("placesapi.placewithcategory.notfound", "Place with category = '%s' not found.");

    private String code;

    private String message;
}
