package santiagotettamanti;
import robocode.*;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/JuniorRobot.html


public class SantiagoTettamanti extends JuniorRobot
{
	public StrategySelector estratega= Estratega.estratega1;
	
	@Override	
	public void run() {

		setColors(orange, blue, white, yellow, black);


		while(true) {
		
			estratega.getStrategy(this).move();
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	@Override
	public void onScannedRobot() {
		estratega.getStrategy(this).attack();
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	@Override
	public void onHitByBullet() {
		estratega.getStrategy(this).defend();
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	@Override
	public void onHitWall() {
		estratega.getStrategy(this).avoid();
	}
	

	
}