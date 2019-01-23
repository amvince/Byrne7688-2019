package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ArmMotion;
import frc.robot.commands.ArmSolenoid;

public class OI {
  
  public Joystick joystick = new Joystick(RobotMap.OI_DRIVER_CONTROLLER);
  Button buttonX = new JoystickButton(joystick, RobotMap.OI_BUTTON_X);
  Button buttonY = new JoystickButton(joystick, RobotMap.OI_BUTTON_Y);
  Button buttonA = new JoystickButton(joystick, RobotMap.OI_BUTTON_A);
  Button buttonB = new JoystickButton(joystick, RobotMap.OI_BUTTON_B);
  
  public OI() {
    buttonX.whileHeld(new ArmMotion(1.0));
    buttonY.whileHeld(new ArmMotion(-1.0));
    buttonA.whileHeld(new ArmSolenoid(1));
    buttonB.whileHeld(new ArmSolenoid(-1));
  }
}
