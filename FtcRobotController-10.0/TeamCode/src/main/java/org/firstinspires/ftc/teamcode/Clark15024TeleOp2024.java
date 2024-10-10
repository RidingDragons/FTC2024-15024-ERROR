package org.firstinspires.ftc.teamcode;
//Imports
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.robotcontroller.external.samples.SensorSparkFunOTOS;

//Used to name this specific TeleOP to show in the driver hub
@TeleOp(name = "Clark15024TeleOp2024")
//Base TeleOp class which currently has the Hardware map Initialized and the running Op mode
//extends LinearOpMode - used as a parent class of this child class, meaning you can use all the functions from the parent class in this child class
public class Clark15024TeleOp2024 extends LinearOpMode {
    //Initialized Hardware map instance variable assigned to "robot"
    Clark15024HWMap robot = new Clark15024HWMap();

    //@Override - Used to rewrite the runOpMode function which is in the LinearOpMode class
    //runOpMode - runs when the button before the start button is pressed
    @Override
    public void runOpMode(){
        //Initiates the Map function, assigning items to instance variables in the hardware map
        robot.Map(hardwareMap);

        telemetry.addData("Say", "Starting");
        telemetry.update();
        //Sets the mode all motors for driving to reset the counter for the encode and to run without using the encoders(encoders will not pick up change)
        robot.driveLeftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.driveLeftBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.driveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.driveLeftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.driveRightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.driveRightBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.driveRightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.driveRightFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.linearMotionUp1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.linearMotionUp1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.linearMotionUp2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.linearMotionUp2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.linearMotionRight1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.linearMotionRight1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.intakeHD.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.intakeHD.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //TODO Add SparkFun Sensor and additional ability
        //Waits for the button to start on the driver hub to be pressed
        waitForStart();

        //while loop starts once the start button is pressed
        while(opModeIsActive()){

        }
    }
}
