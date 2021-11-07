package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.DriveMode;
import org.firstinspires.ftc.teamcode.commands.ResetAngle;
import org.firstinspires.ftc.teamcode.commands.MecanumDriveTrain;
import org.firstinspires.ftc.teamcode.subsystems.DriveTrain;
import org.firstinspires.ftc.teamcode.subsystems.Gyro;

@TeleOp(name = "TeleRobot")
public class TeleRobot extends CommandOpMode {

    private GamepadEx joy1;

    private DriveTrain m_DriveTrain;
    private Gyro gyro;

    private Command teleOp;
    private Command mode;
    private Command resetAngle;

    @Override
    public void initialize(){
        joy1 = new GamepadEx(gamepad1);

        gyro = new Gyro(hardwareMap);
        m_DriveTrain = new DriveTrain(hardwareMap);

        mode = new DriveMode();
        resetAngle = new ResetAngle(gyro);

        teleOp = new MecanumDriveTrain(
                m_DriveTrain,
                gyro,
                joy1::getLeftY,
                joy1::getLeftX,
                joy1::getRightX,
                telemetry);


        register(m_DriveTrain, gyro);
        teleOp.schedule();
        joy1.getGamepadButton(GamepadKeys.Button.START).whenReleased(mode);
        joy1.getGamepadButton(GamepadKeys.Button.BACK).whenReleased(resetAngle);

    }

}
