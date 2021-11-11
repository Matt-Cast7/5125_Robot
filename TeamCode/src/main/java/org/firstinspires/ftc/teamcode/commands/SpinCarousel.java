package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.Carousel;

import java.util.function.DoubleSupplier;

public class SpinCarousel extends CommandBase {

    private Carousel carousel;
    private DoubleSupplier trigger;

    public SpinCarousel(Carousel carousel, DoubleSupplier trigger){
        this.carousel = carousel;
        this.trigger = trigger;

    }

    @Override
    public void execute() {
        if(trigger == null){
            carousel.spin();
        }else{
            carousel.spin(trigger);
        }
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        carousel.set(0  );
    }
}
