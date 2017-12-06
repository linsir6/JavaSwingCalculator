package CourseSelectionSystem;

public class Course {

    private int id;
    private String courseName;
    private String teacherName;


    public Course(){

    }

    public Course(int id){
        this.id = id;
    }


    public Course(int id,String courseName){
        this.id = this.id;
        this.courseName = courseName;
    }



    public Course(int id, String courseName, String teacherName) {
        this.id = id;
        this.courseName = courseName;
        this.teacherName = teacherName;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", teacherName='" + teacherName + '\'' +
                '}';
    }
}
