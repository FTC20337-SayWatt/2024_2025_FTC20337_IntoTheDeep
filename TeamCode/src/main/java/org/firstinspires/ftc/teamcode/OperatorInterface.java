package org.firstinspires.ftc.teamcode;

import com.technototes.library.command.CommandScheduler;
import com.technototes.library.command.ConditionalCommand;
import com.technototes.library.control.gamepad.CommandAxis;
import com.technototes.library.control.gamepad.CommandButton;
import com.technototes.library.control.gamepad.CommandGamepad;

import org.firstinspires.ftc.teamcode.commands.drivebase.DriveCommand;
import org.firstinspires.ftc.teamcode.commands.index.ArmExtendCommand;
import org.firstinspires.ftc.teamcode.commands.index.ArmRetractCommand;
import org.firstinspires.ftc.teamcode.commands.index.IndexPivotDownCommand;
import org.firstinspires.ftc.teamcode.commands.index.IndexPivotUpCommand;
import org.firstinspires.ftc.teamcode.commands.index.SendRingToShooterCommand;
import org.firstinspires.ftc.teamcode.commands.intake.IntakeInCommand;
import org.firstinspires.ftc.teamcode.commands.intake.IntakeOutCommand;
import org.firstinspires.ftc.teamcode.commands.intake.IntakeStopCommand;
import org.firstinspires.ftc.teamcode.commands.shooter.ShooterSetSpeedCommand;
import org.firstinspires.ftc.teamcode.subsystems.IndexSubsystem;

/** Class for driver controls
 *
 */
public class OperatorInterface {
    /** The robot
     *
     */
    public Robot robot;

    /** Gamepads
     *
     */
    public CommandGamepad driverGamepad, codriverGamepad;

    /** Buttons for intake
     * mainbutton toggles between intaking in and off, and spit just extakes
     */
    public CommandButton intakeMainButton, intakeSpitButton;

    public CommandButton wobbleClawButton, wobbleArmButton;

    public CommandButton indexFeedButton;

    public OperatorInterface(CommandGamepad driver, CommandGamepad codriver, Robot r){

        //instantiate objects
        driverGamepad = driver;
        codriverGamepad = codriver;
        robot = r;

        //set buttons
        intakeMainButton = driverGamepad.a;
        intakeSpitButton = driverGamepad.x;

        //indexFeedButton = codriverGamepad.a;

        //indexFeedButton.whenPressed(new SendRingToShooterCommand(robot.indexSubsystem));

        //intake commands
        //TODO command.asConditional(BooleanSupplier condition)
        intakeMainButton.whenToggled(new ConditionalCommand(robot.indexSubsystem::isFull, new IntakeInCommand(robot.intakeSubsystem)))
                .whenInverseToggled(new IntakeStopCommand(robot.intakeSubsystem));
        intakeSpitButton.whenPressed(new IntakeOutCommand(robot.intakeSubsystem));

        //drive command
        CommandScheduler.getInstance().scheduleJoystick(new DriveCommand(robot.drivebaseSubsystem, driverGamepad.leftStick, driverGamepad.rightStick), ()->true);


        driverGamepad.dpad.up.whenPressed(new IndexPivotUpCommand(robot.indexSubsystem));
        driverGamepad.dpad.down.whenPressed(new IndexPivotDownCommand(robot.indexSubsystem));
        driverGamepad.dpad.left.whenPressed(new ArmExtendCommand(robot.indexSubsystem));
        driverGamepad.dpad.right.whenPressed(new ArmRetractCommand(robot.indexSubsystem));
        //TODO fix trigger threshold
        CommandScheduler.getInstance().scheduleJoystick(new ShooterSetSpeedCommand(robot.shooterSubsystem, driverGamepad.leftTrigger), ()->true);

    }
}
