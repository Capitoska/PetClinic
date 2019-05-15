package by.bntu.fitr.povt.service;

import by.bntu.fitr.povt.model.*;

import java.time.LocalDate;

public interface VisitService {
//    void addVisit(Client client, Pet pet, String description, Specialty specialty, LocalDate date);

    void doctorAnswer(DiseaseHistory history, Doctor doctor, String answer);
}
