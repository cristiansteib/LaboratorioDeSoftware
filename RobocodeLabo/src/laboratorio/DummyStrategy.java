package laboratorio;

class DummyStrategy implements RobotStrategy{

    public void run(LaboRobot robot){
        robot.setStrategy( new DummyStrategy());
    }

    public void onScannedRobot(LaboRobot robot){
        robot.turnGunTo(robot.scannedAngle);
        robot.fire ((robot.scannedDistance < 50 && robot.energy > 50) ? 3 : 1 );
        robot.back(10);
    }

    private void moveWithoutCrash(LaboRobot robot){

    }

    public void onHitByBullet(LaboRobot robot){
        robot.back(10);
    }

    public void fire(LaboRobot robot) {
        robot.back(10);
    }

    public void onHitWall(LaboRobot robot) {
        robot.back(20);
    }
}
