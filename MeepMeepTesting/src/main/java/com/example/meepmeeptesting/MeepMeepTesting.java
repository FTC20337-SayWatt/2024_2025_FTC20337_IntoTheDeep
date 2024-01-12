package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    private static final double TILE = 24.0;
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        /*
        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep) // path for red side middle pixel
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 14)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(TILE/2, -2.5*TILE, Math.toRadians(90)))
                                .lineToConstantHeading(new Vector2d(TILE/2, -1.5*TILE))
                                //.lineToConstantHeading(new Vector2d(TILE/2, -1.5*TILE))
                                .addTemporalMarker(1, () -> {

                                })
                                .turn(Math.toRadians(90))
                                .lineToConstantHeading(new Vector2d(-2*TILE, -1.5*TILE))
                                .addTemporalMarker(1, () -> {

                                })
                                //.lineToLinearHeading(new Vector2d(-2*TILE, -1.5*TILE))
                                .turn(Math.toRadians(90))
                                .forward(TILE)
                                .turn(Math.toRadians(90))
                                .lineToConstantHeading(new Vector2d(TILE*2, -2.5*TILE))
                                .lineToConstantHeading(new Vector2d(TILE*2, -1.5*TILE))
                                .addTemporalMarker(1, () -> {

                                })
                                .build()
                );*/

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep) // path for red side right pixel
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 14)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(TILE/2, -2.5*TILE, Math.toRadians(90)))
                                .lineToConstantHeading(new Vector2d(TILE/2, -1.8*TILE))
                                .turn(Math.toRadians(-45))
                                .lineToLinearHeading(new Pose2d(TILE/2, -1.5*TILE, Math.toRadians(90)))
                                .addTemporalMarker(1, () -> {

                                })
                                .turn(Math.toRadians(90))
                                .lineToConstantHeading(new Vector2d(-2*TILE, -1.5*TILE))
                                .addTemporalMarker(1, () -> {

                                })
                                //.lineToLinearHeading(new Vector2d(-2*TILE, -1.5*TILE))
                                .turn(Math.toRadians(90))
                                .forward(TILE)
                                .turn(Math.toRadians(90))
                                .lineToConstantHeading(new Vector2d(TILE*2, -2.5*TILE))
                                .lineToConstantHeading(new Vector2d(TILE*2, -1.2*TILE))
                                .addTemporalMarker(1, () -> {

                                })
                                .build()
                );

        /*RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep) // path for red side left pixel
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 14)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(TILE/2, -2.5*TILE, Math.toRadians(90)))
                                .lineToConstantHeading(new Vector2d(TILE/2, -1.8*TILE))
                                .turn(Math.toRadians(45))
                                .lineToLinearHeading(new Pose2d(TILE/2, -1.5*TILE, Math.toRadians(90)))
                                .addTemporalMarker(1, () -> {

                                })
                                .lineToConstantHeading(new Vector2d(TILE*2, -2.5*TILE))
                                .build()
                );*/

        meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_OFFICIAL)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}