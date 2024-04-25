package ge.tbc.tbcitacademy.POM.Data;

public class DatabaseConstants {
    public static final String
            sqlSelectStandardUser = "SELECT username, password FROM users WHERE username = 'standard_user'",
            sqlSelectLockedOutUser = "SELECT username, password FROM users WHERE username = 'locked_out_user'",
            sqlSelectProblematicUser = "SELECT username, password FROM users WHERE username = 'problem_user'",
            userNameTxt = "username", passwordTxt = "password",
            sqlCreateUsersTable = """
                    use Registration;
                    IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Users')
                        BEGIN
                            CREATE TABLE Users (
                                                   id INT IDENTITY(1001,1) PRIMARY KEY,
                                                   username VARCHAR(50),
                                                   password VARCHAR(50)
                            );
                        END
                    """;
}
