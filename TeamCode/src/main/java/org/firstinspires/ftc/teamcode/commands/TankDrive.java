package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Vector2D;
import org.firstinspires.ftc.teamcode.subsystems.DriveTrain;

import java.util.function.DoubleSupplier;

public class TankDrive extends CommandBase {

    private final DriveTrain m_DriveTrain;

    private final DoubleSupplier leftY;
    private final DoubleSupplier leftX;
    private final DoubleSupplier rightX;

    Vector2D joyVec;

//    private enum QUADRANT{
//        FIRST,
//        SECOND,
//        THIRD,
//        FOURTH
//    }


    public TankDrive(DriveTrain m_DriveTrain, DoubleSupplier leftY, DoubleSupplier leftX, DoubleSupplier rightX) {
        this.m_DriveTrain = m_DriveTrain;

        this.leftY = leftY;
        this.leftX = leftX;
        this.rightX = rightX;

        joyVec = new Vector2D(leftX.getAsDouble(), leftY.getAsDouble());
        addRequirements(m_DriveTrain);
    }

    @Override
    public void execute() {
        //QUADRANT quadrant = getQuadrant();

        double x = leftX.getAsDouble();
        double y = leftY.getAsDouble();
        joyVec.update(x, y);

        m_DriveTrain.set(x + y, -x + y, -x + y, x + y);


        if (rightX.getAsDouble() != 0) {
            m_DriveTrain.set(rightX.getAsDouble(), -rightX.getAsDouble());
        } else {
            if (x == 0 || y == 0) {
                m_DriveTrain.set(y);
            } else {
                m_DriveTrain.set(x + y, -x + y, -x + y, x + y);
            }
        }

/*
        switch(quadrant){
            case FIRST:
                m_DriveTrain.set(x + y, -x + y, -x + y, x + y);
                break;
            case SECOND:
                m_DriveTrain.set(x + y, -x + y, -x + y, x + y);
                break;
            case THIRD:
                m_DriveTrain.set(x + y, -x + y, -x + y, x + y);
                break;
            case FOURTH:
                m_DriveTrain.set(x + y, -x + y, -x + y, x + y);
                break;
        }
*/

    }
    @Override
    public boolean isFinished() {
        return false;
    }


    @Override
    public void end(boolean interuppted){
        m_DriveTrain.set(0);
    }

//    public QUADRANT getQuadrant(){
//        double x = leftX.getAsDouble();
//        double y = leftY.getAsDouble();
//
//        if(x > 0 && y > 0){
//            return QUADRANT.FIRST;
//        }else if(x < 0 && y > 0){
//            return QUADRANT.SECOND;
//        }else if(x < 0 && y < 0){
//            return QUADRANT.THIRD;
//        }else{
//            return QUADRANT.FOURTH;
//        }
//
//    }

}
