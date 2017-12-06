package CourseSelectionSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity {


    private static boolean isHaveUser(String username, String pwd) {

        try {
            ArrayList<People> arrayList;
            arrayList = DbUtil.getAllUser();
            System.out.println(arrayList.size());
            for (int i = 0; i < arrayList.size(); i++) {
                boolean isHaveUsername;
                isHaveUsername = false;
                isHaveUsername = username.equals(arrayList.get(i).getUserName());
                boolean isHaveUserPwd;
                isHaveUserPwd = false;
                isHaveUserPwd = pwd.equals(arrayList.get(i).getPwd());


                if (isHaveUsername) {
                    if (isHaveUserPwd) {
                        return true;
                    } else {

                    }
                } else {

                }
            }
            return false;
        } catch (Exception e) {
            System.out.println("发生异常在isHaveUser");
            return false;
        }

    }

    public static void main(String[] args) {


        while (true) {
            System.out.println("----------------------------");
            System.out.println("----------------------------");
            System.out.println("欢迎来到选课系统");
            System.out.println("注册清按 1");
            System.out.println("登录清按 2");
            System.out.println("----------------------------");
            System.out.println("----------------------------");
            System.out.println();
            System.out.println();
            Scanner in;
            in = new Scanner(System.in);
            switch (in.nextInt()) {

                case 1:
                    System.out.println("----------------------------");
                    System.out.println("----------------------------");
                    System.out.println("欢迎来到注册页面");
                    System.out.println("请输入用户名");
                    System.out.println("----------------------------");
                    System.out.println("----------------------------");
                    System.out.println();
                    System.out.println();

                    String userName;
                    userName = in.next();

                    System.out.println("----------------------------");
                    System.out.println("----------------------------");
                    System.out.println("请输入密码");
                    System.out.println("----------------------------");
                    System.out.println("----------------------------");
                    System.out.println();
                    System.out.println();

                    String pwd;
                    pwd = "";


                    boolean pwdIsOk;
                    pwdIsOk = false;
                    while (!pwdIsOk) {
                        pwd = in.next();
                        if (pwd.length() < 6) {
                            System.out.println("----------------------------");
                            System.out.println("----------------------------");
                            System.out.println("密码最小长度是6位的，请重新输入");
                            System.out.println("----------------------------");
                            System.out.println("----------------------------");
                            System.out.println();
                            System.out.println();
                            pwdIsOk = false;
                        } else {
                            pwdIsOk = true;
                        }
                    }

                    boolean isHaveTheUser;
                    isHaveTheUser = false;
                    ArrayList<People> userList3;
                    userList3 = new ArrayList<>();
                    try {
                        userList3 = DbUtil.getAllUser();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    for (int i = 0; i < userList3.size(); i++) {
                        if (userList3.get(i).getUserName().equals(userName)) {
                            isHaveTheUser = true;
                        }
                    }

                    if (isHaveTheUser) {
                        System.out.println("----------------------------");
                        System.out.println("----------------------------");
                        System.out.println("注册失败，该用户已经存在");
                        System.out.println("----------------------------");
                        System.out.println("----------------------------");
                        System.out.println();
                        System.out.println();
                    } else {
                        People people;
                        people = new People(1, userName, pwd, "");
                        try {
                            DbUtil.insertUser(people);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.println("----------------------------");
                        System.out.println("----------------------------");
                        System.out.println("注册成功，请登录");
                        System.out.println("----------------------------");
                        System.out.println("----------------------------");
                        System.out.println();
                        System.out.println();
                    }


                    break;


                case 2:
                    System.out.println("----------------------------");
                    System.out.println("----------------------------");
                    System.out.println("欢迎来到登录页面");
                    System.out.println("请输入用户名");
                    System.out.println("----------------------------");
                    System.out.println("----------------------------");
                    System.out.println();
                    System.out.println();
                    userName = in.next();
                    System.out.println("----------------------------");
                    System.out.println("----------------------------");
                    System.out.println("请输入密码");
                    System.out.println("----------------------------");
                    System.out.println("----------------------------");
                    System.out.println();
                    System.out.println();
                    pwd = in.next();
                    boolean isHaveUser = false;
                    isHaveTheUser = isHaveUser(userName, pwd);


                    if (isHaveTheUser) {
                        System.out.println("----------------------------");
                        System.out.println("----------------------------");
                        System.out.println("登录成功！");
                        System.out.println("----------------------------");
                        System.out.println("----------------------------");
                        System.out.println();
                        System.out.println();
                        boolean isExit;
                        isExit = false;
                        while (!isExit) {

                            System.out.println("----------------------------");
                            System.out.println("----------------------------");
                            System.out.println("修改密码请按 1");
                            System.out.println("查看课程列表请按 2");
                            System.out.println("选择课程请按 3");
                            System.out.println("查看个人信息 4");
                            System.out.println("退出 5");
                            System.out.println("----------------------------");
                            System.out.println("----------------------------");
                            System.out.println();
                            System.out.println();

                            switch (in.nextInt()) {

                                case 1:
                                    System.out.println("----------------------------");
                                    System.out.println("----------------------------");
                                    System.out.println("正在修改密码...");
                                    System.out.println("请输入密码");
                                    System.out.println("----------------------------");
                                    System.out.println("----------------------------");
                                    System.out.println();
                                    System.out.println();

                                    pwd = in.next();

                                    People people2;
                                    people2 = new People(1, userName, pwd, "");

                                    try {
                                        DbUtil.updateUserPwd(people2);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }

                                    System.out.println("----------------------------");
                                    System.out.println("----------------------------");
                                    System.out.println("修改密码成功");
                                    System.out.println("----------------------------");
                                    System.out.println("----------------------------");
                                    System.out.println();
                                    System.out.println();


                                    break;

                                case 2:

                                    ArrayList<Course> list;
                                    list = new ArrayList<>();
                                    try {
                                        list = DbUtil.getAllCourse();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    System.out.println("----------------------------");
                                    System.out.println("----------------------------");
                                    System.out.print("id" + "\t");
                                    System.out.print("courseName" + "\t");
                                    System.out.print("id" + "\t");
                                    System.out.println();

                                    for (int i = 0; i < list.size(); i++) {
                                        System.out.print(list.get(i).getId() + "\t");
                                        System.out.print(list.get(i).getCourseName() + "\t");
                                        System.out.print(list.get(i).getTeacherName() + "\t");
                                        System.out.println();
                                    }
                                    System.out.println("----------------------------");
                                    System.out.println("----------------------------");
                                    System.out.println();
                                    System.out.println();

                                    break;


                                case 3:

                                    System.out.println("----------------------------");
                                    System.out.println("----------------------------");
                                    System.out.println("请输入想选择的课程,请输入课程名称:");
                                    System.out.println("----------------------------");
                                    System.out.println("----------------------------");
                                    System.out.println();
                                    System.out.println();
                                    String name;
                                    name = in.next();
                                    ArrayList<Course> list2;
                                    list2 = new ArrayList<>();
                                    try {
                                        list2 = DbUtil.getAllCourse();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    boolean isHaveCourse;
                                    isHaveCourse = false;

                                    for (int i = 0; i < list2.size(); i++) {
                                        if (name.equals(list2.get(i).getCourseName())) {
                                            isHaveCourse = true;
                                        }
                                    }
                                    if (isHaveCourse) {
                                        ArrayList<People> userList;
                                        userList = new ArrayList<>();
                                        try {
                                            userList = DbUtil.getAllUser();
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }

                                        for (int i = 0; i < userList.size(); i++) {
                                            if (userList.get(i).getUserName().equals(userName)) {
                                                People people1 = userList.get(i);
                                                people1.setCourses(people1.getCourses() + ";" + name);
                                                try {
                                                    DbUtil.updateUserCourse(people1);
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }

                                            }
                                        }
                                        System.out.println("----------------------------");
                                        System.out.println("----------------------------");
                                        System.out.println("选择成功");
                                        System.out.println("----------------------------");
                                        System.out.println("----------------------------");
                                        System.out.println();
                                        System.out.println();

                                    } else {
                                        System.out.println("----------------------------");
                                        System.out.println("----------------------------");
                                        System.out.println("选择失败，没有这个课程");
                                        System.out.println("----------------------------");
                                        System.out.println("----------------------------");
                                        System.out.println();
                                    }

                                    break;

                                case 4:
                                    ArrayList<People> userList;
                                    userList = new ArrayList<>();
                                    try {
                                        userList = DbUtil.getAllUser();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    for (int i = 0; i < userList.size(); i++) {
                                        if (userList.get(i).getUserName().equals(userName)) {
                                            System.out.println(userList.get(i).getId() + "\t"
                                                    + userList.get(i).getUserName()
                                                    + "\t" + userList.get(i).getCourses());
                                        }
                                    }

                                    break;

                                case 5:
                                    isExit = true;
                                    break;

                            }
                        }


                    } else {

                        System.out.println("登录失败");
                    }

                    break;

                default:
                    System.out.println("请输入正确的功能键");

            }

        }

    }


}
