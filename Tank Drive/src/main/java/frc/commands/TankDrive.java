package frc.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class TankDrive extends Command {

    private static final double m_speed = -1.0;

    public TankDrive() {
        requires(Robot.drivetrain);
    }

    protected void initialize() {

    }

    protected void end() {
        Robot.drivetrain.tankDrive(0,0);
    }
    
    protected void interrupt() {
        end();
    }

    protected void execute() {
        Robot.drivetrain.tankDrive(Robot.oi.joystick.getRawAxis(1)*m_speed, Robot.oi.joystick.getRawAxis(5)*m_speed);
    }
    @Override
    protected boolean isFinished() {
        return false;
    }


}