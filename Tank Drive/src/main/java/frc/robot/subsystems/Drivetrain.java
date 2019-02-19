package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.TankDrive;

public class Drivetrain extends Subsystem {
    
    private static WPI_VictorSPX left_f, left_r, right_f, right_r;
    private static DifferentialDrive m_drive;
    private static SpeedControllerGroup m_left, m_right;

    public Drivetrain() {
        left_f = new WPI_VictorSPX(RobotMap.DRIVETRAIN_LEFT_FRONT);
        left_r = new WPI_VictorSPX(RobotMap.DRIVETRAIN_LEFT_REAR);
        right_f = new WPI_VictorSPX(RobotMap.DRIVETRAIN_RIGHT_FRONT);
        right_r = new WPI_VictorSPX(RobotMap.DRIVETRAIN_RIGHT_REAR);

        m_left = new SpeedControllerGroup(left_f, left_r);
        m_right = new SpeedControllerGroup(right_f, right_r);
        m_drive = new DifferentialDrive(m_left, m_right);
    }
    
    public void tankDrive(double leftSpeed, double rightSpeed) {
        m_drive.tankDrive(leftSpeed, rightSpeed);
    }

    public void arcadeDrive(double speed, double direction) {
        m_drive.arcadeDrive(speed, direction);
    }
    public void stop() {
        m_drive.tankDrive(0,0);
    }

    public void initDefaultCommand() {
        // Uncomment depending on the drive type you wish to initialize
        // setDefaultCommand(new TankDrive());
        setDefaultCommand(new ArcadeDrive());
    }
}