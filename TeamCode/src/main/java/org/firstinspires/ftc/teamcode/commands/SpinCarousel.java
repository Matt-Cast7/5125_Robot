package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.util.Timing;

import org.firstinspires.ftc.teamcode.subsystems.Carousel;

import java.util.Timer;
import java.util.concurrent.TimeUnit;
import java.util.function.DoubleSupplier;

public class SpinCarousel extends CommandBase {

    private Carousel carousel;
    private DoubleSupplier rtrigger;
    private DoubleSupplier ltrigger;
    private boolean red;

    public SpinCarousel(Carousel carousel, DoubleSupplier rtrigger, DoubleSupplier ltrigger){
        this.carousel = carousel;
        this.rtrigger = rtrigger;
        this.ltrigger = ltrigger;

    }
    public SpinCarousel(Carousel carousel, boolean red){
        this.carousel = carousel;
        this.red = red;

    }

    @Override
    public void execute() {
        if(rtrigger == null){
            carousel.spin(red);
            Timing.Timer time = new Timing.Timer(8, TimeUnit.SECONDS);
            time.start();
            while(!time.done()){

            }

        }else{
            carousel.spin(rtrigger, ltrigger);
        }
    }

    @Override
    public boolean isFinished() {

        if(rtrigger == null){
            return true;
        }else{
            return false;
        }

    }

    @Override
    public void end(boolean interrupted) {
        carousel.set(0  );
    }
}
