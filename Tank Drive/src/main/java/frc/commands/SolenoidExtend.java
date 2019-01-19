package frc.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SolenoidExtend extends Command {

    public SolenoidExtend() {
        requires(Robot.armAct);
    }

    public void initialize() {
        Robot.armAct.extend();
    }

    public void end() {
        Robot.armAct.off();
    }

    public void interrupted() {
        end();
    }
    
    @Override
    protected boolean isFinished() {
        return false;
    }

}