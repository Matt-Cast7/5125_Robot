package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.util.Timing;

import org.firstinspires.ftc.teamcode.subsystems.DriveTrain;

import java.sql.Time;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class DriveVelocity extends CommandBase {

    private DriveTrain driveTrain;

    public DriveVelocity(DriveTrain driveTrain){
        this.driveTrain = driveTrain;
    }

    @Override
    public void execute() {
        driveTrain.setVelocity(5);

        long time = 2000;
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
