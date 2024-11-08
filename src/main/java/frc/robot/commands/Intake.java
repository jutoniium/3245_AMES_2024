package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class Intake extends Command {
    IntakeSubsystem m_intakeSubsystem;
    double m_targetSecs;
    Timer timer = new Timer();

    public Intake(IntakeSubsystem intakeSubsystem, double targetSecs) {
        m_intakeSubsystem = intakeSubsystem;
        m_targetSecs = targetSecs;
        addRequirements(m_intakeSubsystem);
    }

    @Override
    public void initialize() {
        timer.start();
        timer.reset();
    }
    
    @Override
    public void execute() {
        m_intakeSubsystem.intake();
    }

    @Override
    public void end(boolean interrupted) {
        m_intakeSubsystem.stop();
    }

    @Override
    public boolean isFinished() {
        return timer.hasElapsed(m_targetSecs);
    }
}
