package laboratorio8;
import robocode.*;

import java.awt.*;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/JuniorRobot.html
public class LaboRobot8 extends AdvancedRobot implements RobotInterface
{
	private Estratega estratega = new Estratega();

	private  class Estratega {

		private RobotStrategy strategy;

		private void update() {
			if (getEnergy() < 80) {
				//this.setStrategy(new ircleStrategy());
				this.setStrategy(CircleStrategy.getInstance());
			}else {
				//this.setStrategy(new FailedStrategy());
				this.setStrategy(FailedStrategy.getInstance());
			}
		}

		private void setStrategy(RobotStrategy strategy) {
			this.strategy = strategy;
			this.strategy.init(LaboRobot8.this);
		}

		RobotStrategy getStrategy() {
			update();
			return this.strategy;
		}
	}

	private RobotStrategy getRobotStrategy() {
		return this.estratega.getStrategy();
	}

	@Override
	public void run() {
		this.setBodyColor(new Color(200, 197, 0));
		this.setGunColor(new Color(150, 0, 1));
		this.setRadarColor(new Color(0, 24, 100));
		this.setBulletColor(new Color(255, 251, 249));
		this.setScanColor(new Color(27, 255, 8));
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
