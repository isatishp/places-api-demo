package org.springify.placesapi.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Place {

    private String name;

    private String address;

    private Location location;

    private List<String> categories;

}
