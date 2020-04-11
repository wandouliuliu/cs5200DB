package com.example.cs5200sp20liuserverjava.daos;
import com.example.cs5200sp20liuserverjava.models.Developer;
import com.example.cs5200sp20liuserverjava.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class DeveloperDao implements DeveloperImpl {
        Statement statement = null;
        ResultSet results = null;
        private static DeveloperDao instance = null;
        private DeveloperDao() {
        }
        public static DeveloperDao getInstance() {
            if (instance == null) {
                instance = new DeveloperDao();
            }
            return instance;
        }

    @Override
    public void createDeveloper(Developer developer) {
        Connection connection = null;
        try {
            connection = DBConnection.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int id = developer.getpId();
        String firstname = developer.getFirstName();
        String lastname = developer.getLastName();
        String username = developer.getUserName();
        String email = developer.getEmail();
        String password = developer.getPassword();
        String developerKey = developer.getDeveloperKey();
        String phone = developer.getPhone();
        try {
            Statement s1 = connection.createStatement();
            Statement s2 = connection.createStatement();
            String sql1 = "Insert into person VALUES" +
                    "("+id+"," + "\""+username+"\"," + "\""+password+"\"," +
                    "\""+firstname +"\"," + "\""+lastname+"\"," +
                    "\""+email+"\"," + "\""+phone+"\");" ;
            System.out.println(sql1);
            String sql2 = "Insert into developer values (\"" + id +
                    "\",\"" + developerKey + "\");";
            System.out.println(sql2);
            s1.executeUpdate(sql1);
            s2.executeUpdate(sql2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        @Override
        public Collection<Developer> findAllDevelopers() {
            Collection<Developer> developers= new ArrayList<Developer>();
            try {
                Connection connection =DBConnection.getConnection();
                String findAllDevelopers="select * from person,developer where person.id = developer.id; ";

                Statement s1 = connection.createStatement();
                results = s1.executeQuery(findAllDevelopers);

                while(results.next()) {
                    int id= results.getInt("id");
                    String firstname = results.getString("firstname");
                    String lastname = results.getString("lastname");
                    String username = results.getString("username");
                    String password = results.getString("password");
                    String email = results.getString("email");
                    String developerKey = results.getString("developer_key");
                    Developer dev=new Developer(id,  firstname,  lastname,  username,  password,  email, developerKey);
                    developers.add(dev);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return developers;
        }

        @Override
        public Developer findDeveloperById(int developerId) {
            Developer developer=null;
            try {
                Connection connection = null;
                try {
                    connection = DBConnection.getConnection();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                String findDeveloperById="select * from person,developer" + "where person.id=developer.id and person.id=?;";
                PreparedStatement pStatement = connection.prepareStatement(findDeveloperById);
                pStatement.setInt(1,developerId);
                results = pStatement.executeQuery();

                if(results.next()) {

                    String firstName = results.getString("firstname");
                    String lastName = results.getString("firstname");
                    String userName = results.getString("username");
                    String password = results.getString("password");
                    String email = results.getString("email");
                    int pId= results.getInt("id");
                    String developerKey = results.getString("developer_key");
                    developer=new Developer( pId ,userName,  password, firstName,  lastName,  email, developerKey);

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return developer;
        }

        @Override
        public Developer findDeveloperByUsername(String username) {
            Developer developer=null;
            try {
                Connection connection = DBConnection.getConnection();

                String findDeveloperByUsername="select * from person,developer" +
                        "where person.id=developer.id and person.user_name=?;";
                PreparedStatement pStatement = connection.prepareStatement(findDeveloperByUsername);
                pStatement.setString(1,username);
                results = pStatement.executeQuery();
                if(results.next()) {
                    String firstName = results.getString("firstname");
                    String lastName = results.getString("firstname");
                    String userName = results.getString("username");
                    String password = results.getString("password");
                    String email = results.getString("email");
                    int id= results.getInt("id");
                    String developerKey = results.getString("developer_key");
                    developer=new Developer( id, userName,  password, firstName,  lastName, email,developerKey);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return developer;
        }

        @Override
        public Developer findDeveloperByCredentials(String username, String password) {
            Developer developer=null;
            try {
                Connection connection = DBConnection.getConnection();

                String findDeveloperByCredentials="select * from person,developer\r\n" + "where person.p_id=developer.p_id and person.user_name=? and person.password=?;";
                PreparedStatement pStatement = connection.prepareStatement(findDeveloperByCredentials);
                pStatement.setString(1,username);
                pStatement.setString(2,password);
                results = pStatement.executeQuery();

                if(results.next()) {

                    String firstName = results.getString("firstname");
                    String lastName = results.getString("firstname");
                    String userName = results.getString("username");
                    String passWord = results.getString("password");
                    String email = results.getString("email");
                    Date dob = results.getDate("dob");
                    int pId= results.getInt("p_id");
                    String developerKey = results.getString("developer_key");
                    developer=new Developer(pId, userName,  password,  firstName,  lastName,  email, developerKey);

                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return developer;
        }

        @Override
        public int updateDeveloper(int developerId, Developer developer) {
            try {
                Connection connection = DBConnection.getConnection();
                String updateDeveloper= "Update developer join person set " +
                        "`username`=\""+developer.getUserName()+"\"," +
                        "`password`=\""+developer.getPassword()+"\"," +
                        "`firstname`=\""+developer.getFirstName()+"\"," +
                        "`lastname`=\""+developer.getLastName()+"\"," +
                        "`email`=\""+developer.getEmail()+"\"," +
                        "`developer_key`=\""+developer.getDeveloperKey()+"\"," +
                        "phone=\""+developer.getPhone()+"\""+
                        "where person.id = developer.id and person.id=?;" ;
                System.out.println(updateDeveloper);
                PreparedStatement pStatement = connection.prepareStatement(updateDeveloper);
                pStatement.setInt(1,developerId);
                pStatement.executeUpdate();
                return 1;
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return 0;
        }


        @Override
        public int deleteDeveloper(int developerId) {
            try {
                Connection connection = DBConnection.getConnection();
                String deleteDeveloper="Delete developer,person from developer join person\r\n" +
                        " where person.id=developer.p_id and person.id=?;" ;
                System.out.println(deleteDeveloper);
                PreparedStatement pStatement = connection.prepareStatement(deleteDeveloper);
                pStatement.setInt(1,developerId);
                pStatement.executeUpdate();
                return 1;
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return 0;
        }
    }

