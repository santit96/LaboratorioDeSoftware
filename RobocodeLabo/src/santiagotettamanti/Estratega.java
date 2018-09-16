package santiagotettamanti;

import robocode.JuniorRobot;

public class Estratega {
	
	public static StrategySelector estratega1= new Estratega1();
	public static StrategySelector estratega2= new Estratega2();
	
	private static class Estratega1 implements StrategySelector{
		
		@Override
		public RobotStrategy getStrategy(JuniorRobot robot) {
			if (robot.energy < 30 || robot.others>5){
				return new CircleStrategy(robot);
			}
			else { return new LineStrategy(robot);
			}
		}
		
	}
	
	private static class Estratega2 implements StrategySelector{

		@Override
		public RobotStrategy getStrategy(JuniorRobot robot) {
			if (robot.others > 2 && robot.energy > 15) {
				return new CircleStrategy(robot);
			}
			else {
				return new LineStrategy(robot);
			}
		}
		
	}
}
