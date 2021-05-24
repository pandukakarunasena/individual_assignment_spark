package com.panduka.ncms.entity;

public class PatientQueue {
    private int id;
    private Patient patientId;
    private int status;

    public PatientQueue() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatientId() {
        return patientId;
    }

    public void setPatientId(Patient patientId) {
        this.patientId = patientId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override public String toString() {
        return "PatientQueue{" + "id=" + id + ", patientId=" + patientId + ", status=" + status + '}';
    }

}
