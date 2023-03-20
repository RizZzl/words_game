import jakarta.persistence.*;

@Entity
@Table(name = "Courses")
public class Course
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int duration;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    private CurseType type;

    private String description;

    @Column(name = "teacher_id")
    private int teacherId;

    @Column(name = "student_count")
    private int studentCount;

    private int prise;

    @Column(name = "prise_per_hour")
    private float prisePerHour;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public CurseType getType() {
        return type;
    }

    public void setType(CurseType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public int getPrise() {
        return prise;
    }

    public void setPrise(int prise) {
        this.prise = prise;
    }

    public float getPrisePerHour() {
        return prisePerHour;
    }

    public void setPrisePerHour(float prisePerHour) {
        this.prisePerHour = prisePerHour;
    }
}
