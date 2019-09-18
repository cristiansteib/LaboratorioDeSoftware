package laboratorio8;

import robocode.AdvancedRobot;


public abstract class RobotStrategy implements RobotInterface{

    protected AdvancedRobot robot;
/*
    private static RobotStrategy instance = null;

    protected static RobotStrategy getInstance() {
        if (instance == null) {
            Class clazz = sun.reflect.Reflection.getCallerClass(1);
            return clazz.newInstance();
        } else {
            return instance;
        }
    }
    */

    public void init(AdvancedRobot robot) {
        this.robot = robot;
    }
}
