package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IndexerSubsystem;
import frc.robot.subsystems.ShooterSubsystem;


public class IndexIntoShoot extends Command{
    IndexerSubsystem m_indexerSubsystem;
    ShooterSubsystem m_shooterSubsystem;
    double m_targetSecs;
    Timer timer = new Timer();

    public IndexIntoShoot(IndexerSubsystem indexerSubsystem, ShooterSubsystem shooterSubsystem, double targetSecs) {
        m_indexerSubsystem = indexerSubsystem;
        m_shooterSubsystem = shooterSubsystem;
        m_targetSecs = targetSecs;

        addRequirements(m_indexerSubsystem);
        addRequirements(m_shooterSubsystem);
    }

    @Override
    public void initialize() {
        timer.start();
        timer.reset();
    }

    @Override
    public void execute() {
        m_indexerSubsystem.index();
        m_shooterSubsystem.shoot();
    }

    @Override
    public void end(boolean interrupted) {
        m_indexerSubsystem.stop();
        m_shooterSubsystem.stop();
    }

    @Override
    public boolean isFinished() {
        return timer.hasElapsed(m_targetSecs);
    }
}
