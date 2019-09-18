package laboratorio8;

import robocode.*;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

import static robocode.util.Utils.normalRelativeAngleDegrees;

public class FailedStrategy extends RobotStrategy {


    private static FailedStrategy instance = null;

    private FailedStrategy (){
        instance = new FailedStrategy();
    }

    public static FailedStrategy getInstance() {
        if (instance == null) {
            return new FailedStrategy();
        }
        else {
            return instance;
        }
    }

    boolean movingForward;
    private int dist = 50; // distance to move when we're hit

    public void run() {

        double height = this.robot.getBattleFieldHeight();
        double width = this.robot.getBattleFieldWidth();

        // Loop forever

        // Tell the game we will want to move ahead 40000 -- some large number
        this.robot.setAhead(40000);
        movingForward = true;
        // Tell the game we will want to turn right 90
        this.robot.setTurnRight(90);
        // At this point, we have indicated to the game that *when we do something*,
        // we will want to move ahead and turn right.  That's what "set" means.
        // It is important to realize we have not done anything yet!
        // In order to actually move, we'll want to call a method that
        // takes real time, such as waitFor.
        // waitFor actually starts the action -- we start moving and turning.
        // It will not return until we have finished turning.
        int randomNum = ThreadLocalRandom.current().nextInt(20, 180);

        this.robot.waitFor(new TurnCompleteCondition(this.robot));
        // Note:  We are still moving ahead now, but the turn is complete.
        // Now we'll turn the other way...
        this.robot.setTurnLeft(randomNum);
        // ... and wait for the turn to finish ...
        this.robot.waitFor(new TurnCompleteCondition(this.robot));
        // ... then the other way ...
        this.robot.setTurnRight(randomNum);
        // .. and wait for that turn to finish.
        this.robot.waitFor(new TurnCompleteCondition(this.robot));
        // then back to the top to do it all again

    }


    /**
     * reverseDirection:  Switch from ahead to back & vice versa
     */
    private void reverseDirection() {
        int randomNum = ThreadLocalRandom.current().nextInt(2000, 10000 + 1);

        if (movingForward) {
            this.robot.setBack(randomNum);
            movingForward = false;
        } else {
            this.robot.setAhead(randomNum);
            movingForward = true;
        }
    }

    /**
     * onScannedRobot:  Fire!
     */
    public void onScannedRobot(ScannedRobotEvent e) {
        // If the other robot is close by, and we have plenty of life,
        // fire hard!
        if (e.getDistance() < 35 && this.robot.getEnergy() > 55) {
            this.robot.fire(3);
        } // otherwise, fire 1.
        else if (e.getDistance() < 50 && this.robot.getEnergy() > 80) {
            this.robot.fire(1);
        } else if (e.getDistance() < 15 && this.robot.getEnergy() < 20) {
            this.robot.fire(3);
        } else {
            this.robot.fire(1);
        }


        // Call scan again, before we turn the gun
        this.robot.scan();
    }

    /**
     * onHitByBullet:  Turn perpendicular to the bullet, and move a bit.
     */
    @Override
    public void onHitByBullet(HitByBulletEvent e) {
        this.robot.turnRight(normalRelativeAngleDegrees(90 - (this.robot.getHeading() - e.getHeading())));

        this.robot.ahead(dist);
        dist *= -1;
        this.robot.scan();
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
        double turnGunAmt = normalRelativeAngleDegrees(e.getBearing() + this.robot.getHeading() - this.robot.getGunHeading());

        this.robot.turnGunRight(turnGunAmt);
        this.robot.fire(3);
    }

}