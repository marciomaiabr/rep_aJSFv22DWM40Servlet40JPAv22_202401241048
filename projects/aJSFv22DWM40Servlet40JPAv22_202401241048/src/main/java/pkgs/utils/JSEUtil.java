package pkgs.utils;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;

public class JSEUtil {

	public static URL getResource() {
    	ClassLoader classLoader = JSEUtil.class.getClassLoader();
    	URL resourceDirectory = classLoader.getResource("META-INF");
    	return resourceDirectory;
	}

	public static Path getInitialDmlsPath() {
		File directory = new File(getResource().getPath()+"//sqls//initial//dml");
		Path path = directory.toPath();
		return path;
	}

	public static File[] getInitialDmlsFiles() {
		File directorys = new File(getResource().getPath()+"//sqls//initial//dml");
		return directorys.listFiles();
	}

}
