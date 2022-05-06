
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;


import static java.lang.System.*;

import android.icu.util.Output;

import com.example.smart_fridge.Prod_Activity;

class conn extends Prod_Activity {

     public static Connection conn_1;

     public static Statement stant;

     public static ResultSet resSet;

     public static ResultSet rs;

     public static void Connection() throws ClassNotFoundException, SQLException {
         conn_1 = null;
         Class.forName("org.sqlite.JDBC");
         conn_1 = DriverManager.getConnection("jdbc:sqlite:pill.s3db");
         out.println("база подключена!");
     }

     public static void CreateTable() throws  ClassNotFoundException, SQLException {

         stant = conn_1.createStatement();
         stant.execute("CREATE TABLE if not exists 'product' ( id INTEGER, name TEXT, description TEXT,PRIMARY KEY('id' AUTOINCREMENT))");
         out.println(" Таблица создана или уже сеществует!...");

     }

     public static void InputDB(String nameProd3, String descriptionProd3) throws  ClassNotFoundException, SQLException{

         String nameProd_w = nameProd3;
         String descriptionProd_w = descriptionProd3;


         stant.execute("INSERT INTO 'product' (id, name, description) VALUES (NULL, '"+ nameProd_w + "','"+ descriptionProd_w +"')");


     }

     public static void OutputDB() throws  ClassNotFoundException, SQLException{

            String name_o = resSet.getString("name");
            String description_o = resSet.getString("description");



     }



}
