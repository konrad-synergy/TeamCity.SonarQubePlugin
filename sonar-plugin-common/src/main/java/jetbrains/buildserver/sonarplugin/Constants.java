package jetbrains.buildserver.sonarplugin;

/**
 * Created by linfar on 4/2/14.
 */
public final class Constants {
    public static final String RUNNER_TYPE = "sonar-plugin";
    public static final String PLUGIN_NAME = "sonar-plugin";
    public static final String SONAR_SERVER_URL_FILENAME = "sonar_server.txt";
    public static final String SONAR_HOST_URL = "sonar.host.url";
    public static final String SONAR_SERVER_JDBC_URL = "sonar.jdbc.url";
    public static final String SONAR_SERVER_JDBC_USERNAME = "sonar.jdbc.username";
    public static final String SONAR_SERVER_JDBC_PASSWORD = "sonar.jdbc.password";
    public static final String SONAR_SERVER_URL_ARTIF_LOCATION = ".teamcity/sonar/";
    public static final String SONAR_SERVER_URL_ARTIF_LOCATION_FULL = SONAR_SERVER_URL_ARTIF_LOCATION + SONAR_SERVER_URL_FILENAME;
    public static final String SONAR_PROJECT_MODULES = "sonarProjectModules";
    public static final String SONAR_PROJECT_SOURCES = "sonarProjectSources";
    public static final String SONAR_PROJECT_TESTS = "sonarProjectTests";
    public static final String SONAR_PROJECT_BINARIES = "sonarProjectBinaries";
    public static final String SONAR_PROJECT_VERSION = "sonarProjectVersion";
    public static final String SONAR_PROJECT_KEY = "sonarProjectKey";
    public static final String SONAR_PROJECT_NAME = "sonarProjectName";
    public static final String SONAR_ADDITIONAL_PARAMETERS = "additionalParameters";
    public static final String SONAR_SERVER_ID = "sonarServer";
    public static final String SQS_CHOOSER = "sqsChooser";

    private Constants() {
    }
}
