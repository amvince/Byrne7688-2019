package frc.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SolenoidExtend extends Command {

    public SolenoidExtend() {
        requires(Robot.arm);
    }

    protected void initialize() {
        Robot.arm.extend();
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