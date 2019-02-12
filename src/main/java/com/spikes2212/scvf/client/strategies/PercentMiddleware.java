package com.spikes2212.scvf.client.strategies;

/**
 * This middleware scales the output of a contour to a percent of its max value.
 *
 * Always use this middleware last!
 */
public class PercentMiddleware implements ContourMiddleware {

    private int maxX, maxY;

    public PercentMiddleware(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    @Override
    public double processXAxis(double x) {
        return x / maxX;
    }

    @Override
    public double processYAxis(double y) {
        return y / maxX;
    }
}
