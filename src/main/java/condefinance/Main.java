package condefinance;

import condefinance.config.DatabaseConnection;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection connection = DatabaseConnection.getInstance().getConnection();
    }
}