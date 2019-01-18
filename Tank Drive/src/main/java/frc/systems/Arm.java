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

    public void release() {
        // TODO: create cycle to fire hatchRelease piston 
        // for placement of hatch disk.
        // Should this "command" be placed inside a commands subsection?
        hatchRelease.extend();
        // wait half a second
        hatchRelease.retract();
        // wait half a second
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