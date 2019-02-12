package com.spikes2212.scvf.client;

import edu.wpi.first.networktables.NetworkTable;


public class NetworkTableContour implements Contour {

    private NetworkTable table;
    private int id;

    protected NetworkTableContour(NetworkTable table, int id) {
        this.table = table;
        this.id = id;
    }

    @Override
    public double getX() {
        return table.getEntry("x" + id).getDouble(0);
    }

    @Override
    public double getY() {
        return table.getEntry("y" + id).getDouble(0);
    }

    @Override
    public double getWidth() {
        return table.getEntry("width" + id).getDouble(0);
    }

    @Override
    public double getHeight() {
        return table.getEntry("height" + id).getDouble(0);
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
