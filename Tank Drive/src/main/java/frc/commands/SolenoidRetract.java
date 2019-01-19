package frc.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SolenoidRetract extends Command {

    public SolenoidRetract() {
        requires(Robot.armAct);
    }

    protected void initialize() {
        Robot.armAct.retract();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    protected void end() {
        Robot.armAct.off();
    }

    protected void interrupted() {
        end();
    }

}