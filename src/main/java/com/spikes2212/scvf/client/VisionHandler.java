package com.spikes2212.scvf.client;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

import java.util.List;

public class VisionHandler {

    private int cameraWidth, cameraHeight;

    private NetworkTable table;

    private ContourTracker contourTracker;

    private NetworkTableEntry pipelineNameEntry, cameraIdEntry, exposureEntry;

    public VisionHandler(int cameraWidth, int cameraHeight, String tableName) {
        this.cameraWidth = cameraWidth;
        this.cameraHeight = cameraHeight;
        this.table = NetworkTableInstance.getDefault().getTable(tableName);
        this.pipelineNameEntry = table.getEntry("pipeline_name");
        this.cameraIdEntry = table.getEntry("camera_id");
        this.exposureEntry = table.getEntry("exposureEntry");
        this.contourTracker = new ContourTracker();

    }

    public VisionHandler(int cameraWidth, int cameraHeight) {
        this(cameraWidth, cameraHeight, "ImageProcessing");
    }

    public Contour generateContour(int id) {
        Contour contour = new NetworkTableContour(table, id);
        contourTracker.track(contour);
        return contour;
    }

    public List<Contour> getUpdatedContours() {
        return contourTracker.getUpdated();
    }

    public void setExposure(double exposure) {
        exposureEntry.setDouble(exposure);
    }

    public void setCameraId(double id) {
        cameraIdEntry.setDouble(id);
    }

    public void setPipeline(String pipeline) {
        pipelineNameEntry.setString(pipeline);
    }
}
