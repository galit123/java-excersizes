package fieldglass.atm;

import java.sql.*;

public enum DBAdapter {
	instance;
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/database";

	// Database credentials
	static final String USER = "user";
	static final String PASS = "password";

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		// STEP 2: Register JDBC driver
		Class.forName(JDBC_DRIVER);

		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		return conn;
	}

	int insert(Connection conn, Money m, int amount) throws SQLException, ClassNotFoundException {
		String sql = "insert into ATM_MONEY values('" + m.getCurrency().name() + "'," + "'" + m.getType().getName()
				+ "'," + m.getValueInCents() + "," + amount + ")";
		Statement stmt = conn.createStatement();
		return stmt.executeUpdate(sql);
	}

	public int update(Connection conn, Money m, Integer amount) throws SQLException, ClassNotFoundException {
		String sql = "update ATM_MONEY SET AMOUNT=" + amount + " where CURRENCY='" + m.getCurrency().name()
				+ "' and CURRENCY_TYPE='" + m.getType().getName() + "' and CURRENCY_VALUE = " + m.getValueInCents();
		Statement stmt = conn.createStatement();
		return stmt.executeUpdate(sql);
	}

	public boolean isExists(Connection conn, Money m) throws SQLException, ClassNotFoundException {
		String sql = "SELECT CURRENCY, CURRENCY_TYPE, CURRENCY_VALUE, AMOUNT FROM ATM_MONEY" + " where CURRENCY='"
				+ m.getCurrency().name() + "' and CURRENCY_TYPE='" + m.getType().getName() + "' and CURRENCY_VALUE = "
				+ m.getValueInCents();
		Statement stmt = conn.createStatement();
		ResultSet res = stmt.executeQuery(sql);
		return res.next();
	}

	public int upsert(Connection conn, Money m, Integer amount) throws SQLException, ClassNotFoundException {
		if (isExists(conn, m)) {
			return update(conn, m, amount);
		} else {
			return insert(conn, m, amount);
		}
	}

}
