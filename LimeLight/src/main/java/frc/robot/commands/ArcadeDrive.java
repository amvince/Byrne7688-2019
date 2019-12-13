package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.networktables.*;

public class ArcadeDrive extends Command {

    private static double m_speed = -RobotMap.MOTOR_SPEED;
    private static final double m_turn = RobotMap.TURN_SPEED;

    private final double MAX_DRIVE = 0.5;
   
    private boolean m_LimelightHasValidTarget = false;
    private double m_LimelightDriveCommand = 0.0;
    private double m_LimelightSteerCommand = 0.0;

    public static final NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

    public ArcadeDrive() {
        requires(Robot.drivetrain);
    }

    @Override
    protected void end() {
        Robot.drivetrain.arcadeDrive(0,0);
    }

    @Override
    protected void execute() {

        //NetworkTableEntry ledMode = table.getEntry("ledMode");
        NetworkTableEntry ledMode = RobotMap.ledMode;
        double drive = Robot.m_oi.joystick.getRawAxis(RobotMap.EX_Y) * m_speed;
        double steer = Robot.m_oi.joystick.getRawAxis(RobotMap.EX_X) * m_turn;
        boolean auto = Robot.m_oi.joystick.getRawButton(RobotMap.OI_BUTTON_X);
        
        if (drive>MAX_DRIVE) drive=MAX_DRIVE;

        if (auto) {
            ledMode.setNumber(3);
            UpdateLimelightTracking();
            if (m_LimelightHasValidTarget) {
                Robot.drivetrain.arcadeDrive(m_LimelightDriveCommand, m_LimelightSteerCommand);
            }
            else {
                Robot.drivetrain.arcadeDrive(0.0,0.0);
            }
        } else {
            ledMode.setNumber(1);
            Robot.drivetrain.arcadeDrive(drive, steer);
        }
    }
    @Override
    protected boolean isFinished() {
        return false;
    }

    public void UpdateLimelightTracking() {
        
        
        final double STEER_K = 0.015;
        final double DRIVE_K = 0.26;
        final double DESIRED_TARGET_AREA = 2.5;
        
        
        //double tv = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
        //double tv = RobotMap.tv.getDouble(0);
        double tv = Robot.limelight.tv();
        
        //double tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
        double tx = Robot.limelight.tx();
        // double ty = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0);
        //double ta = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0);
        double ta = Robot.limelight.ta();
        
        if (tv < 1.0) {
            m_LimelightHasValidTarget = false;
            m_LimelightDriveCommand = 0;
            m_LimelightSteerCommand = 0;
            return;
        }
        m_LimelightHasValidTarget = true;

        double steer_cmd = tx * STEER_K;
        m_LimelightSteerCommand = steer_cmd;
        
        double drive_cmd = (DESIRED_TARGET_AREA - ta) * DRIVE_K;

        if (drive_cmd > MAX_DRIVE) {
            drive_cmd = MAX_DRIVE;
        }
        m_LimelightDriveCommand = drive_cmd;

    }

}