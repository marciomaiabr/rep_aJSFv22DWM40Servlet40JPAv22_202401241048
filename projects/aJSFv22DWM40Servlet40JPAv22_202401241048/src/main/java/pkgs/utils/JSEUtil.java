package pkgs.utils;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;

public class JSEUtil {

	private static final String INITIAL_DML = "//sqls//initial//dml";

	public static URL getResource() {
    	ClassLoader classLoader = JSEUtil.class.getClassLoader();
    	URL resourceDirectory = classLoader.getResource("META-INF");
    	return resourceDirectory;
	}

	public static Path getInitialDmlsPath() {
		File directory = new File(getResource().getPath()+INITIAL_DML);
		Path path = directory.toPath();
		return path;
	}

	public static File[] getInitialDmlsFiles() {
		File directorys = new File(getResource().getPath()+INITIAL_DML);
		return directorys.listFiles();
	}

}
