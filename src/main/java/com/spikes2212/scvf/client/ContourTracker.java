package com.spikes2212.scvf.client;

import java.util.*;
import java.util.stream.Collectors;

public class ContourTracker {

    private Map<Integer, Contour> contours = new HashMap<>();

    public void trackContour(Contour contour) {
        contours.put(contour.getId(), contour);
    }

    public List<Contour> getUpdated() {
        return contours.values().stream()
                .filter(Contour::isUpdated)
                .collect(Collectors.toList());
    }
}
