package laboratorio8;
import robocode.*;

import java.awt.*;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/JuniorRobot.html
public class LaboRobot8 extends AdvancedRobot implements RobotInterface
{
	private Estratega estratega = new Estratega();

	private  class Estratega {

		private RobotStrategy strategy;

		void update() {
			if (getEnergy() < 80) {
				//this.setStrategy(new CircleStrategy());
				this.setStrategy(CircleStrategy.getInstance(LaboRobot8.this));
			}else {
				//this.setStrategy(new FailedStrategy());
				this.setStrategy(FailedStrategy.getInstance(LaboRobot8.this));
			}
		}

		void setStrategy(RobotStrategy strategy) {
			this.strategy = strategy;
			this.strategy.init(LaboRobot8.this);
		}

		RobotStrategy getStrategy() {
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
		this.estratega.update();
		this.getRobotStrategy().run();
	}

	@Override
	public void onScannedRobot(ScannedRobotEvent e) {
		this.estratega.update();

		this.getRobotStrategy().onScannedRobot(e);
	}

	@Override
	public void onHitRobot(HitRobotEvent e) {
		this.estratega.update();

		this.getRobotStrategy().onHitRobot(e);
	}

	@Override
	public void onHitByBullet(HitByBulletEvent e) {
		this.estratega.update();
		this.getRobotStrategy().onHitByBullet(e);
	}

	@Override
	public void onHitWall(HitWallEvent e) {
		this.estratega.update();
		this.getRobotStrategy().onHitWall(e);
	}
}
