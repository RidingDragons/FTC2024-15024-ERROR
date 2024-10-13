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
        //Goes into the Sparkfun OTOS and runs the init function from the teleOP
        //robot.odom.init();



        //TODO Add SparkFun Sensor and additional ability
        //Waits for the button to start on the driver hub to be pressed
        waitForStart();
        //TODO Check is this needs to go into while loop instead of .start
        //robot.odom.init_loop();

        //while loop starts once the start button is pressed
        while(opModeIsActive()){
            /*
            //TODO Figure out if you need to use the class as a whole for the odometry or make a variable
            //Starts the OTOS while loop and adds the values to the control hub using telemetry
            robot.odom.start();
            telemetry.addData("SF OTOS", robot.odom.telemetry);
            telemetry.update();
            //Figured out that you do not need to add the Sparkfun Variable while running
             */

            //Slow mode whenever you need to go slower to get precise blocks
            //TODO change controller input if needed
            double slow = gamepad1.right_bumper ? 0.5 : 1.0;
            //Instances variables assigned to double or decimal values to the different gamepad
            //Set the vertical as a negative because of the different values needed for the right side as they are in reverse
            //TODO change negative signs of all variables if robot not moving or working as the values for the robot could need to be switched
            double vertical = -gamepad1.left_stick_y;
            double horizontal = gamepad1.left_stick_x * 1.1; //  Multiply by 1.1 to negate imperfect strafing
            double pivot = gamepad1.right_stick_x;

            //Obtains values for each motor through the positions through values
            //from  left joystick which has up/down(vertical) and left/right values(horizontal), and right joystick which has left/right values(pivot)
            double denominator = Math.max(Math.abs(vertical) + Math.abs(horizontal) + Math.abs(pivot), 1);
            double rightFrontPower = (vertical - horizontal - pivot) / denominator;
            double rightBackPower = (vertical + horizontal - pivot) / denominator;
            double LeftFrontPower = (pivot + vertical + horizontal) / denominator;
            double LeftBackPower = (vertical - horizontal + pivot) / denominator;

            //Sets Power to the motors and changed the signed of the math in order to proportion the wheels right to move
            robot.driveRightFront.setPower(rightFrontPower * slow);
            robot.driveRightBack.setPower(rightBackPower * slow);
            robot.driveLeftBack.setPower(LeftBackPower * slow);
            robot.driveLeftFront.setPower(LeftFrontPower * slow);




        }
    }
}
