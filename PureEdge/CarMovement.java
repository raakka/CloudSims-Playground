import com.mechalikh.pureedgesim.LocationManager.Location;

public class CarMovement extends Mobility {

    ///////////////////////////////////////////// 
    // Constructor for movement class ///////////
    public CarMovement(
        Location currentlocation,
        boolean mobile,
        double speed,
        double minPauseDuration,
        double maxPauseDuration,
        double minMobilityDuration,
        double maxMobilityDuration
    ) {
        super(
            currentlocation,
            mobile,
            speed,
            minPauseDuration,
            maxPauseDuration,
            minMobilityDuration,
            maxMobilityDuration
            );
    } 

    ///////////////////////////////////////////// 
    // Method that updates movement /////////////
    public Location getNextLocation() {
        updatedLocation = new Location(1, 1);

        return updatedLocation;
    }
 
}