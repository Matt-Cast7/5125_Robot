package org.firstinspires.ftc.teamcode;


import static org.firstinspires.ftc.teamcode.TeleRobot.joy1;
import static org.firstinspires.ftc.teamcode.TeleRobot.joy2;
import static org.firstinspires.ftc.teamcode.TeleRobot.t_telemetry;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.LED;

import org.firstinspires.ftc.teamcode.commands.CarouselBlue;
import org.firstinspires.ftc.teamcode.commands.CarouselRed;
import org.firstinspires.ftc.teamcode.commands.ControlArm;
import org.firstinspires.ftc.teamcode.commands.ControlFeeder;
import org.firstinspires.ftc.teamcode.commands.GoToStorageBlue;
import org.firstinspires.ftc.teamcode.commands.GoToStorageRed;
import org.firstinspires.ftc.teamcode.commands.MecanumDriveTrain;
import org.firstinspires.ftc.teamcode.commands.Park;
import org.firstinspires.ftc.teamcode.commands.ParkRed;
import org.firstinspires.ftc.teamcode.commands.Turn;
import org.firstinspires.ftc.teamcode.commands.Warehouse;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.mode.Auto;
import org.firstinspires.ftc.teamcode.mode.Tele;
import org.firstinspires.ftc.teamcode.commands.DriveMode;
import org.firstinspires.ftc.teamcode.commands.ResetAngle;
import org.firstinspires.ftc.teamcode.commands.SpinCarousel;
import org.firstinspires.ftc.teamcode.subsystems.Arm;
import org.firstinspires.ftc.teamcode.subsystems.Carousel;
import org.firstinspires.ftc.teamcode.subsystems.DriveTrain;
import org.firstinspires.ftc.teamcode.subsystems.Gyro;
import org.firstinspires.ftc.teamcode.subsystems.LEDS;
import org.firstinspires.ftc.teamcode.subsystems.Odo;

public class RobotContainer {

    public DriveTrain m_DriveTrain;
    public Gyro gyro;
    public Carousel carousel;
    public SampleMecanumDrive drive;
    public Arm arm;
    public static LEDS leds;

    public Command mecanumDrive;

    public Command switchMode;
    public Command resetAngle;
    public Command spinCarousel;

    public Command redAllianceCarousel;
    public Command blueAllianceCarousel;
    public Command toStorageRED;
    public Command toStorageBLUE;

    public Command parkRed;
    public Command parkBlue;

    public Command spin;
    public Command turn;

    public Command controlArm;
    public Command controlFeeder;


    public Warehouse warehouse;

    public Odo odometry;

    public RobotContainer(HardwareMap hwMap, Tele t){

        gyro = new Gyro(hwMap);
        m_DriveTrain = new DriveTrain(hwMap);
        carousel = new Carousel(hwMap);

        arm = new Arm(hwMap, t_telemetry);


        mecanumDrive = new MecanumDriveTrain(m_DriveTrain,
                gyro,
                joy1::getLeftY,
                joy1::getLeftX,
                joy1::getRightX,
                t_telemetry);


        switchMode = new DriveMode();
        resetAngle = new ResetAngle(gyro);

        spinCarousel = new SpinCarousel(carousel, () -> TeleRobot.joy2.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER),
                () -> joy2.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER));

        controlArm = new ControlArm(arm, () -> joy2.getLeftX(), () -> joy2.getLeftY());
        controlFeeder = new ControlFeeder(arm, () -> joy2.getButton(GamepadKeys.Button.A), () -> joy2.getButton(GamepadKeys.Button.B));



     //   odometry = new Odo(new HolonomicOdometry())


        configurations();

    }

    public void configurations(){

        joy2.getGamepadButton(GamepadKeys.Button.BACK).whenReleased(resetAngle);
        joy2.getGamepadButton(GamepadKeys.Button.Y).whenReleased(switchMode);


    }

    public ParallelCommandGroup getTeleOpCommands(){
        new GamepadButton(joy1, GamepadKeys.Button.BACK).whenReleased(switchMode);
        return new ParallelCommandGroup(mecanumDrive, spinCarousel, controlArm, controlFeeder);
    }




    public RobotContainer(HardwareMap hwMap, Auto a, boolean red){

        gyro = new Gyro(hwMap);
        m_DriveTrain = new DriveTrain(hwMap);
        carousel = new Carousel(hwMap);


        warehouse = new Warehouse(m_DriveTrain);
        drive = new SampleMecanumDrive(hwMap);



        if(red){

            redAllianceCarousel = new CarouselRed(drive);
            toStorageRED = new GoToStorageRed(drive);
            spin = new SpinCarousel(carousel, true);
            parkRed = new Park(drive, true);




        }else{
            blueAllianceCarousel = new CarouselBlue(drive);
            toStorageBLUE = new GoToStorageBlue(drive);
            spin = new SpinCarousel(carousel, false);
            parkBlue = new Park(drive, false);

        }



    }




    public Command getParkRed(){
        return parkRed;
    }
    public Command getParkBlue(){
        return parkBlue;
    }

    public Command getBlueAuto(){

        return new SequentialCommandGroup(blueAllianceCarousel, spin, new Turn(drive, 30), toStorageBLUE);
    }

    public Command getRedAuto(){
        return new SequentialCommandGroup(redAllianceCarousel, spin, toStorageRED);
    }

}
