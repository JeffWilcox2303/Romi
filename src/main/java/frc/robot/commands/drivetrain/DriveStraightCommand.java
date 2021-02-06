package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DrivetrainSubsystem;

public class DriveStraightCommand extends CommandBase {
    DrivetrainSubsystem drivetrainSubsystem;
    double inches;
    public DriveStraightCommand (RobotContainer robotContainer, double angle){
        drivetrainSubsystem = robotContainer.drivetrainSubsystem;
        addRequirements(drivetrainSubsystem);
        double percent = angle/360.0;
        double circumference = Math.PI * (Constants.DrivetrainConstants.TRACK_WIDTH_INCH / 2.0);
        inches = percent * circumference;
    }

    @Override
    public void initialize(){
        drivetrainSubsystem.reset();
    }

    @Override
    public void execute(){
        drivetrainSubsystem.drive(.5, .5);
        System.out.println(drivetrainSubsystem.getLeftInches());
    }

    @Override
    public void end(boolean interrupted){
        drivetrainSubsystem.stop();
    }

    @Override
    public boolean isFinished(){
        return drivetrainSubsystem.getLeftInches() >= inches;
    }

}
