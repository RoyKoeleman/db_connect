package databaseStructure;

import java.sql.*;

public class DatabaseHandling {
	private Connection connection;
	private int vacatureID,id,userNumber;
	// Maakt de database verbinding
	private void connectDatabase(String url, String dbName, String userName,
			String password, String driver) {
		try {
			// Register de MySql driver zodat de JDBC hem kan gebruiken
			Class.forName("com.mysql.jdbc.Driver");
			// Maak verbinding met de MySql Database
			connection = DriverManager.getConnection(url + dbName, userName,
					password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Deze methode zorgt ervoor dat je makkelijk een connectie kunt maken
	// zonder parameters mee te geven.
	public void connectToDB(int keuze) {
		DatabaseInformation data = new DatabaseInformation();
		connectDatabase(data.getUrl(), data.getDBname(keuze), data.getUserName(),
				data.getPassword(), data.getDriver());
		data = null;
	}

	// Dissconect van de database
	public void disconnectDB() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void writeVacatureDB(int vacaturenID, int urenperweek, String title,
			String opleidingniveau, String text, String vakgebied,
			String soortbaan, String samenvatting, String link,String date) {
		try {
			Statement s = connection.createStatement();
			String query="INSERT INTO vacatures VALUES("
					+ vacaturenID + "," + urenperweek + ",'" + title + "','"
					+ opleidingniveau + "','" + text + "','" + vakgebied + "','"
					+ soortbaan + "','" + samenvatting + "','"+ link +"','" + date + "')";
			s.executeUpdate(query);
			s.close();
		} catch (SQLException e) {
			
		}

	}
	
	public void writeUserToDB(String first_name,String last_name,String email,String password) {
		writeUserDB(readUserID(),first_name, last_name, email, password);
	}
	private void writeUserDB(int uid,String first_name,String last_name,String email,String password){
		try {
			Statement s = connection.createStatement();
			String query="INSERT INTO members VALUES("
					+ uid + ",'" + first_name + "','" + last_name + "','"
					+ email + "','" + password +"')";
			s.executeUpdate(query);
			s.close();
		} catch (SQLException e) {
			
		}
	}
	public void writeVacatureToDB(int urenperweek, String title,
			String opleidingsniveau, String text, String vakgebied,
			String soortbaan, String samenvatting, String link,String date) {
		// Schrijf de vacature weg in de database.Tevens haalt hij de vacatureID
		// op.
		writeVacatureDB(readVacatureID(), urenperweek, title, opleidingsniveau, text,
				vakgebied, soortbaan, samenvatting,link,date);
	}

	// Deze methode haalt de vacatureID op. Indien er geen vacatures zijn geeft
	// hij 0 terug.
	private int readVacatureID() {
		try {
			Statement s = connection.createStatement();
			s.execute("select max(vacature_ID) from vacatures");
			ResultSet rs = s.getResultSet();
			while (rs.next()) {
				vacatureID = rs.getInt("max(vacature_ID)");
			}
			// Sluit de statement en de resultset
			rs.close();
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vacatureID+1;
	}
	private int readUserID(){
		try {
			Statement s = connection.createStatement();
			s.execute("select max(id) from members");
			ResultSet rs = s.getResultSet();
			while (rs.next()) {
				id = rs.getInt("max(id)");
			}
			// Sluit de statement en de resultset
			rs.close();
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id+1;
	}
	public Vacatures readVacatures(Vacatures vacatures) {
		String query = "select * from vacatures limit 0,9999";

		try {
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery(query);
			while (rs.next()) {
				try {
					vacatures.addItems(rs.getInt("vacature_ID"),
							rs.getInt("urenperweek"), rs.getString("title"),
							rs.getString("opleidingniveau"),
							rs.getString("text"), rs.getString("vakgebied"),
							rs.getString("soortbaan"),
							rs.getString("samenvatting"), rs.getString("link"),
							rs.getString("date"));
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}
			rs.close();
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vacatures;
	}
	public Boolean checkUser(String email,String pass){
		String query = "select * from members where email="+"'"+email+"'"+" and password="+"'"+pass+"'";
		
		try {
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery(query);
			while (rs.next()) {
				try {
					userNumber++;
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}
			rs.close();
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		boolean allowed;
		switch(userNumber){
		case 1:allowed= true;
		default:allowed= false;
		userNumber=0;
		return allowed;
		}
		
	}
	
	public void setUserDetails(String email, String password, User user) {
		String query = "select * from members where email="+"'"+email+"'"+" and password="+"'"+password+"'";
		
		try {
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery(query);
			while (rs.next()) {
				user.setUser_id(rs.getInt("id"));
				user.setFirst_name(rs.getString("first_name"));
				user.setLast_name(rs.getString("last_name"));
				user.setEmail(email);
			}
			rs.close();
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public User getUser(String email,String password,User user){
		String query = "select * from members where email="+"'"+email+"'"+" and password="+"'"+password+"'";
		try {
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery(query);
			while (rs.next()) {
				user.additems(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"));
			}
			rs.close();
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	public Connection getConnection() {
		return connection;
	}
}
