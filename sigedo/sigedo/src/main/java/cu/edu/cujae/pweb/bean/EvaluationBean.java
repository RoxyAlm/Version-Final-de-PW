package cu.edu.cujae.pweb.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class EvaluationBean {

    private String subject;
    private String student;
    private int note;

    public EvaluationBean() {

    }

    public EvaluationBean(String subject, String student, int note) {
        this.subject = subject;
        this.student = student;
        this.note = note;
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

}