package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.OdometrySubsystem;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.geometry.Pose2d;
import com.arcrobotics.ftclib.kinematics.Odometry;

public class Odo extends OdometrySubsystem {

    public Odo(Odometry odometry) {
        super(odometry);
    }

    @Override
    public Pose2d getPose() {
        return super.getPose();
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void periodic() {
        super.periodic();
    }
}
