package laboratorio8;

import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;

public interface RobotInterface {
    void run();
    void onScannedRobot(ScannedRobotEvent e);
    void onHitRobot(HitRobotEvent e) ;
    void onHitByBullet(HitByBulletEvent e);
    void onHitWall(HitWallEvent e);
}
