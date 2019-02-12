package com.spikes2212.scvf.client;

import com.spikes2212.scvf.client.strategies.ContourStrategy;

public interface Contour {

    enum OutputType {
        PIXEL, PERCENT
    }

    void setOutputType(OutputType type);
    OutputType getOutputType();

    double getX();
    double getY();

    double getWidth();
    double getHeight();

    double getCenterX();
    double getCenterY();

    boolean isUpdated();

    void use(ContourStrategy strategy);
}
