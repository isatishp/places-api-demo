package org.springify.placesapi.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Places {
    private List<Place> places;
}
