package by.bntu.fitr.povt.repository;

import by.bntu.fitr.povt.model.DiseaseHistory;

public interface DiseaseHistoryRepository {
    void save(DiseaseHistory diseaseHistory);

    void update(DiseaseHistory diseaseHistory);
}
