package by.bntu.fitr.povt.service;

import by.bntu.fitr.povt.model.*;

import java.time.LocalDate;
import java.util.List;

public interface VisitService {
    void addVisit(Client client, Pet pet, String description, LocalDate date, Specialty doctorType);

    List<DiseaseHistory> getMedicalCard(Pet pet);

    DiseaseHistory getDiseaseHistoryById(Integer id);

    void doctorAnswer(DiseaseHistory history, Client client, String answer);
}
