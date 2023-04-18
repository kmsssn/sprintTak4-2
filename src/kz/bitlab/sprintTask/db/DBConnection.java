package kz.bitlab.sprintTask.db;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;

public class DBConnection {
    private static Connection connection;
    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sprinttask4-2",
                    "root",
                    "root");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static ArrayList<Items> getItems(){
        ArrayList<Items> items=new ArrayList<>();
        try{
            PreparedStatement statement=connection.prepareStatement(
                    "SELECT *  FROM items");
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                Items i=new Items();
                i.setId(resultSet.getLong("id"));
                i.setName(resultSet.getString("name"));
                i.setDescription(resultSet.getString("description"));
                i.setPrice(resultSet.getDouble("price"));
                items.add(i);
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return items;
    }
    public static boolean checkLogin(String email, String password){
        boolean result=false;
        try{
            PreparedStatement statement=connection.prepareStatement(
                    "SELECT * FROM users WHERE email=? AND password=?"
            );
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet=statement.executeQuery();
            if(resultSet.next()){
                result=true;
            }
            resultSet.close();
            statement.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    public static Users getUser(Long id){
        Users user=null;
        try{
            PreparedStatement statement=connection.prepareStatement("SELECT * FROM users WHERE id=? LIMIT 1");
            statement.setLong(1, id);
            ResultSet resultSet=statement.executeQuery();
            if(resultSet.next()){
                user=new Users();
                user.setId(resultSet.getLong("id"));
                user.setEmail(resultSet.getString("email"));
                user.setFullName(resultSet.getString("full_name"));
            }
            statement.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }
}
