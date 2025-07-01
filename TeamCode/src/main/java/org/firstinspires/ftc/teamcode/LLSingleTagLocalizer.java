package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;

public class LLSingleTagLocalizer {

    private final Limelight3A limelight;
    private Pose3D currentPose = null;

    public LLSingleTagLocalizer(HardwareMap hardwareMap, String limelightName) {
        limelight = hardwareMap.get(Limelight3A.class, limelightName);
        limelight.start();
        limelight.pipelineSwitch(0);
    }

    public Pose3D getRobotPosition() {
        LLResult result = limelight.getLatestResult();

        if (result != null && result.isValid()) {
            currentPose = result.getBotpose();
        } else {
            currentPose = null;
        }

        return currentPose;
    }
}
