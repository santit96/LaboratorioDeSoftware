package santiagotettamanti;

import robocode.JuniorRobot;

public class LineStrategy extends AbstractStrategy  {

	LineStrategy(JuniorRobot robot) {
		super(robot);
	}

	@Override
	public void move() {
		robot.ahead(10);
		robot.turnGunRight(10);
	}


	@Override
	public void avoid() {
		robot.turnTo(robot.heading+180);
	}

}