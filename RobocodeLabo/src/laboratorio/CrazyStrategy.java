package laboratorio;

import robocode.*;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

import static robocode.util.Utils.normalRelativeAngleDegrees;

public class CrazyStrategy extends AdvancedRobot implements RobotStrategyInterface {
    boolean movingForward;
    private int dist = 50; // distance to move when we're hit

    public void run() {
        // Set colors
        setBodyColor(new Color(200, 197, 0));
        setGunColor(new Color(150, 0, 1));
        setRadarColor(new Color(0, 24, 100));
        setBulletColor(new Color(255, 251, 249));
        setScanColor(new Color(27, 255, 8));

        // Loop forever
        while (true) {
            // Tell the game we will want to move ahead 40000 -- some large number
            setAhead(40000);
            movingForward = true;
            // Tell the game we will want to turn right 90
            setTurnRight(90);
            // At this point, we have indicated to the game that *when we do something*,
            // we will want to move ahead and turn right.  That's what "set" means.
            // It is important to realize we have not done anything yet!
            // In order to actually move, we'll want to call a method that
            // takes real time, such as waitFor.
            // waitFor actually starts the action -- we start moving and turning.
            // It will not return until we have finished turning.
            int randomNum = ThreadLocalRandom.current().nextInt(20, 180);

            waitFor(new TurnCompleteCondition(this));
            // Note:  We are still moving ahead now, but the turn is complete.
            // Now we'll turn the other way...
            setTurnLeft(randomNum);
            // ... and wait for the turn to finish ...
            waitFor(new TurnCompleteCondition(this));
            // ... then the other way ...
            setTurnRight(randomNum);
            // .. and wait for that turn to finish.
            waitFor(new TurnCompleteCondition(this));
            // then back to the top to do it all again
        }
    }


    /**
     * reverseDirection:  Switch from ahead to back & vice versa
     */
    private void reverseDirection() {
        int randomNum = ThreadLocalRandom.current().nextInt(2000, 10000 + 1);

        if (movingForward) {
            setBack(randomNum);
            movingForward = false;
        } else {
            setAhead(randomNum);
            movingForward = true;
        }
    }

    /**
     * onScannedRobot:  Fire!
     */
    public void onScannedRobot(ScannedRobotEvent e) {
        // If the other robot is close by, and we have plenty of life,
        // fire hard!
        if (e.getDistance() < 35 && getEnergy() > 55) {
            fire(3);
        } // otherwise, fire 1.
        else if (e.getDistance() < 50 && getEnergy() > 80){
            fire(1);
        } else if (e.getDistance() < 15 && getEnergy() < 20){
            fire(3);
        } else {
            fire(1);
        }


        // Call scan again, before we turn the gun
        scan();
    }

    /**
     * onHitByBullet:  Turn perpendicular to the bullet, and move a bit.
     */
    @Override
    public void onHitByBullet(HitByBulletEvent e) {
        turnRight(normalRelativeAngleDegrees(90 - (getHeading() - e.getHeading())));

        ahead(dist);
        dist *= -1;
        scan();
    }


    @Override
    public void onHitWall(HitWallEvent e) {
        // Move away from the wall
        reverseDirection();
    }

    /**
     * onHitRobot:  Back up!
     */
    public void onHitRobot(HitRobotEvent e) {
        double turnGunAmt = normalRelativeAngleDegrees(e.getBearing() + getHeading() - getGunHeading());

        turnGunRight(turnGunAmt);
        fire(3);
    }

}