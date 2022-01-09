package org.firstinspires.ftc.teamcode.commands;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.util.Timing;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Park extends CommandBase {

    private SampleMecanumDrive drive;

    ArrayList<Trajectory> trajectories;

    boolean red;

    public Park(SampleMecanumDrive drive, boolean red){
        this.drive = drive;
        this.red = red;
        trajectories = new ArrayList<Trajectory>();
    }

    @Override
    public void initialize() {
        if(red){

            trajectories.add(drive.trajectoryBuilder(new Pose2d()).lineToSplineHeading(new Pose2d(-24, 24)).build());
        }else{
            trajectories.add(drive.trajectoryBuilder(new Pose2d()).lineToSplineHeading(new Pose2d(-24, -24)).build());
        }
    }

    @Override
    public void execute() {
        for(Trajectory traj : trajectories){
            drive.followTrajectory(traj);
        }
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
