package frc.systems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Pneumatics extends Subsystem {
    static Compressor c;
    static DoubleSolenoid ds;

    public Pneumatics() {
        c = new Compressor(RobotMap.PN_COMPRESSOR);
        ds = new DoubleSolenoid(RobotMap.PN_SOLENOID_AF, RobotMap.PN_SOLENOID_AR);
    }

    public static void extend() {
        ds.set(DoubleSolenoid.Value.kForward);
    }

    public static void retract() {
        ds.set(DoubleSolenoid.Value.kReverse);
    }

    public static void off() {
        ds.set(DoubleSolenoid.Value.kOff);
    }

    public static void cOff() {
        c.stop();
    }

    public static void cOn() {
        c.start();
    }
    public void initDefaultCommand() {

    }
}