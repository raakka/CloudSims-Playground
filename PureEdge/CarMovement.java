package ResearchPack;

import java.util.Random;

import com.mechalikh.pureedgesim.LocationManager.Location;
import com.mechalikh.pureedgesim.LocationManager.Mobility;
import com.mechalikh.pureedgesim.ScenarioManager.SimulationParameters;

public class CustomMobilityManager extends Mobility {

	// Int representing N,S,E,W orientation 
	private int orientationInt;

    /////////////////////////////////////////////////////////////////////////////////////////////////// 
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
		
		Random rand = new Random();
		this.orientationInt = rand.nextInt(3);
	}
	
    /////////////////////////////////////////////////////////////////////////////////////////////////// 
    /// Gets Next Location When Moving
	public Location getNextLocation() {
		// Can only move when mobile
		if (speed <= 0 || !isMobile)
			return currentLocation;
		
		// Define x & y defaults
		// Default position is half of dimension
		double y_pos = (double) SimulationParameters.AREA_LENGTH / 2;
		double x_pos = (double) SimulationParameters.AREA_WIDTH / 2;
		
		// Treated like an intersection, cars move E <=> W and N <=> S
		if (this.orientationInt == 3) {
			y_pos = 
				this.currentLocation.getYPos() - speed * SimulationParameters.UPDATE_INTERVAL;
			
			if (y_pos < 0)
				y_pos = (double) SimulationParameters.AREA_WIDTH;
						
		} else if (this.orientationInt == 2) {
			x_pos = 
				this.currentLocation.getXPos() - speed * SimulationParameters.UPDATE_INTERVAL;
			
			if (x_pos < 0)
				x_pos = (double) SimulationParameters.AREA_LENGTH;
			
		} else if (this.orientationInt == 1) {
			y_pos = 
				this.currentLocation.getYPos() + speed * SimulationParameters.UPDATE_INTERVAL;
			
			if (y_pos > SimulationParameters.AREA_WIDTH)
				y_pos = 0.0;
			
		} else if (this.orientationInt == 0) {
			x_pos = 
				this.currentLocation.getXPos() + speed * SimulationParameters.UPDATE_INTERVAL;
			
			if (x_pos > SimulationParameters.AREA_LENGTH)
				x_pos = 0.0;
		}

		// update the location 
		currentLocation = new Location(x_pos, y_pos);
		
		// return the new location
		return currentLocation;
	}
}
