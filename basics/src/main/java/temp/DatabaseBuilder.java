package temp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseBuilder {

    public static final String JDBC_CONN_STRING = "jdbc:sqlite:tusca.db";

    public static void main(String[] args) {
        DatabaseBuilder builder = new DatabaseBuilder();
        builder.createProductTable();
    }

    public void createProductTable(){
        String sql = """
                CREATE TABLE `products` (
                    `code`   TEXT NOT NULL,
                    `name`   TEXT,
                    `price`  REAL,
                    `quantity`   INTEGER,
                    PRIMARY KEY(`code`)
                );
                """;
        try (var connection = DriverManager.getConnection(JDBC_CONN_STRING);
             var statement = connection.createStatement()) {
            statement.execute(sql);
            System.out.println("Created table products\n"+ sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

