package frc.systems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.RobotMap;

public class Arm extends Pneumatics {
    private static WPI_TalonSRX m_arm = null;
    public Arm() {
        m_arm = new WPI_TalonSRX(RobotMap.ARM_CONTROLLER);
    }

    public void forward() {
        m_arm.set(0.5);
    }

    public void reverse() {
        m_arm.set(-0.5);
    }

    public void stop() {
        m_arm.set(0.0);
    }

}