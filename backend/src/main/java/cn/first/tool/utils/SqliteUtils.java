package cn.first.tool.utils;
import cn.first.tool.controllers.request.User;

import java.sql.*;

/**
 * @author xiong
 * @Description
 * @date 2023-04-07 1:03 下午
 */
public class SqliteUtils {

    public static int insert(User user, String path) throws SQLException {
        String sql = "INSERT INTO users(username, password,apikey) VALUES(?,?,?)";
        try {
            String url = "jdbc:sqlite:" + path;
            Connection conn = DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getPassWord());
            pstmt.setString(3, user.getApiKey());
            int i = pstmt.executeUpdate();
            conn.close();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static  User login(User user, String path) throws SQLException {
        String sql = "SELECT password,apikey FROM users where username=?";
        try {
            String url = "jdbc:sqlite:" + path;
            Connection conn = DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUserName());
            ResultSet rs = pstmt.executeQuery();
            String password = rs.getString("password");
            String apikey = rs.getString("apikey");
            conn.close();
            if(user.getPassWord().equals(password)) {
                user.setApiKey(apikey);
                return user;
            }else {
                return null;
            }
        } catch (SQLException e) {
            throw e;
        }
    }


    public static  User update(User user, String path) throws SQLException {
        String sql = "update users set password=?,apikey=? where username=?";
        try {
            String url = "jdbc:sqlite:" + path;
            Connection conn = DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getPassWord());
            pstmt.setString(2, user.getApiKey());
            pstmt.setString(3, user.getUserName());
            int i = pstmt.executeUpdate();
            conn.close();
            return user;
        } catch (SQLException e) {
            throw e;
        }
    }

//    public static void main(String[] args) throws SQLException {
//        User user = new User();
//        user.setUserName("1");
//        user.setPassWord("2");
//        user.setApiKey("2");
//        User login = login(user, "/Users/xiong/soft/sqlite-tools-osx-x86-3410200/chatgpt.db");
//        System.out.println(login);
//    }


}

