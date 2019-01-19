package frc.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Release extends Command {

    private double m_timeout = 0.5;

    public Release() {
        requires(Robot.armAct);
    }

    public void initialize() {
        Robot.armAct.extend();
        Timer.delay(m_timeout);
        Robot.armAct.retract();
        Timer.delay(m_timeout);
        Robot.armAct.off();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

}