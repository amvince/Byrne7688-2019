package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class TankDrive extends Command {

    private static final double m_speed = -RobotMap.MOTOR_SPEED;

    public TankDrive() {
        requires(Robot.drivetrain);
    }

    @Override
    protected void end() {
        Robot.drivetrain.tankDrive(0,0);
    }

    @Override
    protected void execute() {
        Robot.drivetrain.tankDrive(Robot.m_oi.joystick.getRawAxis(1) * m_speed,
                Robot.m_oi.joystick.getRawAxis(5) * m_speed);
    }
    @Override
    protected boolean isFinished() {
        return false;
    }


}