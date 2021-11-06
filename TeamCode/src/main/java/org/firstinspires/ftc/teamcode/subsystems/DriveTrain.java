package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveTrain extends SubsystemBase {

    private MecanumDrive drive;
    private Motor fL, fR, bL, bR;

    public DriveTrain(final HardwareMap hwMap){

        fL = new Motor(hwMap, "fL");
        fR = new Motor(hwMap, "fR");
        bL = new Motor(hwMap, "bL");
        bR = new Motor(hwMap, "bR");

        drive = new MecanumDrive(fL, fR, bL, bR);

    }


    @Override
    public void periodic() {

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
