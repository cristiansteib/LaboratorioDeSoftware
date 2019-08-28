package laboratorio;

public interface RobotStrategy {
    void run(LaboRobot robot);
    void onScannedRobot(LaboRobot robot);
    void onHitByBullet(LaboRobot robot);
    void fire(LaboRobot robot);
    void onHitWall(LaboRobot robot);
}
