package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {

    public Joystick joystick = new Joystick(RobotMap.OI_DRIVER_CONTROLLER);
    public Button buttonX = new JoystickButton(joystick, RobotMap.OI_BUTTON_X);
    public Button buttonY = new JoystickButton(joystick, RobotMap.OI_BUTTON_Y);
    public Button buttonA = new JoystickButton(joystick, RobotMap.OI_BUTTON_A);
    public Button buttonB = new JoystickButton(joystick, RobotMap.OI_BUTTON_B);
    
    public OI() {

    }
}