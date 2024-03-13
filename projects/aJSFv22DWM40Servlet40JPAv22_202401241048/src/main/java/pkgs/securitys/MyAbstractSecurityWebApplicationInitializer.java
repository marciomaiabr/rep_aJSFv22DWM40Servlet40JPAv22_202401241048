package pkgs.securitys;

import java.io.Serializable;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class MyAbstractSecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer implements Serializable {

	private static final long serialVersionUID = 20240310070601L;

	public MyAbstractSecurityWebApplicationInitializer() {
		super(MyWebSecurityConfigurerAdapter.class);
	}

}
