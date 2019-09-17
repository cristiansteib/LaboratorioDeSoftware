package laboratorio8;
import robocode.*;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/JuniorRobot.html
public class LaboRobot8 extends AdvancedRobot implements RobotInterface
{
	private Estratega estratega = new Estratega();

	private  class Estratega {
		private RobotStrategy strategy;

		void update() {
			this.setStrategy(new FailedStrategy());
		}

		void setStrategy(RobotStrategy strategy) {
			this.strategy = strategy;
			this.strategy.init(LaboRobot8.this);
		}

		RobotStrategy getStrategy() {
			return this.strategy;
		}
	}

	public LaboRobot8() {

	}

	private RobotStrategy getRobotStrategy() {
		return this.estratega.getStrategy();
	}

	@Override
	public void run() {
		this.estratega.update();
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
