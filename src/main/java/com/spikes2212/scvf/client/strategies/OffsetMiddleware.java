package com.spikes2212.scvf.client.strategies;

public class OffsetMiddleware implements ContourMiddleware {

    private double maxX, maxY;

    public OffsetMiddleware(double maxX, double maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    @Override
    public double processXAxis(double x) {
        return x - maxX / 2;
    }

    @Override
    public double processYAxis(double y) {
        return y - maxY / 2;
    }
}
