package com.spikes2212.scvf.client;

import edu.wpi.first.networktables.NetworkTable;

public class NetworkTableDataSource {


    private NetworkTable table;
    private int id;

    public NetworkTableDataSource(NetworkTable table, int id) {
        this.table = table;
        this.id = id;
    }

    public double getX() {
        return table.getEntry("x" + id).getDouble(0);
    }

    public double getY() {
        return table.getEntry("y" + id).getDouble(0);
    }

    public double getWidth() {
        return table.getEntry("width" + id).getDouble(0);
    }

    public double getHeight() {
        return table.getEntry("height" + id).getDouble(0);
    }
}
