package laboratorio;
import robocode.*;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/JuniorRobot.html
public class ContextRobot  implements RobotInterface
{
	private RobotStrategyInterface strategy = new CrazyStrategy();

	private RobotStrategyInterface getRobotStrategy() {
		return strategy;
	}

	public void setStrategy(RobotStrategyInterface strategy) {
		this.strategy = strategy;
	}

	@Override
	public void run() {
		this.getRobotStrategy().run();
	}

	@Override
	public void onScannedRobot(ScannedRobotEvent e) {
		this.getRobotStrategy().onScannedRobot(e);
	}

	@Override
	public void onHitRobot(HitRobotEvent e) {
		this.getRobotStrategy().onHitRobot(e);
	}

	@Override
	public void onHitByBullet() {
		this.getRobotStrategy().onHitByBullet();
	}

	@Override
	public void fire() {
		this.getRobotStrategy().fire();
	}

	@Override
	public void onHitWall() {
		this.getRobotStrategy().onHitWall();
	}

}