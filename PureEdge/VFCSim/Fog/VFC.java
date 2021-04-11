import com.mechalikh.pureedgesim.MainApplication;

public class VFC extends MainApplication {

	private static String settingsPath = "CloudSims-Playground/PureEdge/VFCSim/Fog/Settings";

	private static String outputPath = "CloudSims-Playground/PureEdge/VFCSim/Fog/Output";

	private static String simConfigfile = settingsPath + "simulation_parameters.properties";
	private static String applicationsFile = settingsPath + "applications.xml";
	private static String edgeDataCentersFile = settingsPath + "edge_datacenters.xml";
	private static String edgeDevicesFile = settingsPath + "edge_devices.xml";
	private static String cloudFile = settingsPath + "cloud.xml";

	public VFC(int fromIteration, int step_) {
		super(fromIteration, step_);
	}

	public static void main(String[] args) {

		setCustomOutputFolder(outputPath);
		setCustomSettingsFolder(settingsPath);

		setCustomFilePath(simConfigfile, Files.SIMULATION_PARAMETERS);
		setCustomFilePath(applicationsFile, Files.APPLICATIONS_FILE);
		setCustomFilePath(edgeDataCentersFile, Files.EDGE_DATACENTERS_FILE);
		setCustomFilePath(edgeDevicesFile, Files.EDGE_DEVICES_FILE);
		setCustomFilePath(cloudFile, Files.CLOUD_FILE);

		launchSimulation();
	}
}