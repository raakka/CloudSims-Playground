package examples;

import com.mechalikh.pureedgesim.MainApplication;

public class Playground1 extends MainApplication {

	private static String settingsPath = "PureEdgeSim/examples/Playground1_settings/";

	// The custom output folder is
	private static String outputPath = "PureEdgeSim/examples/Playground1_output/";

	// If we want only to use files one by one
	private static String simConfigfile = settingsPath + "simulation_parameters.properties";
	private static String applicationsFile = settingsPath + "applications.xml";
	private static String edgeDataCentersFile = settingsPath + "edge_datacenters.xml";
	private static String edgeDevicesFile = settingsPath + "edge_devices.xml";
	private static String cloudFile = settingsPath + "cloud.xml";

	public Playground1(int fromIteration, int step_) {
		super(fromIteration, step_);
	}

	public static void main(String[] args) {

		// changing the default output folder
		setCustomOutputFolder(outputPath);

		/** if we want to change the path of all configuration files at once : */

		// changing the simulation settings folder
		setCustomSettingsFolder(settingsPath);

		/**
		 * if we want to change the path of only one file, while keeping the default one
		 * for the others :
		 */

		// To change the simulation_parameters.properties path only
		setCustomFilePath(simConfigfile, Files.SIMULATION_PARAMETERS);
		// To change the applications.xml path only
		setCustomFilePath(applicationsFile, Files.APPLICATIONS_FILE);
		// To change the edge_datacenters.xml path only
		setCustomFilePath(edgeDataCentersFile, Files.EDGE_DATACENTERS_FILE);
		// To change the edge_devices.xml path only
		setCustomFilePath(edgeDevicesFile, Files.EDGE_DEVICES_FILE);
		// To change the cloud.xml path only
		setCustomFilePath(cloudFile, Files.CLOUD_FILE);

		// Start the simulation
		launchSimulation();
	}
}
