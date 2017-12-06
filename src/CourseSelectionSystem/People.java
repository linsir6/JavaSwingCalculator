package CourseSelectionSystem;

public class People {

    private int id;
    private String userName;
    private String pwd;
    private String courses;

    public People() {

    }

    public People(int id){
        this.id = id;
    }

    public People(String userName,String pwd){
        this.userName = userName;
        this.pwd = pwd;
    }

    public People(int id, String userName, String pwd) {
        this.id = id;
        this.userName = userName;
        this.pwd = pwd;
    }

    public People(int id, String userName, String pwd, String courses) {
        this.id = id;
        this.userName = userName;
        this.pwd = pwd;
        this.courses = courses;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getCourses() {
        return courses;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", pwd='" + pwd + '\'' +
                ", courses='" + courses + '\'' +
                '}';
    }





}
