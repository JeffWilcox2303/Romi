package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DrivetrainSubsystem;

public class TurnCommand extends CommandBase {
    DrivetrainSubsystem drivetrainSubsystem;
    double inches;
    public TurnCommand(RobotContainer robotContainer, double angle){
        drivetrainSubsystem = robotContainer.drivetrainSubsystem;
        addRequirements(drivetrainSubsystem);
        double percent = angle/360.0;
        double circumference = Math.PI * (Constants.DrivetrainConstants.TRACK_WIDTH_INCH / 2.0);
        inches = percent * circumference;
    }

    @Override
    public void initialize(){
        // System.out.println("Turn Command");
        drivetrainSubsystem.reset();
    }

    @Override
    public void execute(){
        // System.out.println("EXECUTING");
        drivetrainSubsystem.drive(0.5, -0.5);
        System.out.println(drivetrainSubsystem.getLeftInches());
    }

    @Override
    public void end(boolean interrupted){
        drivetrainSubsystem.stop();
        // System.out.println("ENDING");
    }

    @Override
    public boolean isFinished(){
        System.out.println(drivetrainSubsystem.getLeftInches());
        return drivetrainSubsystem.getLeftInches() >= inches;
    }
}
