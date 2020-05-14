package by.bntu.fitr.povt.repository;

import by.bntu.fitr.povt.model.Client;
import by.bntu.fitr.povt.model.DiseaseHistory;
import by.bntu.fitr.povt.model.Pet;
import by.bntu.fitr.povt.model.Specialty;

import java.util.List;

public interface DiseaseHistoryRepository extends Repository<DiseaseHistory> {
    void createDiseaseHistory(DiseaseHistory History);

    List<DiseaseHistory> findAllDiseaseHistoryByPet(Pet pet);

    DiseaseHistory getDiseaseHistoryById(Integer id);

    List<DiseaseHistory> getAllDiseaseBySpecialty(Specialty specialty);
}
