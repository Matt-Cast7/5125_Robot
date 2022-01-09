package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

public class Turn extends CommandBase {

    private SampleMecanumDrive drive;
    private double angle;

    public Turn(SampleMecanumDrive drive, double angle){
        this.drive = drive;
        this.angle = angle;


    }


    @Override
    public void execute() {
        drive.turn(angle);
    }


    @Override
    public boolean isFinished() {
        return true;
    }
}
