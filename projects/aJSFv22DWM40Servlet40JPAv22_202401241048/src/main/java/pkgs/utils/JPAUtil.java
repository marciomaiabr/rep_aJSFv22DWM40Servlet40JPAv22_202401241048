package pkgs.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class JPAUtil {

	private static String url;
	private static String username;
	private static String password;

	static {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			String fileName = "D:\\marciomaia\\java\\eclipse\\202312190443_202401160403_202401230343\\eclipse-workspace\\Servers\\Tomcat v9.0 Server at localhost-config\\context.xml";
			File file = new File(fileName);
			Document doc = db.parse(file);

			NodeList list = doc.getElementsByTagName("Resource");
			Element element = (Element) list.item(0);

			url = element.getAttribute("url");
			username = element.getAttribute("username");
			password = element.getAttribute("password");

			System.out.println("[url="+url+"][username="+username+"][password.hashCode()="+password.hashCode()+"]");
		} catch (Exception e) {
			System.err.println("Falha ao abrir arquivos de configuração [e.getMessage()="+e.getMessage()+"] ...");
		}
	}

	public static EntityManagerFactory criaEntityManagerFactoryWithCreateAuto() {
		EntityManagerFactory emf = null;

		if(url != null && username != null && password != null) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
			map.put("javax.persistence.jdbc.url", url);
			map.put("javax.persistence.jdbc.user", username);
			map.put("javax.persistence.jdbc.password", password);
			map.put("javax.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver");
			map.put("hibernate.show_sql", "true");
			map.put("hibernate.format_sql", "true");
			map.put("use_sql_comments", "true");
			map.put("hibernate.hbm2ddl.auto", "create");
			//chama o "sql-load-script-source" somente quando "hibernate.hbm2ddl.auto" é "create"
			//quando especificado vários arquivos o jpa executa somente o último, creio eu q ele sobrepõe o par chave/valor do HashMap,
			//checar se qdo uma PU estática o mesmo ocorre
			//map.put("javax.persistence.sql-load-script-source", "META-INF/sqls/InsertUsuario.sql");
			//map.put("javax.persistence.sql-load-script-source", "META-INF/sqls/InsertGrupoUsuario.sql");
			map.put("hibernate.archive.autodetection", "class");
			emf = Persistence.createEntityManagerFactory("myPU", map);
		}

		return emf;
	}

	public static EntityManagerFactory criaEntityManagerFactoryWithCreateNone() {
		EntityManagerFactory emf = null;

		if(url != null && username != null && password != null) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
			map.put("javax.persistence.jdbc.url", url);
			map.put("javax.persistence.jdbc.user", username);
			map.put("javax.persistence.jdbc.password", password);
			map.put("javax.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver");
			map.put("hibernate.show_sql", "true");
			map.put("hibernate.format_sql", "true");
			map.put("use_sql_comments", "true");
			map.put("hibernate.hbm2ddl.auto", "none");
			map.put("hibernate.archive.autodetection", "class");
			emf = Persistence.createEntityManagerFactory("myPU", map);
		}

		return emf;
	}

}
