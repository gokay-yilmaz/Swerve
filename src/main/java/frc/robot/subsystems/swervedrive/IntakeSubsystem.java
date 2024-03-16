package frc.robot.subsystems.swervedrive;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {

private final CANSparkMax intake_upper = new CANSparkMax(21, MotorType.kBrushless);
private final VictorSPX intake_lower = new VictorSPX(19);
boolean intakeBool = true;
    
  /** Creates a new ExampleSubsystem. */
  public IntakeSubsystem() {}

  /**
   * Example command factory method.
   *
   * @return a command
   */
  
  public void Forward() {
          if(intakeBool)
          {
            intake_upper.set(0.15);
            intake_lower.set(VictorSPXControlMode.PercentOutput, 0.25);
          }
          else
          {
            intake_upper.set(0);
            intake_lower.set(VictorSPXControlMode.PercentOutput, 0);
          }
          intakeBool = !intakeBool;
          
  }
  
  /* 
  public void Stop() {
          intake_upper.set(0);
          intake_lower.set(VictorSPXControlMode.PercentOutput, 0);
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