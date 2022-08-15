package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Physician {
    /*
    {
        "createdBy": "olleydone",
        "createdDate": "2022-03-02T22:06:05.657286Z",
        "id": 10516,
        "firstName": "Daqar",
        "lastName": "Werr",
        "birthDate": "1980-06-14T21:00:00Z",
        "phone": "147-587-6895",
        "gender": "FEMALE",
        "bloodGroup": "Opositive",
        "adress": "Street 87 NY",
        "description": "Boston street",
        "user": {
            "createdBy": "anonymousUser",
            "createdDate": "2022-03-01T19:51:50.498079Z",
            "id": 10634,
            "login": "daqwerr",
            "firstName": "Daqar",
            "lastName": "Werr",
            "email": "daqwerr@gmail.com",
            "activated": true,
            "langKey": "en",
            "imageUrl": null,
            "resetDate": null,
            "ssn": "789-45-6988"
        },
        "speciality": "DIAGNOSTIC_RADIOLOGY",
        "appointments": null,
        "country": {
            "id": 1202,
            "name": "Turkey"
        },
        "cstate": {
            "id": 1309,
            "name": "Artvin",
            "country": {
                "id": 1202,
                "name": "Turkey"
            }
        },
        "examFee": 750.00,
     */

    private String createdBy;
    private String createdDate;
    private int id;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String phone;
    private String gender;
    private String bloodGroup;
    private String adress;
    private String description;
    private String speciality;
    private int examFee;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getExamFee() {
        return examFee;
    }

    public void setExamFee(int examFee) {
        this.examFee = examFee;
    }

    public Physician() {
    }

    public Physician(String createdBy, String createdDate, int id, String firstName, String lastName, String birthDate, String phone, String gender, String bloodGroup, String adress, String description, String speciality, int examFee) {
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.adress = adress;
        this.description = description;
        this.speciality = speciality;
        this.examFee = examFee;
    }

    @Override
    public String toString() {
        return "Physician{" +
                "createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", adress='" + adress + '\'' +
                ", description='" + description + '\'' +
                ", speciality='" + speciality + '\'' +
                ", examFee=" + examFee +
                '}';
    }
}
