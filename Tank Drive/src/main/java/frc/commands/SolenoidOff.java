package frc.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SolenoidOff extends Command {

    public SolenoidOff() {
        requires(Robot.arm);
    }

    protected void initialize() {
        Robot.arm.off();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }

}