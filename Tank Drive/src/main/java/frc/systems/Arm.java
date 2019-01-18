package frc.systems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Arm extends Subsystem {
    
    // Initialize Pneumatic release mechanism
    private Pneumatics hatchRelease =null; 
    // Initialize Motor controller to lower & raise hatch arm
    private WPI_TalonSRX rotator = null; 
    // Initialize current arm position indicator
    // Will we need a position controller feedback or limit switches to help
    private int armPos = 0;

    public Arm() {
        rotator = new WPI_TalonSRX(RobotMap.ARM_CONTROLLER);
        hatchRelease = new Pneumatics();
    }

    public void extend() {
        hatchRelease.extend();
    }

    public void retract() {
        hatchRelease.retract();
    }

    public void off() {
        hatchRelease.off();
    }
    public void rotateTo(int angle) {
        /* TODO: create function to rotate arm to a specific position
            We may need to implement a return value from our motors
            or add limit-switches to the robot arm to achieve this
        */
    }
    public void initDefaultCommand() {

    }
}