package utils;

import java.sql.Connection;

public class Constant {
    public static final String JDBC_DRIVER = "org.h2.Driver";
    public static final String DB_URL = "jdbc:h2:~/ST2EEDB";
    public static final String DB_USER = "adm";
    public static final String DB_PWD = "adm";
    public static Connection conn = null;

    public static String LOGINSUCCESS = "You are now login";
    public static String LOGINFAIL = "Fail to login";
}
