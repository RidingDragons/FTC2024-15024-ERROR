package org.firstinspires.ftc.teamcode;
//Imports
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;


//Clark Robotics 15024 Hardware Map
//Currently only have the motors from the robot powering the wheels
//driveRightFront, driveRightBack, driveLeftFront, driveRightBack
public class Clark15024HWMap {
    //Instances variables which makes the variables we can use or assign later
    // null - placeholder of a variable and basically has nothing in the variable currently
    public DcMotor driveRightFront = null;
    public DcMotor driveLeftFront = null;
    public DcMotor driveRightBack = null;
    public DcMotor driveLeftBack = null;
    public DcMotor linearMotionUp1 = null;
    public DcMotor linearMotionUp2 = null;
    public DcMotor linearMotionRight1 = null;
    public DcMotor intakeHD = null;

    HardwareMap hM = null;
    //Map fucntion which we can use to assign values to the instance variables
    //HWM - HardwareMap parameter which we can use to pull values from which are mostly used to assign to values
    public void Map(HardwareMap HWM){
        //Assigns values to instance variables using the parameter which the .get functions to pull the information from the control hub
        hM = HWM;
        driveLeftBack = HWM.get(DcMotor.class, "driveLeftBack");
        driveLeftFront = HWM.get(DcMotor.class, "driveLeftFront");
        driveRightFront = HWM.get(DcMotor.class, "driveRightFront");
        driveRightBack = HWM.get(DcMotor.class, "driveRightBack");

        linearMotionUp1 = HWM.get(DcMotor.class, "linearMotionUp1");
        linearMotionUp2 = HWM.get(DcMotor.class, "linearMotionUp2");
        linearMotionRight1 = HWM.get(DcMotor.class, "linearMotionRight1");


        //Using functions from the DcMotor class, this changes the direction of the motor, sets the power to 0, and makes the runmode to run without encoder as the robot is not moving
        //The direction of the some variables are different because they are needed to offset each other to move
        driveLeftBack.setDirection(DcMotorSimple.Direction.FORWARD);
        driveLeftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        driveLeftBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        driveLeftFront.setDirection(DcMotorSimple.Direction.FORWARD);
        driveLeftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        driveLeftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        driveRightBack.setDirection(DcMotorSimple.Direction.REVERSE);
        driveRightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        driveRightBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        driveRightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        driveRightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        driveRightFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    }

}
