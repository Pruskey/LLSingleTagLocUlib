package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;

public class LimelightTest {

    private final Limelight3A limelight;

    private Pose3D currentPose = null;

    public LimelightTest(HardwareMap hardwareMap, String limelightName) {
        limelight = hardwareMap.get(Limelight3A.class, limelightName);
        limelight.start();
        limelight.pipelineSwitch(0);
    }

    public boolean updateOdometry() {
        LLResult result = limelight.getLatestResult();
        if (result != null && result.isValid()) {
            Pose3D botpose = result.getBotpose();
            if (botpose != null) {
                currentPose = botpose;
                return true;
            }
        }
        return false;
    }

    public Pose3D getCurrentPose() {
        return currentPose;
    }

    public void stop() {
        limelight.stop();
    }
}
