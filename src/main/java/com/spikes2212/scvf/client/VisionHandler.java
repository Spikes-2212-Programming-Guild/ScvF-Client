package com.spikes2212.scvf.client;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class VisionHandler {

    private int cameraWidth, cameraHeight;

    private NetworkTable table;

    private NetworkTableEntry pipelineNameEntry, cameraIdEntry, exposureEntry;

    public VisionHandler(int cameraWidth, int cameraHeight, String tableName) {
        this.cameraWidth = cameraWidth;
        this.cameraHeight = cameraHeight;
        this.table = NetworkTableInstance.getDefault().getTable(tableName);
        this.pipelineNameEntry = table.getEntry("pipeline_name");
        this.cameraIdEntry = table.getEntry("camera_id");
        this.exposureEntry = table.getEntry("exposureEntry");

    }

    public VisionHandler(int cameraWidth, int cameraHeight) {
        this(cameraWidth, cameraHeight, "ImageProcessing");
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
