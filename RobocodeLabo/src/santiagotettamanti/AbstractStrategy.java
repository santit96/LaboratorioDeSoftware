package santiagotettamanti;

import robocode.JuniorRobot;

 abstract class AbstractStrategy implements RobotStrategy  {
	JuniorRobot robot;
	
	AbstractStrategy(JuniorRobot robot){
		this.robot=robot;
	}
	
	@Override
	public abstract void move();

	@Override
	public void attack() {
		robot.turnGunTo(robot.scannedAngle);
		if (robot.energy>25) {
			robot.fire(3);
		}
		else
			robot.fire (1);
		robot.ahead(10);
	}

	@Override
	public void defend() {
		robot.ahead(10);
	}
	
	@Override
	public void avoid() {
		robot.turnRight(10);
		robot.ahead(10);
	}
}