package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.arcrobotics.ftclib.hardware.motors.MotorGroup;
import com.qualcomm.hardware.motors.NeveRest40Gearmotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Const;
import org.firstinspires.ftc.teamcode.Constants;

public class DriveTrain extends SubsystemBase {

    private MecanumDrive drive;
    private MotorEx fL, fR, bL, bR;

    private MotorGroup leftmotors;
    private MotorGroup rightmotors;

    public DriveTrain(final HardwareMap hwMap){

        fL = new MotorEx(hwMap, "fL", Constants.CPR, Constants.RPM);
        fR = new MotorEx(hwMap, "fR", Constants.CPR, Constants.RPM);
        bL = new MotorEx(hwMap, "bL", Constants.CPR, Constants.RPM);
        bR = new MotorEx(hwMap, "bR", Constants.CPR, Constants.RPM);

        drive = new MecanumDrive(fL, fR, bL, bR);

        leftmotors = new MotorGroup(fL, bL);
        rightmotors = new MotorGroup(fR, bR);

    }


    @Override
    public void periodic() {

    }

    /**
    @param IPS - inches per second
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

}
