// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;

public class DrivetrainSubsystem extends SubsystemBase {
  Spark leftMotor, rightMotor;
  Encoder leftEncoder, rightEncoder;
  /** Creates a new DrivetrainSubsystem. */
  public DrivetrainSubsystem() {
    leftMotor = new Spark(Constants.DrivetrainConstants.LEFT_MOTOR_PORT);
    rightMotor = new Spark(Constants.DrivetrainConstants.RIGHT_MOTOR_PORT);
    rightMotor.setInverted(true);
    leftEncoder = new Encoder(Constants.DrivetrainConstants.LEFT_ENCODER_A, Constants.DrivetrainConstants.LEFT_ENCODER_B);
    rightEncoder = new Encoder(Constants.DrivetrainConstants.RIGHT_ENCODER_A, Constants.DrivetrainConstants.RIGHT_ENCODER_B);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void reset(){
    leftEncoder.reset();
    rightEncoder.reset();
  }

  public void drive(double leftValue, double rightValue){
    leftMotor.set(leftValue);
    rightMotor.set(rightValue);
  }

  public void stop(){
    leftMotor.set(0);
    rightMotor.set(0);
  }

  public double getLeftInches(){
    return leftEncoder.getDistance();
  }

  public double getRightInches(){
    return rightEncoder.getDistance();
  }
}
