package laboratorio8;

import robocode.*;

import java.awt.*;

import static robocode.util.Utils.normalRelativeAngleDegrees;


public class CircleStrategy extends RobotStrategy {
    private int dist = 50; // distance to move when we're hit

    private static CircleStrategy instance = new CircleStrategy();

    private CircleStrategy () {
    }

    static CircleStrategy getInstance() {
      return instance;
    }

    public void run() {

        this.robot.setTurnRight(100);
        this.robot.setMaxVelocity(5);
        this.robot.ahead(100);
    }

    @Override
    public void onScannedRobot(ScannedRobotEvent e) {
        this.robot.fire(1);
        this.robot.scan();
    }

    @Override
    public void onHitByBullet(HitByBulletEvent e) {
        this.robot.turnLeft(90);

    }

    @Override
    public void onHitWall(HitWallEvent e) {
    }

    @Override
    public void onHitRobot(HitRobotEvent e) {

    }

}
