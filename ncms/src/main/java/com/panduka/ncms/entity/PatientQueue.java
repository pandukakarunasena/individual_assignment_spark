package com.panduka.ncms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "patient_queue")
public class PatientQueue implements E{

    @Id
    private int id;

    @Column(name = "patient_id")
    @OneToOne
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
