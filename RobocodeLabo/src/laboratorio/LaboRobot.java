package laboratorio;
import robocode.*;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/JuniorRobot.html


public class LaboRobot extends JuniorRobot
{
	private RobotStrategy laboRobotStrategyImpl = null;

	private RobotStrategy getRobotStrategy() {
		return laboRobotStrategyImpl;
	}

	public void setStrategy(RobotStrategy strategy) {
		this.laboRobotStrategyImpl = strategy;
	}

	@Override	
	public void run() {
		this.getRobotStrategy().run(this);
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	@Override
	public void onScannedRobot() {
		this.getRobotStrategy().fire(this);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	@Override
	public void onHitByBullet() {
		this.getRobotStrategy().onHitByBullet(this);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	@Override
	public void onHitWall() {
		this.getRobotStrategy().onHitWall(this);
	}
}