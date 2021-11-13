package org.firstinspires.ftc.teamcode;


import static org.firstinspires.ftc.teamcode.TeleRobot.joy1;
import static org.firstinspires.ftc.teamcode.TeleRobot.joy2;
import static org.firstinspires.ftc.teamcode.TeleRobot.t_telemetry;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.kinematics.HolonomicOdometry;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.commands.MecanumDriveTrain;
import org.firstinspires.ftc.teamcode.commands.Warehouse;
import org.firstinspires.ftc.teamcode.mode.Auto;
import org.firstinspires.ftc.teamcode.mode.Tele;
import org.firstinspires.ftc.teamcode.commands.DriveMode;
import org.firstinspires.ftc.teamcode.commands.ResetAngle;
import org.firstinspires.ftc.teamcode.commands.SpinCarousel;
import org.firstinspires.ftc.teamcode.subsystems.Carousel;
import org.firstinspires.ftc.teamcode.subsystems.DriveTrain;
import org.firstinspires.ftc.teamcode.subsystems.Gyro;
import org.firstinspires.ftc.teamcode.subsystems.Odo;

public class RobotContainer {

    public DriveTrain m_DriveTrain;
    public Gyro gyro;
    public Carousel carousel;

    public Command mecanumDrive;

    public Command switchMode;
    public Command resetAngle;
    public Command spinCarousel;

    public Warehouse warehouse;

    public Odo odometry;

    public RobotContainer(HardwareMap hwMap, Tele t){

        gyro = new Gyro(hwMap);
        m_DriveTrain = new DriveTrain(hwMap);
        carousel = new Carousel(hwMap);

        mecanumDrive = new MecanumDriveTrain(m_DriveTrain,
                joy1::getLeftY,
                joy1::getLeftX,
                joy1::getRightX,
                t_telemetry);


        switchMode = new DriveMode();
        resetAngle = new ResetAngle(gyro);

        spinCarousel = new SpinCarousel(carousel, () -> TeleRobot.joy2.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER));


     //   odometry = new Odo(new HolonomicOdometry())


        configurations();

    }

    public void configurations(){

        joy2.getGamepadButton(GamepadKeys.Button.BACK).whenReleased(resetAngle);
        joy2.getGamepadButton(GamepadKeys.Button.Y).whenReleased(switchMode);


    }

    public ParallelCommandGroup getTeleOpCommands(){
        return new ParallelCommandGroup(mecanumDrive, spinCarousel);
    }




    public RobotContainer(HardwareMap hwMap, Auto a){

        gyro = new Gyro(hwMap);
        m_DriveTrain = new DriveTrain(hwMap);
        carousel = new Carousel(hwMap);

        warehouse = new Warehouse(m_DriveTrain);



    }


    public Command getAutoCommand(){
        return warehouse;
    }





}
