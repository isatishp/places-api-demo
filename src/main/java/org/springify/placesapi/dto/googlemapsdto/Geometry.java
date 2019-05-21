package org.springify.placesapi.dto.googlemapsdto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springify.placesapi.model.Location;

@Data
public class Geometry {

    private Location location;
}
