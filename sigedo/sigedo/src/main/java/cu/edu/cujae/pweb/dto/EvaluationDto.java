package cu.edu.cujae.pweb.dto;

public class EvaluationDto {
    private String id;
    private String subject;
    private String student;
    private int note;
    private boolean newRecord;

    public EvaluationDto() {
        super();
    }

    public EvaluationDto(String id, String subject, String student, int note, boolean newRecord) {
        super();
        this.id = id;
        this.subject = subject;
        this.student = student;
        this.note = note;
        this.newRecord = newRecord;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public boolean isNewRecord() {
        return newRecord;
    }

    public void setNewRecord(boolean newRecord) {
        this.newRecord = newRecord;
    }

}
