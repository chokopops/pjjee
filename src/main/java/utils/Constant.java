package utils;

import java.sql.Connection;

public class Constant {
    public static final String JDBC_DRIVER = "org.h2.Driver";
    public static final String DB_URL = "jdbc:h2:~/ST2EEDB2";
    public static final String DB_USER = "adm";
    public static final String DB_PWD = "adm";
    public static Connection conn = null;

    public static String registerSuccess = "You are now register";
    public static String registerFail = "Fail to register";
    public static String registerFailEmail = "Email already use";
    public static String loginSuccess = "You are now login";
    public static String loginFail = "Fail to login";

}
