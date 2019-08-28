package laboratorio;

class DummyStrategy implements RobotStrategy{

    public void run(LaboRobot robot){
        robot.setStrategy( new DummyStrategy());
    }

    public void onScannedRobot(LaboRobot robot){
        robot.fire(1);
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
