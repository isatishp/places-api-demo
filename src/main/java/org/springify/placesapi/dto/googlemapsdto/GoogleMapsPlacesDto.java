package org.springify.placesapi.dto.googlemapsdto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springify.placesapi.dto.PlacesDto;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GoogleMapsPlacesDto implements PlacesDto {

    @JsonAlias({"candidates", "results"})
    private List<Candidate> candidates;

    @JsonProperty("error_message")
    private String errorMessage;

    private String status;
}
