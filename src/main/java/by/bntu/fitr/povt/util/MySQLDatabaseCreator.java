package by.bntu.fitr.povt.util;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.BeanInitializationException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Умеет создавать базу данных, если ее нет
 */
@Setter
@Getter
@Log4j2
public class MySQLDatabaseCreator {

    /**
     * Url для подключения к базе (должно содержать имя базы)
     */
    private String url;

    /**
     * Юзер для подключения
     */
    private String user;

    /**
     * Пароль от юзера
     */
    private String pass;

    /**
     * Драйвер sql
     */
    private String driver;

    /**
     * collate создаваемой базы (способ сравнения слов), по умолчанию {@code utf8mb4_general_ci}
     */
    private String collate = "utf8mb4_general_ci";

    /**
     * character создаваемой базы (кодировка), по умолчанию {@code utf8mb4}
     */
    private String character = "utf8mb4";

    private static Pattern dataBaseInUrl = Pattern.compile("/((?!/).)+$");

    /**
     * Создать базу данных, если еще нет
     */
    public void createDatabaseIfNotExists() throws SQLException {
        Objects.requireNonNull(url, "url");
        Objects.requireNonNull(user, "user");
        Objects.requireNonNull(pass, "pass");
        if (driver != null) {
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ignored) {
            }
        }

        Matcher matcher = dataBaseInUrl.matcher(url);
        if (!matcher.find()) {
            throw new BeanInitializationException("в url " + url + " не найдено имя базы данных");
        }
        String group = matcher.group();
        group = StringUtils.removeStart(group, "/");
        String databaseName = StringUtils.substringBefore(group, "?");

        log.info("Создаем базу " + databaseName + ", если ее нет.");

        String urlWithoutDatabaseName = StringUtils.replaceOnce(url, databaseName, "");

        try (Connection connection = DriverManager.getConnection(urlWithoutDatabaseName, user, pass);
             Statement statement = connection.createStatement()) {
            String sql = "CREATE DATABASE IF NOT EXISTS `" + databaseName + "` character set " + character + " collate " + collate;
            statement.executeUpdate(sql);
        }
    }
}