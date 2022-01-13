package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.Arm;

import java.util.function.BooleanSupplier;

public class ControlFeeder extends CommandBase {

    private Arm m_arm;

    private BooleanSupplier fspin;
    private BooleanSupplier rspin;

    double power = 1;

    public ControlFeeder(Arm m_arm, BooleanSupplier fspin, BooleanSupplier rspin){
        this.m_arm = m_arm;

        this.fspin = fspin;
        this.rspin = rspin;

    }

    @Override
    public void execute() {
        if(fspin.getAsBoolean()){
            m_arm.setFeeder(power);
        }else if(rspin.getAsBoolean()){
            m_arm.setFeeder(-power);
        }
    }

    @Override
    public void end(boolean interrupted) {
        m_arm.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
