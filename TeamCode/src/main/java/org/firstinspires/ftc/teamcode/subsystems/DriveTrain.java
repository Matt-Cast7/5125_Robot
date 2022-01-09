package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.geometry.Pose2d;
import com.arcrobotics.ftclib.geometry.Rotation2d;
import com.arcrobotics.ftclib.geometry.Translation2d;
import com.arcrobotics.ftclib.geometry.Vector2d;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.arcrobotics.ftclib.hardware.motors.MotorGroup;
import com.qualcomm.hardware.motors.NeveRest40Gearmotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.checkerframework.checker.units.qual.Angle;
import org.firstinspires.ftc.robotcore.external.Const;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.util.Encoder;

import java.util.Base64;

public class DriveTrain extends SubsystemBase {

    private MecanumDrive drive;
    private MotorEx fL, fR, bL, bR;
    private MotorEx.Encoder fLEncoder, fREncoder,bLEncoder,bREncoder;

    private Pose2d position;

    private MotorGroup leftmotors;
    private MotorGroup rightmotors;
    private MotorGroup allmotors;



    public DriveTrain(final HardwareMap hwMap){

        position = new Pose2d(new Translation2d(0, 0), Rotation2d.fromDegrees(Gyro.globalAngle));

        fL = new MotorEx(hwMap, "fL", Constants.CPR, Constants.RPM);
        fR = new MotorEx(hwMap, "fR", Constants.CPR, Constants.RPM);
        bL = new MotorEx(hwMap, "bL", Constants.CPR, Constants.RPM);
        bR = new MotorEx(hwMap, "bR", Constants.CPR, Constants.RPM);

        fLEncoder = fL.encoder;
        fREncoder = fR.encoder;
        bLEncoder = bL.encoder;
        bREncoder = bR.encoder;




//        fL.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
//        fR.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
//        bL.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
//        bR.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);

        drive = new MecanumDrive(fL, fR, bL, bR);

        leftmotors = new MotorGroup(fL, bL);
        rightmotors = new MotorGroup(fR, bR);
        //allmotors = new MotorGroup(fL, fR, bL, bR);

        //allmotors.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);


    }




    @Override
    public void periodic() {

    }

    /**
     * @param IPS inches per second
     */
    public void setVelocity(double IPS){
        IPS = Constants.inchesToTicks(IPS);
        fL.setVelocity(IPS);
        fR.setVelocity(IPS);
        bL.setVelocity(IPS);
        bR.setVelocity(IPS);

    }

    public void driveFieldCentric(double strafeSpeed, double forwardSpeed, double turnSpeed, double gyroAngle){
        drive.driveFieldCentric(strafeSpeed, forwardSpeed, -turnSpeed, gyroAngle);
    }

    public void driveRobotCentric(double strafeSpeed, double forwardSpeed, double turnSpeed){
        drive.driveRobotCentric(strafeSpeed, forwardSpeed, -turnSpeed);
    }



    public void stop(){
        drive.stop();
    }


    public void driveDistance(Vector2d displacement, double power){

        //Vector2d[] vectors = Constants.robotWheelVectors(displacement);

//        while(getDistanceTraveled() < displacement.magnitude()){
//
//            if(angleFirstQuad){
//                driveRobotCentric();
//            }
//
//        }


    }


}
