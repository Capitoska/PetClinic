package by.bntu.fitr.povt.service;

import by.bntu.fitr.povt.dto.SignUpUserDto;
import by.bntu.fitr.povt.model.Client;
import by.bntu.fitr.povt.model.DiseaseHistory;
import by.bntu.fitr.povt.model.Specialty;

import java.util.List;

public interface DoctorService {
    boolean isDoctorCardByName(String cardName);

    Client getDoctorByUsername(String username);

    List<DiseaseHistory> getAllDiseaseBySpecialty(Specialty specialty);

    boolean createDoctor(Client client);

    public boolean createDoctor(SignUpUserDto client);

    void updateDoctor(Client client);
}
