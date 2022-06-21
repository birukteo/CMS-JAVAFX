public class examinations {
    int Date, Patientid, Age;
    String PatintName, Diagnosis, LabTest;

    public String getPatintName() {
        return PatintName;
    }

    public void setPatintName(String PatintName) {
        this.PatintName = PatintName;
    }

    public String getDiagnosis() {
        return Diagnosis;
    }

    public void getDiagnosis(String Diagnosis) {
        this.Diagnosis = Diagnosis;
    }

    public void setLabTest(String LabTest) {
        this.LabTest = LabTest;
    }

    public String getLabTest() {
        return LabTest;
    }

    public void setPatientid(int Patientid) {
        this.Patientid = Patientid;
    }

    public int getPatientid() {
        return Patientid;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public int getAge() {
        return Age;
    }

    public void setDate(int Date) {
        this.Date = Date;
    }

    public int getDate() {
        return Date;
    }

    public examinations(int Date, int Patientid, int Age, String PatintName,
            String Diagnosis,
            String LabTest) {
        this.Date = Date;
        this.Patientid = Patientid;
        this.PatintName = PatintName;
        this.Age = Age;
        this.Diagnosis = Diagnosis;
        this.LabTest = LabTest;

    }

}
