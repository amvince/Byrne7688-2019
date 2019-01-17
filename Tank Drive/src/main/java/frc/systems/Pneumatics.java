package frc.systems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Pneumatics extends Subsystem {
    private final static Compressor c = new Compressor(RobotMap.PN_COMPRESSOR);
    private DoubleSolenoid ds=null;

    public Pneumatics() {
        ds = new DoubleSolenoid(RobotMap.PN_SOLENOID_AF, RobotMap.PN_SOLENOID_AR);
    }

    public Pneumatics(int solExtend, int solRetract) {
        ds = new DoubleSolenoid(solExtend, solRetract);
    }

    public void extend() {
        ds.set(DoubleSolenoid.Value.kForward);
    }

    public void retract() {
        ds.set(DoubleSolenoid.Value.kReverse);
    }

    public void off() {
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