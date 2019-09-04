package laboratorio8;

import robocode.AdvancedRobot;

public abstract class RobotStrategy implements RobotInterface{
    protected AdvancedRobot robot;
    public void init(AdvancedRobot robot) {
        this.robot = robot;
    }
}
