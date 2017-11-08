/**
 * 
 * Code application : Composant :
 */
package fr.epita.quiz.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * <h3>Description</h3>
 * <p>
 * Cette classe permet de ...
 * </p>
 *
 * <h3>Utilisation</h3>
 * <p>
 * Elle s'utilise de la manière suivante :
 * 
 * <pre>
 * <code>${type_name} instance = new ${type_name}();</code>
 * </pre>
 * </p>
 * 
 * @since $${version}
 * @see Voir aussi $${link}
 * @author ${user}
 *
 *         ${tags}
 */
public class TestJdbc {

	/**
	 * 
	 */
	private static final String CONNECTION_STRING = "jdbc:derby:memory:testStructuration;create=true";

	@BeforeClass
	public static void globalSetup() throws SQLException, ClassNotFoundException {

		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		String jdbcConnectionString = CONNECTION_STRING;
		Connection connection = getConnection(jdbcConnectionString);
		PreparedStatement createSchemaStatement = connection.prepareStatement("create schema root");
		createSchemaStatement.execute();
		createSchemaStatement.close();
		connection.commit();
		connection.close();

		connection = DriverManager.getConnection(jdbcConnectionString, "root", "password");
		PreparedStatement prepareStatement = connection.prepareStatement("CREATE TABLE QUIZ "
				+ "	(QUIZ_ID INT NOT NULL GENERATED ALWAYS AS IDENTITY "
				+ "	CONSTRAINT QUIZ_PK PRIMARY KEY, QUIZ_NAME VARCHAR(26))");
		prepareStatement.execute();
		prepareStatement.close();
		connection.commit();
		connection.close();

	}

	/**
	 * <h3>Description</h3>
	 * <p>
	 * Cette méthode permet de ...
	 * </p>
	 *
	 * <h3>Utilisation</h3>
	 * <p>
	 * Elle s'utilise de la manière suivante :
	 * 
	 * <pre>
	 * <code> ${enclosing_type} sample;
	 *
	 * //...
	 *
	 * sample.${enclosing_method}();
	 *</code>
	 * </pre>
	 * </p>
	 * 
	 * @since $${version}
	 * @see Voir aussi $${link}
	 * @author ${user}
	 *
	 *         ${tags}
	 */
	private static Connection getConnection(String jdbcConnectionString) throws SQLException {
		Connection connection = DriverManager.getConnection(jdbcConnectionString, "root", "password");
		return connection;
	}

	@Test
	public void testJdbcInsertion() throws SQLException {

		String insertString = "INSERT INTO QUIZ (QUIZ_NAME) VALUES ('FirstQuiz')";
		String select = "SELECT * FROM QUIZ";
		Connection connection = getConnection(CONNECTION_STRING);
		PreparedStatement prepareStatement = connection.prepareStatement(insertString);
		prepareStatement.execute();
		prepareStatement.close();

		PreparedStatement selectStatement = connection.prepareStatement(select);
		ResultSet resultSet = selectStatement.executeQuery();
		int count = 0;
		while (resultSet.next()) {
			count++;
		}

		Assert.assertEquals(1, count);

		connection.close();

	}

	@Test
	public void testJdbcInsertionTooLong() throws SQLException {
		Connection connection = getConnection(CONNECTION_STRING);
		try {
			String insertString = "INSERT INTO QUIZ (QUIZ_NAME) VALUES ('FirstQuizVeryLongNameWithMoreThan26Characters')";
			PreparedStatement prepareStatement = connection.prepareStatement(insertString);
			prepareStatement.execute();
			prepareStatement.close();
			Assert.fail();
		} catch (Exception e) {
			Assert.assertTrue(e instanceof SQLException);
		} finally {
			connection.close();
		}

		connection.close();

	}

}
