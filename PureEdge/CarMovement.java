
package examples;

import java.util.Random;

import com.mechalikh.pureedgesim.LocationManager.Location;
import com.mechalikh.pureedgesim.LocationManager.Mobility;
import com.mechalikh.pureedgesim.ScenarioManager.SimulationParameters;

public class CustomMobilityManager extends Mobility {

	// Int representing N,S,E,W orientation 
	private int orientationInt;
	
	// Bools for NSEW traffic lights
	static boolean stoppedNS;
	static boolean stoppedEW;
	
	////////////////////////////////////////////////////////////////////////////////////
	/// Default Constructor
	public CustomMobilityManager(
		Location currentLocation,
		boolean mobile,
		double speed,
		double minPauseDuration,
		double maxPauseDuration,
		double minMobilityDuration,
		double maxMobilityDuration
	) {
		super(
				currentLocation,
				mobile,
				speed,
				minPauseDuration,
				maxPauseDuration,
				minMobilityDuration,
				maxMobilityDuration
				);
		// Set orientation on object creation
		Random rand = new Random();
		this.orientationInt = rand.nextInt(3);
	}
	
	////////////////////////////////////////////////////////////////////////////////////
	/// Location update loop
	public Location getNextLocation() {
		
		if(speed <= 0 || !isMobile){
			return currentLocation;
		} 
		
		if (stoppedNS && (this.orientationInt == 0 || this.orientationInt == 3 )) {
			
		}
		
		if (stoppedEW && (this.orientationInt == 1 || this.orientationInt == 2 )) {
			
		}
		
		currentLocation = movingLocationMotion();
				
		// return the new location
		return currentLocation;
	}
	
	////////////////////////////////////////////////////////////////////////////////////
	/// Location updater (when going)
	private Location movingLocationMotion() {
		Random rand = new Random();
		
		// Define x & y defaults
		// Default position is half of dimension
		double y_pos = 
				(double) (SimulationParameters.AREA_LENGTH - rand.nextInt(10) - 5) / 2;
		
		double x_pos = 
				(double) (SimulationParameters.AREA_WIDTH - rand.nextInt(10) - 5) / 2;
		
		// Treated like an intersection, cars move E <=> W and N <=> S
		if (this.orientationInt == 1) {
			// Movement N
			y_pos = 
				this.currentLocation.getYPos() + speed * SimulationParameters.UPDATE_INTERVAL;
				
			if (y_pos > SimulationParameters.AREA_WIDTH)
				y_pos = 0.0;
				
		} else if (this.orientationInt == 3) {
			// Movement S
			y_pos = 
				this.currentLocation.getYPos() - speed * SimulationParameters.UPDATE_INTERVAL;
			
			if (y_pos < 0)
				y_pos = (double) SimulationParameters.AREA_WIDTH;
						
		}else if (this.orientationInt == 0) {
			// Movement E
			x_pos = 
				this.currentLocation.getXPos() + speed * SimulationParameters.UPDATE_INTERVAL;
			
			if (x_pos > SimulationParameters.AREA_LENGTH)
				x_pos = 0.0;
			
		} else if (this.orientationInt == 2) {
			// Movement W
			x_pos = 
				this.currentLocation.getXPos() - speed * SimulationParameters.UPDATE_INTERVAL;
			
			if (x_pos < 0)
				x_pos = (double) SimulationParameters.AREA_LENGTH;
			
		}

		// Return the new location 
		return new Location(x_pos, y_pos);
	}
	
	////////////////////////////////////////////////////////////////////////////////////
	/// Called to stop vehicle motion
	public void stopMotion(String direction) {
		if (this.currentLocation.getXPos() > 10 && this.currentLocation.getXPos() < 10) {
			
		}
	}
	
	////////////////////////////////////////////////////////////////////////////////////
	/// Called to resume vehicle motion
	public void resumeMotion(String direction) {
		
	}
}
