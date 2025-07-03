package com.digitalblood.donationbackend.dto;

import java.time.LocalDate;

public class DonorDTO {
    private String fullName;
    private int age;
    private double weight;
    private String bloodType;
    private String gender;
    private String contactNumber;
    private boolean eligible;
    private LocalDate lastDonationDate;

    public DonorDTO() {}

    public DonorDTO(String fullName, int age, double weight, String bloodType, String gender,
                    String contactNumber, boolean eligible, LocalDate lastDonationDate) {
        this.fullName = fullName;
        this.age = age;
        this.weight = weight;
        this.bloodType = bloodType;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.eligible = eligible;
        this.lastDonationDate = lastDonationDate;
    }

    
   

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public boolean isEligible() {
        return eligible;
    }

    public void setEligible(boolean eligible) {
        this.eligible = eligible;
    }

    public LocalDate getLastDonationDate() {
        return lastDonationDate;
    }

    public void setLastDonationDate(LocalDate lastDonationDate) {
        this.lastDonationDate = lastDonationDate;
    }
}
