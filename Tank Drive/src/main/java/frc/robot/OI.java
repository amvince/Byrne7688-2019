package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ArmDown;
import frc.robot.commands.ArmSolenoid;
import frc.robot.commands.ArmUp;

public class OI {
  
  public Joystick joystick = new Joystick(RobotMap.OI_DRIVER_CONTROLLER);
  Button buttonX = new JoystickButton(joystick, RobotMap.OI_BUTTON_X);
  Button buttonY = new JoystickButton(joystick, RobotMap.OI_BUTTON_Y);
  Button buttonA = new JoystickButton(joystick, RobotMap.OI_BUTTON_A);
  Button buttonB = new JoystickButton(joystick, RobotMap.OI_BUTTON_B);
  // might want to define trigger buttons for another function, such as the lifter
  
  public OI() {
    buttonX.whileHeld(new ArmDown());
    buttonY.whileHeld(new ArmUp());
    buttonA.whileHeld(new ArmSolenoid(1));
    buttonB.whileHeld(new ArmSolenoid(-1));
    /* TODO: Add single "release" button
     buttonWHATEVER.whenPressed(new Release());

     TOOD: Add lefter buttons
     buttonWHATEVER.whileHeld(new LiftSolenoid(1));
     buttonWHATEVER.whileHeld(new LiftSolenoid(-1));

     */
  }
}
