package laboratorio;

import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.ScannedRobotEvent;

public interface RobotInterface {
    void run();

    void onScannedRobot(ScannedRobotEvent e);
    void onHitRobot(HitRobotEvent e) ;
    void onHitByBullet(HitByBulletEvent e);
    void fire();
    void onHitWall();
}
