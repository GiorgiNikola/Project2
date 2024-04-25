package ge.tbc.tbcitacademy.POM.Steps.DatabaseSteps;

import ge.tbc.tbcitacademy.POM.DBConnection.MSSQLConnection;
import ge.tbc.tbcitacademy.POM.Data.DatabaseConstants;
import io.qameta.allure.Step;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class DatabaseSteps {
    @Step("Return standard user credentials")
    public Map<String, String> returnStandardUserCredentials(){
        try (Connection connection = MSSQLConnection.connect()) {
            String SQL = DatabaseConstants.sqlSelectStandardUser;
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            return getDataFromResultSet(connection, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Step("Return banned user credentials")
    public Map<String, String> returnBannedUserCredentials(){
        try (Connection connection = MSSQLConnection.connect()) {
            String SQL = DatabaseConstants.sqlSelectLockedOutUser;
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            return getDataFromResultSet(connection, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Step("Return problematic user credentials")
    public Map<String, String> returnProblematicUserCredentials(){
        try (Connection connection = MSSQLConnection.connect()) {
            String SQL = DatabaseConstants.sqlSelectProblematicUser;
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            return getDataFromResultSet(connection, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Step("Process result set and put data into map")
    public Map<String, String> getDataFromResultSet(Connection connection, ResultSet rs){
        Map<String, String> userCredentials = new HashMap<>();
        try (connection){
            if (rs.next()) {
                userCredentials.put(DatabaseConstants.userNameTxt, rs.getString(DatabaseConstants.userNameTxt));
                userCredentials.put(DatabaseConstants.passwordTxt, rs.getString(DatabaseConstants.passwordTxt));
            }
            return userCredentials;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
