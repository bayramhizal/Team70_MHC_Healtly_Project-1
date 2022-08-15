package pojos.pojo_US_09;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Appointments {
    /*
     {
        "createdBy": "anonymousUser",
        "createdDate": "2022-01-04T14:24:39.353252Z",
        "id": 5603,
        "startDate": "2022-01-04T00:00:00Z",
        "endDate": "2022-01-04T01:00:00Z",
        "status": "UNAPPROVED",
        "anamnesis": null,
        "treatment": null,
        "diagnosis": null,
        "prescription": null,
        "description": null,
        "physician": null,
        "patient": {
            "createdBy": "anonymousUser",
            "createdDate": "2022-01-01T14:31:36.539261Z",
            "id": 4862,
            "firstName": "Omer",
            "lastName": "Nadercikli",
            "birthDate": "1010-02-01T18:38:00Z",
            "phone": "4387221874",
            "gender": "FEMALE",
            "bloodGroup": "Bnegative",
            "adress": "Fettek",
            "email": "elroy.mitchell@gmail.com",
            "description": "We are conducting Medunna",
            "user": {
                "createdBy": "anonymousUser",
                "createdDate": "2021-12-25T17:00:55.695854Z",
                "id": 3314,
                "login": "apl",
                "firstName": "Pl",
                "lastName": "Ali",
                "email": "apl@email.com",
                "activated": true,
                "langKey": "en",
                "imageUrl": null,
                "resetDate": null,
                "ssn": "888-88-8766"
            },
            "inPatients": null,
            "country": {
                "id": 1201,
                "name": "Türkye"
            },
            "cstate": {
                "id": 1251,
                "name": "antep",
                "country": {
                    "id": 1201,
                    "name": "Türkye"
                }
            }
        },
        "ctests": null
    }
]
     */

    private String createdBy;
    private String createdDate;
    private int id;
    private String startDate;
    private String endDate;
    private String anamnesis;
    private String treatment;
    private Patient2 patient;
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
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public String getAnamnesis() {
        return anamnesis;
    }
    public void setAnamnesis(String anamnesis) {
        this.anamnesis = anamnesis;
    }
    public String getTreatment() {
        return treatment;
    }
    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
    public Patient2 getPatient() {
        return patient;
    }
    public void setPatient(Patient2 patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Appointments{" +
                "createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", id=" + id +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", anamnesis='" + anamnesis + '\'' +
                ", treatment='" + treatment + '\'' +
                ", patient=" + patient +
                '}';
    }
}
