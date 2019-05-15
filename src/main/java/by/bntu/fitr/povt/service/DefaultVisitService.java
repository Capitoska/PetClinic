package by.bntu.fitr.povt.service;

import by.bntu.fitr.povt.model.*;
import by.bntu.fitr.povt.repository.DiseaseHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;

@Service
public class DefaultVisitService implements VisitService  {

    private DiseaseHistoryRepository diseaseHistoryRepository;

//    @Override
//    @Transactional
//    public void addVisit(Client client, Pet pet, String description, Specialty specialty, LocalDate date) {
//        DiseaseHistory history = DiseaseHistory.builder()
//                .client(client)
//                .pet(pet)
//                .description(description)
//                .date(date)
//                .build();
//
//        diseaseHistoryRepository.save(history);
//    }

    @Override
    @Transactional
    public void doctorAnswer(DiseaseHistory history, Doctor doctor, String answer) {
        history.setDoctor(doctor);
        history.setAnswer(answer);
        history.setAnswerDate(LocalDate.now());
        diseaseHistoryRepository.update(history);
    }

    @Autowired
    public void setDiseaseHistoryRepository(DiseaseHistoryRepository diseaseHistoryRepository) {
        this.diseaseHistoryRepository = diseaseHistoryRepository;
    }
}
