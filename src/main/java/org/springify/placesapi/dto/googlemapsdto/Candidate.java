package org.springify.placesapi.dto.googlemapsdto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Candidate {

    @JsonAlias({"formatted_address","vicinity"})
    private String formattedAddress;

    private Geometry geometry;

    private String name;

    private List<String> types;
}
