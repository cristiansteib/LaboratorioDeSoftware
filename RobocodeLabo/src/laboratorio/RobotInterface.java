package laboratorio;

import robocode.HitRobotEvent;
import robocode.ScannedRobotEvent;

public interface RobotInterface {
    void run();

    void onScannedRobot(ScannedRobotEvent e);
    void onHitRobot(HitRobotEvent e) ;
    void onHitByBullet();

    void fire();
    void onHitWall();
}
