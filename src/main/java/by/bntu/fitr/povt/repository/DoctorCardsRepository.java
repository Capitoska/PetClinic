package by.bntu.fitr.povt.repository;

import by.bntu.fitr.povt.model.DoctorCard;

public interface DoctorCardsRepository {
    DoctorCard find(String card);

    void delete(DoctorCard doctorCard);

    void save(DoctorCard doctorCard);

    void deleteByCard(String card);
}
