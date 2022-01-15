package org.firstinspires.ftc.teamcode.commands;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.Arm;

import java.util.function.DoubleSupplier;

@Config
public class ControlArm extends CommandBase {

    private Arm m_arm;

    private DoubleSupplier horizontal;
    private DoubleSupplier vertical;

    public static double hor;

    public ControlArm(Arm m_arm, DoubleSupplier horizontal, DoubleSupplier vertical){

        this.m_arm = m_arm;

        this.horizontal = horizontal;
        this.vertical = vertical;
        hor = 0;

    }

    @Override
    public void execute() {

        hor = horizontal.getAsDouble();
        m_arm.setHorizontal(horizontal.getAsDouble());

        setVerticalPosition(vertical.getAsDouble());

    }

    public void setVerticalPosition(double angle){
        m_arm.setVertical(angle);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        m_arm.stop();
    }
}
