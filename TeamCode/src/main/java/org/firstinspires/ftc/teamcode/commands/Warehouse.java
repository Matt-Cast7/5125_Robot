package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.util.Timing;

import org.firstinspires.ftc.teamcode.subsystems.DriveTrain;

import java.util.concurrent.TimeUnit;

public class Warehouse extends CommandBase {

    private final DriveTrain driveTrain;

    public Warehouse(DriveTrain driveTrain){
        this.driveTrain = driveTrain;
        addRequirements(driveTrain);
    }

    @Override
    public void execute() {

        driveTime(1000, -0.25, 0, 0);
        driveTime(2500, 0, .85, 0);
    }

    void driveTime(long time, double strafe, double forward, double turn){
        driveTrain.driveRobotCentric(strafe, forward, turn);

        Timing.Timer timer = new Timing.Timer(time, TimeUnit.MILLISECONDS);

        timer.start();
        while (timer.elapsedTime() != time){

        }
    }

    @Override
    public void end(boolean interrupted) {
        driveTrain.stop();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
