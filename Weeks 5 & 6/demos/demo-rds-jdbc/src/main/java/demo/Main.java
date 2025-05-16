package demo;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Properties props = new Properties();
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties");
        try {
            props.load(inputStream);

            DriverManager.getConnection(
                    props.getProperty("DATABASE_URL"),
                    props.getProperty("DATABASE_USERNAME"),
                    props.getProperty("DATABASE_PASSWORD"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
