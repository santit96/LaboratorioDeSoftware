package santiagotettamanti;

import robocode.JuniorRobot;

interface StrategySelector {
	 RobotStrategy getStrategy(JuniorRobot robot);
}
