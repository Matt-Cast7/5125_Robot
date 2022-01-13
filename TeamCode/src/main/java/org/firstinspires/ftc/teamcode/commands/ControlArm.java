package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.Arm;

import java.util.function.DoubleSupplier;

public class ControlArm extends CommandBase {

    private Arm m_arm;

    private DoubleSupplier horizontal;
    private DoubleSupplier vertical;

    public ControlArm(Arm m_arm, DoubleSupplier horizontal, DoubleSupplier vertical){

        this.m_arm = m_arm;

        this.horizontal = horizontal;
        this.vertical = vertical;

    }

    @Override
    public void execute() {
        m_arm.setHorizontal(horizontal.getAsDouble());
        setVerticalPosition((int)vertical.getAsDouble());

    }

    public void setVerticalPosition(int position){
        m_arm.setVertical(m_arm.getVerticalPosition() + position);
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
