package com.example.sailerapplication;

import java.sql.*;
import java.util.ArrayList;




/**
 * THIS CLASS CONTAINS ALL CRUD OPERATION (CREATE , READ , UPDATE , DELETE) FOR DATA IN THE DATABASE 'sailclub_db'
 * @author Montasser Ben Rejeb
 * @author Wajdi Lajdal
 *
 */

public class Database_CRUD_Operations {
    public Connection databaseLink;


    public Connection getConnection() {
        String databaseName = "sailclub_db";
        String databaseUser = "root";
        String databasePassword = "";
        String url = "jdbc:mysql://localhost:3306/" + databaseName;

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

            String drop_admin = "drop table if exists admin";
            String drop_user = "drop table if exists user";
            String drop_boat = "drop table if exists boat";
            String drop_challenges = "drop table if exists challenges";
            String drop_payment = "drop table if exists payment";


            Statement stmt = con.createStatement();

            stmt.executeUpdate(drop_admin);
            stmt.executeUpdate(drop_user);
            stmt.executeUpdate(drop_boat);
            stmt.executeUpdate(drop_challenges);
            stmt.executeUpdate(drop_payment);


            PreparedStatement create_table_admin = con.prepareStatement("CREATE TABLE IF NOT EXISTS admin(id int(11) NOT NULL AUTO_INCREMENT" +
                    ", username varchar(32) NOT NULL" +
                    ", password varchar(32) NOT NULL" +
                    ", PRIMARY KEY(id))");

            PreparedStatement create_table_user = con.prepareStatement("CREATE TABLE IF NOT EXISTS user(name char(32) NOT NULL" +
                    ", surname char(32) NOT NULL" +
                    ", username varchar(32) NOT NULL" +
                    ", password varchar(32) NOT NULL" +
                    ", address varchar(80) NOT NULL" +
                    ", fiscal_code varchar(32) NOT NULL" +
                    ", CCBalance double NOT NULL" +
                    ", membership_status char(32)" +
                    ", PRIMARY KEY(name))");

            PreparedStatement create_table_challenges = con.prepareStatement("CREATE TABLE IF NOT EXISTS challenges(name varchar(32) NOT NULL " +
                    ", prize int(11) not null" +
                    ", participants varchar(100) " +
                    ", PRIMARY KEY(name))");

            PreparedStatement create_table_boat = con.prepareStatement("CREATE TABLE IF NOT EXISTS boat(id int(10) NOT NULL AUTO_INCREMENT" +
                    ", name varchar(32) NOT NULL" +
                    ", Status char(20) NOT NULL" +
                    ", owner varchar(80) " +
                    ", length int(11) " +
                    ", PRIMARY KEY(id))");

            PreparedStatement create_table_payment = con.prepareStatement("CREATE TABLE IF NOT EXISTS payment(title varchar(100)" +
                    ", date int(100) " +
                    ", payer varchar(100) " +
                    ", PRIMARY KEY(title))");


            create_table_admin.executeUpdate();
            create_table_user.executeUpdate();
            create_table_challenges.executeUpdate();
            create_table_boat.executeUpdate();
            create_table_payment.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Create tables method executed successfully\nAll tables have been created if they don't already exists\n");
        }
    }

    /**
     * METHOD FOR POPULATING THE TABLES IN THE DATABASE IF THEY ARENT ALREADY POPULATED
     */

    public void POST(){


        /**
         * INSERT admin DATA TABLE IF NOT EXISTS ALREADY
         */

        try {
            Connection con = getConnection();
            PreparedStatement posted_admin1 = con.prepareStatement("INSERT INTO admin (username , password ) VALUES ('admin', 'admin')");
            posted_admin1.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        /**
         * INSERT USER DATA TABLE IF NOT EXISTS ALREADY
         */
        try {
            Connection con = getConnection();

            PreparedStatement posted_user1 = con.prepareStatement("INSERT INTO user (name, surname , username , password , address , fiscal_code , CCBalance , membership_status)" +
                                                                                " VALUES ('Montasser', 'Ben rejeb', 'test', 'test', 'montassar.benrejeb@studenti.unipr.it', 'BNRMTS98','5000','inactive')");

            PreparedStatement posted_user2 = con.prepareStatement("INSERT INTO user (name, surname , username , password , address , fiscal_code, CCBalance, membership_status) " +
                                                                                " VALUES ('Mario', 'Rossi', 'user', 'user', 'mario.rossi@studenti.unipr.it', 'MAROSSI95','5000','inactive')");

            PreparedStatement posted_user3 = con.prepareStatement("INSERT INTO user (name, surname , username , password , address , fiscal_code, CCBalance , membership_status)" +
                                                                                " VALUES ('Wajdi', 'Lajdal', 'wes', 'Wajdi1234', 'wajdi.lajdal@studenti.unipr.it', 'WALJD97','5000','active')");
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
            PreparedStatement posted_Challenge1 = con.prepareStatement("INSERT INTO challenges (name , prize, participants) VALUES ('RORCCaribbean','10000','0')");
            PreparedStatement posted_Challenge2 = con.prepareStatement("INSERT INTO challenges (name , prize, participants) VALUES ('Shell Cup 2022','20000','0')");
            PreparedStatement posted_Challenge3 = con.prepareStatement("INSERT INTO challenges (name , prize, participants) VALUES ('GrandPrize ','100000','0')");
            posted_Challenge1.executeUpdate();
            posted_Challenge2.executeUpdate();
            posted_Challenge3.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        /**
         * INSERT boat DATA TABLE IF NOT EXISTS ALREADY
         */
        try {
            Connection con = getConnection();
            PreparedStatement posted_Boat1 = con.prepareStatement("INSERT INTO boat (id, name, Status, owner, length) VALUES ('1','Tanit','AVAILABLE','BNRMTS98',7)");
            PreparedStatement posted_Boat2 = con.prepareStatement("INSERT INTO boat (id, name, Status, owner, length) VALUES ('2','Cartago','AVAILABLE','MAROSSI95',12)");
            PreparedStatement posted_Boat3 = con.prepareStatement("INSERT INTO boat (id, name, Status, owner, length) VALUES ('3','Yacht','AVAILABLE','WALJD97',18)");
            posted_Boat1.executeUpdate();
            posted_Boat2.executeUpdate();
            posted_Boat3.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        finally {
            System.out.println("TABLES 'admin' , 'user' , 'challenges' , 'boat', 'payment' have been successfully populated!\n");
        }

    }

    /**
     * METHOD FOR SELECTING DATA FROM TABLES IN THE DATABASE
     */

    public ArrayList<String> GET() {
        try{
            Connection con = getConnection();
            PreparedStatement strSelect = con.prepareStatement("SELECT name, surname, username ,  address, fiscal_code , CCBalance FROM user");
            System.out.println("The SQL statement is: " + strSelect + "\n");
            ResultSet rset = strSelect.executeQuery();

            ArrayList<String> array = new ArrayList<>();
            int rowCount = 0;
            while(rset.next()){
                String name     = rset.getString("name");
                String surname  = rset.getString("surname");
                String username = rset.getString("username");
                String address  = rset.getString("address");
                String fiscal_code = rset.getString("fiscal_code");
                String CCBalance = rset.getString("CCBalance");


                rowCount++;
                String displayMessage = name + ", " + surname + ", " + username + ", " + address + ", " + fiscal_code + ", " + CCBalance;
                System.out.println(displayMessage);
                array.add(displayMessage);
            }
            System.out.println("Total numbers of selected records =" + rowCount);
            return array;
        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }











}




