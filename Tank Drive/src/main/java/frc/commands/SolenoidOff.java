package frc.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SolenoidOff extends Command {

    public SolenoidOff() {
        requires(Robot.armAct);
    }

    protected void initialize() {
        Robot.armAct.off();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

}