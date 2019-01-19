package frc.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SolenoidExtend extends Command {

    public SolenoidExtend() {
        requires(Robot.armAct);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}