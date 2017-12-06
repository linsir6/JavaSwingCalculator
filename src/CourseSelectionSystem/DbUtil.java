package CourseSelectionSystem;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.sql.*;
import java.util.ArrayList;

public class DbUtil {


    private static Connection getConn() throws Exception {


        String driver;
        driver = "com.mysql.jdbc.Driver";
        String url;
        url = "jdbc:mysql://localhost:3306/course";
        String username;
        username = "root";
        String password;
        password = "root";
        Connection conn;
        conn = null;

        try {

            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return conn;
    }


    public static int insertUser(People student) throws Exception {
        String driver;
        driver = "com.mysql.jdbc.Driver";
        String url;
        url = "jdbc:mysql://localhost:3306/course";
        String username;
        username = "root";
        String password;
        password = "root";
        Connection conn;
        conn = null;
        try {

            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException e) {

            e.printStackTrace();
            System.out.println("error no class in insertUser");

        } catch (SQLException e) {

            e.printStackTrace();
            System.out.println("sql exception in insertUser");

        }
        int i;
        i = 0;
        String sql;
        sql = "insert into user (username,pwd,courses) values(?,?,?)";
        PreparedStatement pstmt;
        pstmt = null;
        try {

            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, student.getUserName());
            pstmt.setString(2, student.getPwd());
            pstmt.setString(3, student.getCourses());
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            if (pstmt != null) {
                try {

                    pstmt.close();

                } catch (SQLException e) {

                    e.printStackTrace();
                    System.out.println("抛出异常");
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("断开连接时发生异常");
                }
            }


        }
        return i;
    }

    public static int updateUserPwd(People student) throws Exception {

        String driver;
        driver = "com.mysql.jdbc.Driver";
        String url;
        url = "jdbc:mysql://localhost:3306/course";
        String username;
        username = "root";
        String password;
        password = "root";
        Connection conn;
        conn = null;

        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("error no class in updateUserPwd");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("sql exception in updateUserPwd");

        }
        int i;
        i = 0;
        String sql;
        sql = "update user set pwd='" + student.getPwd() + "' where username='" + student.getUserName() + "'";
        PreparedStatement pstmt;
        pstmt = null;
        try {

            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            i = pstmt.executeUpdate();
            System.out.println("resutl: " + i);
            pstmt.close();
            conn.close();

        } catch (SQLException e) {

            e.printStackTrace();
            System.out.println("error no class in updateUserPwd");

        } finally {
            if (pstmt != null) {
                try {

                    pstmt.close();

                } catch (SQLException e) {

                    e.printStackTrace();
                    System.out.println("抛出异常");
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("断开连接时发生异常");
                }
            }


        }
        return i;
    }


    public static int updateUserCourse(People student) throws Exception {


        String driver;
        driver = "com.mysql.jdbc.Driver";
        String url;
        url = "jdbc:mysql://localhost:3306/course";
        String username;
        username = "root";
        String password;
        password = "root";
        Connection conn;
        conn = null;

        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int i;
        i = 0;
        String sql;
        sql = "update user set courses='" + student.getCourses() + "' where username='" + student.getUserName() + "'";
        PreparedStatement pstmt;
        pstmt = null;

        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            i = pstmt.executeUpdate();
            System.out.println("resutl: " + i);
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {

                    pstmt.close();

                } catch (SQLException e) {

                    e.printStackTrace();
                    System.out.println("抛出异常");
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("断开连接时发生异常");
                }
            }


        }
        return i;
    }


    public static ArrayList<People> getAllUser() throws Exception {
        ArrayList<People> students = new ArrayList<>();

        String driver;
        driver = "com.mysql.jdbc.Driver";
        String url;
        url = "jdbc:mysql://localhost:3306/course";
        String username;
        username = "root";
        String password;
        password = "root";
        Connection conn;
        conn = null;

        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql;
        sql = "select * from user";
        PreparedStatement pstmt;
        pstmt = null;

        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            int col = rs.getMetaData().getColumnCount();
            System.out.println("============================");
            while (rs.next()) {
                People student = new People(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("pwd"),
                        rs.getString("courses"));
                students.add(student);
                System.out.println("");
            }
            System.out.println("============================");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {

                    pstmt.close();

                } catch (SQLException e) {

                    e.printStackTrace();
                    System.out.println("抛出异常");
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("断开连接时发生异常");
                }
            }


        }
        return students;
    }


    public static int insertCourse(Course course) throws Exception {


        String driver;
        driver = "com.mysql.jdbc.Driver";
        String url;
        url = "jdbc:mysql://localhost:3306/course";
        String username;
        username = "root";
        String password;
        password = "root";
        Connection conn;
        conn = null;

        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int i;
        i = 0;
        String sql;
        sql = "insert into course (courseName,teacher) values(?,?)";
        PreparedStatement pstmt;
        pstmt = null;

        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, course.getCourseName());
            pstmt.setString(2, course.getTeacherName());
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {

                    pstmt.close();

                } catch (SQLException e) {

                    e.printStackTrace();
                    System.out.println("抛出异常");
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("断开连接时发生异常");
                }
            }


        }


        return i;
    }

    public static ArrayList<Course> getAllCourse() throws Exception {
        ArrayList<Course> courses = new ArrayList<>();


        String driver;
        driver = "com.mysql.jdbc.Driver";
        String url;
        url = "jdbc:mysql://localhost:3306/course";
        String username;
        username = "root";
        String password;
        password = "root";
        Connection conn;
        conn = null;

        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql;
        sql = "select * from course";
        PreparedStatement pstmt;
        pstmt = null;


        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            int col = rs.getMetaData().getColumnCount();
            System.out.println("============================");
            while (rs.next()) {
                Course course = new Course(rs.getInt("id"),
                        rs.getString("courseName"),
                        rs.getString("teacher"));
                courses.add(course);
                System.out.println("");
            }
            System.out.println("============================");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {

                    pstmt.close();

                } catch (SQLException e) {

                    e.printStackTrace();
                    System.out.println("抛出异常");
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("断开连接时发生异常");
                }
            }


        }

        return courses;
    }


    public static void main(String[] args) {

        /**
         * 测试sql语句用的工具类
         */
        People people;
        people = new People(0, "lin", "222222", "chinese");
        try {
            updateUserPwd(people);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<People> arrayList;
        arrayList = new ArrayList<>();
        try {
            arrayList = getAllUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i).getUserName());
        }
        Course course;
        course = new Course(1, "chinese", "mrs zhang");
        try {
            insertCourse(course);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<Course> list;
        list = new ArrayList<>();
        try {
            list = getAllCourse();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(list.get(0).getTeacherName());

    }

}
