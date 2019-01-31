/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ArmMove;
import frc.robot.commands.Dance;
import frc.robot.commands.TurnOnSpot;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());

  public Joystick joystick = new Joystick(RobotMap.OI_DRIVER_CONTROLLER);
  Button buttonX = new JoystickButton(joystick, RobotMap.OI_BUTTON_X);
  Button buttonY = new JoystickButton(joystick, RobotMap.OI_BUTTON_Y);
  Button buttonA = new JoystickButton(joystick, RobotMap.OI_BUTTON_A);
  Button buttonB = new JoystickButton(joystick, RobotMap.OI_BUTTON_B);

  Button buttonL = new JoystickButton(joystick, RobotMap.OI_BUTTON_SHOULDER_L);
  Button buttonR = new JoystickButton(joystick, RobotMap.OI_BUTTON_SHOULDER_R);


  public OI() 
  {
    // buttonX.whileHeld(new ArmDown());
    // buttonY.whileHeld(new ArmUp());
    // buttonA.whileHeld(new ArmSolenoid(1));
    // buttonB.whileHeld(new ArmSolenoid(-1));

    //DANGER DANGER DANGER DANGER DANGER DANGER DANGER DANGER DANGER DANGER DANGER DANGER 
    //DANGER //buttonA.whenPressed(new TurnOnSpot(TurnOnSpot.DIRECTION_LEFT)); //DANGER
    //DANGER DANGER DANGER DANGER DANGER DANGER DANGER DANGER DANGER DANGER DANGER DANGER 

    buttonX.whenPressed(new ArmMove(RobotMap.ARM_DIRECTION_FORWARD, RobotMap.ARM_MOTOR_SPEED));
    buttonY.whenPressed(new ArmMove(RobotMap.ARM_DIRECTION_BACKWARD, RobotMap.ARM_MOTOR_SPEED));

    buttonA.whenPressed(new TurnOnSpot(RobotMap.DRIVETRAIN_TURN_DIRECTION_COUNTERCLOCKWISE,
                                       RobotMap.DRIVETRAIN_TURN_90DEG_DURATION, 
                                       RobotMap.DRIVETRAIN_TURN_90DEG_SPEED));

    buttonB.whenPressed(new TurnOnSpot(RobotMap.DRIVETRAIN_TURN_DIRECTION_CLOCKWISE, 
                                       RobotMap.DRIVETRAIN_TURN_90DEG_DURATION, 
                                       RobotMap.DRIVETRAIN_TURN_90DEG_SPEED));

    
    //buttonR.whenPressed(new Dance());
  }
}
