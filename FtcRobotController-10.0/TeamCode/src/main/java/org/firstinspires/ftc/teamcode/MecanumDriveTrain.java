package org.firstinspires.ftc.teamcode;
//Imports
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

//Indicates what OpMode this part of code should be in
//This class is intended to be the code for our wheels, Mecanum Wheels
@TeleOp
public class MecanumDriveTrain extends OpMode {
    //Initializes all 4 motors(instance variables) for driving to be null
    DcMotor rightFront = null;
    DcMotor leftFront = null;
    DcMotor rightBack = null;
    DcMotor leftBack = null;

    //Overrides the init function of OpMode
    //meant to set the power of the motors in order to move
    @Override
    public void init(){

        //Initialized variables meant to change the values according to the gamepad
        double vertical = 0;
        double horizontal = 0;
        double pivot = 0;

        //Instances variables assigned to double or decimal values to the different gamepad
        //Set the vertical as a negative because of the different values needed for the right side as they are in reverse
        //TODO change negative signs of all variables if robot not moving or working as the values for the robot could need to be switched
        vertical = -gamepad1.left_stick_y;
        horizontal = gamepad1.left_stick_x;
        pivot = gamepad1.right_stick_x;

        //Sets Power to the motors and changed the signed of the math in order to proportion the wheels right to move
        rightFront.setPower(pivot + (-vertical + horizontal));
        rightBack.setPower(pivot + (-vertical - horizontal));
        leftBack.setPower(pivot + (-vertical - horizontal));
        leftFront.setPower(pivot + (-vertical + horizontal));


    }

    //Overrides the init_loop function inside of OpMode
    //Assigns values to the 4 motors and the direction
    @Override
    public void init_loop(){
        //Assigns values to motors from the hardWareMap
        rightFront = hardwareMap.get(DcMotor.class, "driveRightFront");
        leftFront = hardwareMap.get(DcMotor.class, "driveLeftFront");
        rightBack = hardwareMap.get(DcMotor.class, "driveRightBack");
        leftBack = hardwareMap.get(DcMotor.class, "driveLeftBack");
        //Changes direction for both right motors to Reverse in order for the robot to move(Right side motors are "flipped")
        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        rightBack.setDirection(DcMotorSimple.Direction.REVERSE);
    }


    @Override
    public void loop(){}

}
