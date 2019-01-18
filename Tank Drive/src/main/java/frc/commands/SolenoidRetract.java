package frc.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SolenoidRetract extends Command {

    public SolenoidRetract() {
        requires(Robot.arm);
    }

    protected void initialize() {
        Robot.arm.retract();
    }

    protected void execute() {

    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    protected void end() {
        Robot.arm.off();
    }

    protected void interrupted() {
        end();
    }

}