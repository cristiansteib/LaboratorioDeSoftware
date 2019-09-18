package laboratorio8;

import robocode.AdvancedRobot;


public abstract class RobotStrategy implements RobotInterface{

    protected AdvancedRobot robot;

    private static RobotStrategy instance = null;

    static RobotStrategy getInstance(AdvancedRobot robot)  {
        if (instance == null) {
            Class clazz = sun.reflect.Reflection.getCallerClass(1);
            RobotStrategy instance = (RobotStrategy) clazz.newInstance();
            instance.init(robot);
            return instance;
        } else {
            return instance;
        }
    }


    void init(AdvancedRobot robot) {
        this.robot = robot;
    }
}
