package santiagotettamanti;

import robocode.JuniorRobot;

public class CircleStrategy extends AbstractStrategy  {

	CircleStrategy(JuniorRobot robot) {
		super(robot);
	}

	@Override
	public void move() {
		robot.ahead(600);
		robot.bearGunTo(90);
	}


	@Override
	public void avoid() {
		robot.turnRight(10);
		robot.ahead(10);
	}

}
