package databaseStructure;

public class DatabaseInformation {
	private String url = "jdbc:mysql://145.24.222.103:3306/";
	private String dbNameVacatures = "vacatures";
	private String dbNameUser = "users";
	private String driver = "com.mysql.jdbc.Driver";
	private String userName = "root";
	private String password = "root";
	public String getDBname(int keuze){
		String DBname;
		switch(keuze){
		case 1:DBname=getDbNameUser();return DBname;
		case 2:DBname=getDbNameVacatures();return DBname;
		}
		return null;
	}
	public String getUrl() {
		return url;
	}

	public String getDriver() {
		return driver;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	private String getDbNameVacatures() {
		return dbNameVacatures;
	}

	private String getDbNameUser() {
		return dbNameUser;
	}
}
