package entity.inheritanceEntities;

import javax.persistence.*;

@Entity
@Table(name = "tb_scholarship_student")
@DiscriminatorValue("SS")
public class ScholarshipStudent extends Student {

    private Double scholarshipValue;

    public ScholarshipStudent() {
    }

    public ScholarshipStudent(Long matricula, String name, Double scholarshipValue) {
        super(matricula, name);
        this.scholarshipValue = scholarshipValue;
    }

    public Double getScholarshipValue() {
        return scholarshipValue;
    }

    public void setScholarshipValue(Double scholarshipValue) {
        this.scholarshipValue = scholarshipValue;
    }

    @Override
    public String toString() {
        return "ScholarshipStudent{" +
                "scholarshipValue=" + scholarshipValue +
                '}';
    }
}
