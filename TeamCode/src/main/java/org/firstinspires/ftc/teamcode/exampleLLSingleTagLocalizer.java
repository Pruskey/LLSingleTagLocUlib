package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;

@TeleOp
public class exampleLLSingleTagLocalizer extends LinearOpMode {

    LLSingleTagLocalizer localizer;

    @Override
    public void runOpMode() {

        waitForStart();
        LLSingleTagLocalizer singleTagLocalizer = new LLSingleTagLocalizer(hardwareMap, "limelight");

        Pose3D robotPose = singleTagLocalizer.getRobotPosition();

        if (robotPose != null) {
        } else {
        }

    }
    }
}
