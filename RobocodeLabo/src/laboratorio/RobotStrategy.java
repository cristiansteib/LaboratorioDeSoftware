package laboratorio;

public interface RobotStrategy {
    abstract void run(LaboRobot robot);

    abstract void onScannedRobot(LaboRobot robot);

    abstract void onHitByBullet(LaboRobot robot);

    abstract void fire(LaboRobot robot);

    abstract void onHitWall(LaboRobot robot);
}
