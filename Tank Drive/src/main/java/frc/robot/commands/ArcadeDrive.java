package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class ArcadeDrive extends Command {

    private static final double m_speed = -RobotMap.MOTOR_SPEED;

    public ArcadeDrive() {
        requires(Robot.drivetrain);
    }

    @Override
    protected void end() {
        Robot.drivetrain.arcadeDrive(0,0);
    }

    @Override
    protected void execute() {
        Robot.drivetrain.arcadeDrive(Robot.m_oi.joystick.getRawAxis(RobotMap.EX_Y) * m_speed,
                -Robot.m_oi.joystick.getRawAxis(RobotMap.EX_X) * m_speed);
    }
    @Override
    protected boolean isFinished() {
        return false;
    }


}