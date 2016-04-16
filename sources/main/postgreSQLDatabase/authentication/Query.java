/**
 * 
 */
package postgreSQLDatabase.authentication;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import postgreSQLDatabase.attendance.Allocation;

/**
 * @author Joey
 *
 */
public class Query {
	public static JSONArray getAutoSuggest(String input) {
		System.out.println(input);
		JSONArray jArray = null;
		try {
			PreparedStatement proc = settings.database.PostgreSQLConnection.getConnection().prepareStatement("SELECT public.\"getUserAutoSuggest\"(?);");
			proc.setString(1, input);
			ResultSet rs = proc.executeQuery();
			rs.next();
			jArray = new JSONArray(rs.getString(1));
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jArray;

	}
}
