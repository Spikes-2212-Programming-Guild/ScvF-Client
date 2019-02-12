package com.spikes2212.scvf.client;

import com.spikes2212.scvf.client.strategies.ContourMiddleware;
import edu.wpi.first.networktables.NetworkTable;

import java.util.LinkedList;
import java.util.List;


public class NetworkTableContour implements Contour {

    private NetworkTableDataSource source;

    private List<ContourMiddleware> middlewares;

    private int id;

    protected NetworkTableContour(NetworkTable table, int id) {
        this.source = new NetworkTableDataSource(table, id);
        this.middlewares = new LinkedList<>();
        this.id = id;
    }

    protected double applyMiddlewareOnXAxis(double x) {
        double result = x;
        for (ContourMiddleware middleware : middlewares) {
            result = middleware.processXAxis(result);
        }
        return result;
    }

    protected double applyMiddlewareOnYAxis(double y) {
        double result = y;
        for (ContourMiddleware middleware : middlewares) {
            result = middleware.processYAxis(result);
        }
        return result;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public double getX() {
        return applyMiddlewareOnXAxis(source.getX());
    }

    @Override
    public double getY() {
        return applyMiddlewareOnYAxis(source.getY());
    }

    @Override
    public double getWidth() {
        return applyMiddlewareOnXAxis(source.getWidth());
    }

    @Override
    public double getHeight() {
        return applyMiddlewareOnYAxis(source.getHeight());
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
        return source.isUpdated();
    }

    @Override
    public Contour use(ContourMiddleware middleware) {
        middlewares.add(middleware);
        return this;
    }

}
