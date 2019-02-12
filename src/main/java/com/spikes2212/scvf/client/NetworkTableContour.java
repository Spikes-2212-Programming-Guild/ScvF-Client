package com.spikes2212.scvf.client;

import edu.wpi.first.networktables.NetworkTable;

import java.util.function.Function;

public class NetworkTableContour implements Contour {

    private NetworkTable table;
    private int id;

    private Function<Double, Double> scalingFunction;

    protected NetworkTableContour(NetworkTable table, int id, Function<Double, Double> scalingFunction) {
        this.table = table;
        this.id = id;
        this.scalingFunction = scalingFunction;
    }

    protected NetworkTableContour(NetworkTable table, int id) {
        this(table, id, (d) -> d);
    }

    @Override
    public double getX() {
        return scalingFunction.apply(table.getEntry("x" + id).getDouble(0));
    }

    @Override
    public double getY() {
        return scalingFunction.apply(table.getEntry("y" + id).getDouble(0));
    }

    @Override
    public double getWidth() {
        return scalingFunction.apply(table.getEntry("width" + id).getDouble(0));
    }

    @Override
    public double getHeight() {
        return scalingFunction.apply(table.getEntry("height" + id).getDouble(0));
    }

    @Override
    public double getCenterX() {
        return getX() + getWidth() / 2;
    }

    @Override
    public double getCenterY() {
        return getY() + getHeight() / 2;
    }

    @Override
    public boolean isUpdated() {
        return table.getEntry("isUpdated" + id).getBoolean(false);
    }

}
