package com.example.sailerapplication;

import java.sql.*;
import java.util.ArrayList;




/**
 * THIS CLASS CONTAINS ALL CRUD OPERATION (CREATE , READ , UPDATE , DELETE) FOR DATA IN THE DATABASE 'sailclub_db'
 * @author Montasser Ben Rejeb
 *
 */

public class Database_CRUD_Operations {
    public Connection databaseLink;


    public Connection getConnection() {
        String databaseName = "sailclub_db";
        String databaseUser = "root";
        String databasePassword = "";
        String url = "jdbc:mysql://localhost/" + databaseName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return databaseLink;

    }

    /**
     * METHOD FOR CREATING THE TABLES IN THE DATABASE IF THEY DONT ALREADY EXISTS
     */

    public void createTables(){
        try {
            Connection con = getConnection();
            PreparedStatement create_table_admin = con.prepareStatement("CREATE TABLE IF NOT EXISTS admin(id int(11) NOT NULL AUTO_INCREMENT, username varchar(32) , password varchar(32) , PRIMARY KEY(id))");
            PreparedStatement create_table_user = con.prepareStatement("CREATE TABLE IF NOT EXISTS user(id int(11) NOT NULL AUTO_INCREMENT,name char(32) , surname char(32) , username varchar(32) , password varchar(32) , address varchar(32) , fiscal_code varchar(32) , PRIMARY KEY(id))");
            PreparedStatement create_table_challenges = con.prepareStatement("CREATE TABLE IF NOT EXISTS challenges(cname varchar(32) NOT NULL , prize int(11) , PRIMARY KEY(cname))");
            PreparedStatement create_table_boat = con.prepareStatement("CREATE TABLE IF NOT EXISTS boat(id int(10) NOT NULL AUTO_INCREMENT, bname varchar(32), PRIMARY KEY(id))");
            create_table_admin.executeUpdate();
            create_table_user.executeUpdate();
            create_table_challenges.executeUpdate();
            create_table_boat.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Create tables method executed successfully\nAll tables have been created if they don't already exists\n");
        }
    }

    /**
     * METHOD FOR POPULATING THE TABLES IN THE DATABASE IF THEY ARENT ALREADY POPULATED
     */

    public void post(){


        /**
         * INSERT admin DATA TABLE IF NOT EXISTS ALREADY
         */

        try {

            Connection con = getConnection();
            PreparedStatement posted_admin1 = con.prepareStatement("INSERT INTO admin (id , username , password ) VALUES ('1','root', 'root')");
            posted_admin1.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        /**
         * INSERT USER DATA TABLE IF NOT EXISTS ALREADY
         */
        try {
            Connection con = getConnection();

            PreparedStatement posted_user1 = con.prepareStatement("INSERT INTO user (id , name, surname , username , password , address , fiscal_code) VALUES ('1','montasser', 'ben rejeb', 'devops', 'opsdev', 'parma', 'pchtaahched9784')");
            PreparedStatement posted_user2 = con.prepareStatement("INSERT INTO user (id , name, surname , username , password , address , fiscal_code) VALUES ('2','Mohamed', 'Touati', 'Mohamed93', 'Jamaica1993$', 'Via pazzini 15', 'MMT93DH02J06Z352')");
            PreparedStatement posted_user3 = con.prepareStatement("INSERT INTO user (id , name, surname , username , password , address , fiscal_code) VALUES ('3','Mohammed', 'Achref Touil', 'Mohamed93', 'Achref-1234', 'Via Mazzini,Parigi,Francia', 'TLMO99ZS07HL29')");
            posted_user1.executeUpdate();
            posted_user2.executeUpdate();
            posted_user3.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



        /**
         * INSERT challenges DATA TABLE IF NOT EXISTS ALREADY
         */
        try {
            Connection con = getConnection();
            PreparedStatement posted_challenge1 = con.prepareStatement("INSERT INTO challenges (cname , prize) VALUES ('RORCCaribbean','10000')");
            PreparedStatement posted_challenge2 = con.prepareStatement("INSERT INTO challenges (cname , prize) VALUES ('Shell Cup 2022','2222')");
            posted_challenge1.executeUpdate();
            posted_challenge2.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        /**
         * INSERT boat DATA TABLE IF NOT EXISTS ALREADY
         */
        try {
            Connection con = getConnection();
            PreparedStatement posted_boat1 = con.prepareStatement("INSERT INTO boat (id , bname) VALUES ('1','TANIT')");
            PreparedStatement posted_boat2 = con.prepareStatement("INSERT INTO boat (id , bname) VALUES ('2','CARTHAGE')");
            posted_boat1.executeUpdate();
            posted_boat2.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        finally {
            System.out.println("TABLES 'admin' , 'user' , 'challenges' , 'boat' have been successfully populated\nif they aren't already!");
        }

    }

    /**
     * METHOD FOR SELECTING DATA FROM TABLES IN THE DATABASE
     */

    public ArrayList<String> get() {
        try{
            Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement("SELECT * FROM user");

            ResultSet result = statement.executeQuery();

            ArrayList<String> array = new ArrayList<String>();
            while(result.next()){
                System.out.println(result.getString("id"));
                System.out.println(result.getString("name"));
                System.out.println(result.getString("surname"));
                System.out.println(result.getString("username"));
                System.out.println(result.getString("password"));

                array.add(result.getString("name"));
            }
            System.out.println("The requested records have been selected");
            return array;
        } catch(Exception e){
            System.out.println(e);
            return null;
        }
    }











}




