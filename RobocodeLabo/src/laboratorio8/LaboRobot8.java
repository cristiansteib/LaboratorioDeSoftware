package laboratorio8;
import robocode.*;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/JuniorRobot.html
public class LaboRobot8 extends AdvancedRobot implements RobotInterface
{
	private RobotStrategy strategy;

	public LaboRobot8(){
		this.setStrategy(new FailedStrategy());
	}

	private RobotStrategy getRobotStrategy() {
		return strategy;
	}

	public void setStrategy(RobotStrategy strategy) {
		this.strategy = strategy;
		this.strategy.init(this);
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
	public void onHitByBullet(HitByBulletEvent e) {
		this.getRobotStrategy().onHitByBullet(e);
	}

	@Override
	public void onHitWall(HitWallEvent e) {
		this.getRobotStrategy().onHitWall(e);
	}

}