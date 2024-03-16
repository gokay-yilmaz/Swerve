package frc.robot.subsystems.swervedrive;

import com.revrobotics.CANSparkMax;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {

private final CANSparkMax shooter_upperL = new CANSparkMax(22, MotorType.kBrushless);
private final CANSparkMax shooter_upperR = new CANSparkMax(23, MotorType.kBrushless);
private final VictorSPX shooter_lower = new VictorSPX(25);
Timer shooTimer = new Timer();

  /** Creates a new ExampleSubsystem. */
  public ShooterSubsystem() {}

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public void ShootUpper() {
    shooTimer.reset();
    shooTimer.start();
    boolean a = true;
    while(a)
    {
      shooter_upperL.set(0.6);
      shooter_upperR.set(-0.30);
      if(shooTimer.get() > 1 && shooTimer.get() < 2)
      {
        shooter_lower.set(VictorSPXControlMode.PercentOutput, -0.17);
      }
      
      else if(shooTimer.get() > 2.5)
      {
        shooTimer.stop();
        shooter_upperL.set(0);
        shooter_upperR.set(0);
        shooter_lower.set(VictorSPXControlMode.PercentOutput, 0);
        a = false;
        break;
      }
    }

  }

    public void StopUpper() {
    shooter_upperL.set(0);
    shooter_upperR.set(0);
  }
  /* 

  public void ShootLower(){
    shooter_lower.set(VictorSPXControlMode.PercentOutput, -0.15); 
  }

  public void StopLower(){
    shooter_lower.set(VictorSPXControlMode.PercentOutput, 0);
  }*/

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}