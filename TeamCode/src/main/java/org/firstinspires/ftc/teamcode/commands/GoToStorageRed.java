package org.firstinspires.ftc.teamcode.commands;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

public class GoToStorageRed extends CommandBase {

    private SampleMecanumDrive drive;
    private Trajectory traj;
    private Trajectory traj2;

    public GoToStorageRed(SampleMecanumDrive drive){
        this.drive = drive;

    }

    @Override
    public void initialize() {
        traj = drive.trajectoryBuilder(new Pose2d(drive.getPoseEstimate().getX(), drive.getPoseEstimate().getY()))
                .strafeLeft(24)
                .build();

        traj2 = drive.trajectoryBuilder(new Pose2d())
                .back(6).build();
    }

    @Override
    public void execute() {

        drive.followTrajectory(traj);
        //drive.followTrajectory(traj2);

    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
