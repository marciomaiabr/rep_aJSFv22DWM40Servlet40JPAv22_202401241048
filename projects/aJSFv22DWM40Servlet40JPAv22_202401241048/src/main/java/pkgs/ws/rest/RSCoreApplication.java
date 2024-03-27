package pkgs.ws.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class RSCoreApplication extends Application {

	public RSCoreApplication() {
		System.out.println("RSCoreApplication.RSCoreApplication()");
	}

}
