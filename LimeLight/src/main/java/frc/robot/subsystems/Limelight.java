/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Limelight extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public NetworkTableEntry ledMode = RobotMap.ledMode;
  public NetworkTableEntry camMode = RobotMap.camMode;
  public NetworkTableEntry pipeline = RobotMap.pipeline;

  double validTarget = RobotMap.tv.getDouble(0.0);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void visionMode() {
    camMode.setNumber(0);
    pipeline.setNumber(0);
  }

  public void driverMode() {
    camMode.setNumber(1);
    pipeline.setNumber(0);
  }

  public void lightOn() {
    ledMode.setNumber(3);
  }

  public void lightOff() {
    ledMode.setNumber(1);
  }

  public void lightAuto() {
    ledMode.setNumber(0);
  }

  public boolean noValidTarget() {
    if (validTarget == 0) {
      System.out.println("ERROR: Lost Target");
      return true;
    } else {
      return false;
    }
  }

  public double tv() {
    return RobotMap.tv.getDouble(0);
  }

  public double tx() {
    return RobotMap.tx.getDouble(0);
  }

  public double ta() {
    return RobotMap.ta.getDouble(0);
  }

  public double ty(){
    return RobotMap.ty.getDouble(0);
  }
}
