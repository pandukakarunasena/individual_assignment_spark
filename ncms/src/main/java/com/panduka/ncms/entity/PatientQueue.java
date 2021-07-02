package com.panduka.ncms.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "patient_queue")
public class PatientQueue{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "patientQueue")
    private List<Patient> patients;

    private int status;

    public PatientQueue() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Patient> getPatientId() {
        return patients;
    }

    public void setPatientId(List<Patient> patients) {
        this.patients = patients;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override public String toString() {
        return "PatientQueue{" + "id=" + id + ", patients=" + patients + ", status=" + status + '}';
    }

}
