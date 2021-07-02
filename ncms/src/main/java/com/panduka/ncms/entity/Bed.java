package com.panduka.ncms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table( name = "bed")
public class Bed {

   @Id
   @GeneratedValue(strategy= GenerationType.AUTO)
   private int id;

   @ManyToOne
   private Hospital hospital;

   @OneToOne
   private Patient patient;

   @Column( name = "is_filled")
   private boolean isFilled;

    public Bed() {
    }

    public Bed(int id, Hospital hospital, Patient patient, boolean isFilled) {
        this.id = id;
        this.hospital = hospital;
        this.patient = patient;
        this.isFilled = isFilled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Hospital getHospitalId() {
        return hospital;
    }

    public void setHospitalId(Hospital hospital) {
        this.hospital = hospital;
    }

    public Patient getPatientId() {
        return patient;
    }

    public void setPatientId(Patient patient) {
        this.patient = patient;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public void setFilled(boolean isFilled) {
        this.isFilled = isFilled;
    }

    @Override public String toString() {
        return "Bed{" + "id=" + id + ", hospital=" + hospital + ", patient=" + patient + ", isFilled=" + isFilled + '}';
    }

}
