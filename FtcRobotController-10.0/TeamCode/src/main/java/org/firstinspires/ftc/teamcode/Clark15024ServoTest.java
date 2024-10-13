package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//TeleOp class to test a servo for it's capabilities
//This class is mainly formed to be produced for a video
@TeleOp(name = "ServoTester", group = "Tests")
public class Clark15024ServoTest extends LinearOpMode {
    Clark15024HWMap robot = new Clark15024HWMap();



    @Override
    public void runOpMode() throws InterruptedException {
        robot.Map(hardwareMap);


        waitForStart();

        while(opModeIsActive()){
            //If y is pressed on gamepad 1, then the servo is going to go to 0 degrees
            if(gamepad1.y){
                robot.temp.setPosition(0);
            //If a is pressed on gamepad 1, then the servo is going to go to 180 degrees
            } else if (gamepad1.a) {
                robot.temp.setPosition(0.5);
            //If a is pressed on gamepad 1, then the servo is going to go to 360 degrees
            } else if (gamepad1.b) {
                robot.temp.setPosition(1);
            }

            telemetry.addData("Servo Position", robot.temp.getPosition());
            telemetry.update();
        }
    }
}
