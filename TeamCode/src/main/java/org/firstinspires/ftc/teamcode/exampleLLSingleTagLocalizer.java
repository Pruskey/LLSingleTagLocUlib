package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;
import org.firstinspires.ftc.teamcode.core.LLSingleTagLocalizer;

@TeleOp
public class exampleLLSingleTagLocalizer extends LinearOpMode {

    LLSingleTagLocalizer localizer;

    @Override
    public void runOpMode() {

        localizer = new LLSingleTagLocalizer(hardwareMap, "limelight");

        waitForStart();

        while (opModeIsActive()) {
            if (localizer.updateOdometry()) {
                Pose3D pose = localizer.getCurrentPose();
                telemetry.addData("Robot Pose", pose.toString());
            } else {
                telemetry.addData("Limelight", "No valid pose");
            }
            telemetry.update();
        }
    }
}
