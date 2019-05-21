package by.bntu.fitr.povt.service;

import by.bntu.fitr.povt.model.*;
import by.bntu.fitr.povt.repository.DiseaseHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class DefaultVisitService implements VisitService  {

    private DiseaseHistoryRepository diseaseHistoryRepository;

    @Autowired
    public DefaultVisitService(DiseaseHistoryRepository diseaseHistoryRepository) {
        this.diseaseHistoryRepository = diseaseHistoryRepository;
    }

    @Override
    @Transactional
    public void addVisit(Client client, Pet pet, String description, LocalDate date, Specialty doctorType) {
        DiseaseHistory history = new DiseaseHistory(null,date,
                null,pet,client,null,description,null, doctorType);
        diseaseHistoryRepository.save(history);
    }

    @Override
    @Transactional
    public List<DiseaseHistory> getMedicalCard(Pet pet) {
        return diseaseHistoryRepository.findAllDiseaseHistoryByPet(pet);
    }

    @Override
    @Transactional
    public DiseaseHistory getDiseaseHistoryById(Integer id) {
        return diseaseHistoryRepository.getDiseaseHistoryById(id);
    }


    @Override
    @Transactional
    public void doctorAnswer(DiseaseHistory history, Client doctor, String answer) {
        history.setDoctor(doctor);
        history.setAnswer(answer);
        history.setAnswerDate(LocalDate.now());
        diseaseHistoryRepository.update(history);
    }

}
