package by.bntu.fitr.povt.service;

import by.bntu.fitr.povt.Main;
import by.bntu.fitr.povt.model.*;
import by.bntu.fitr.povt.repository.DiseaseHistoryRepository;
import by.bntu.fitr.povt.repository.DoctorCardsRepository;
import by.bntu.fitr.povt.repository.DoctorRepository;
import by.bntu.fitr.povt.repository.Repository;
import lombok.extern.log4j.Log4j2;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@SpringBootTest(classes = Main.class)
@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = Main.class, loader = AnnotationConfigContextLoader.class)
class DefaultDoctorServiceTest {

    @Autowired
    private  DoctorRepository doctorRepository;
    @Autowired
    private  Repository<DoctorInfo> doctorInfoRepository;
    @Autowired
    private  DoctorCardsRepository doctorCardsRepository;
    @Autowired
    private DiseaseHistoryRepository diseaseHistoryRepository;
    @Autowired
    private  ConfigurableApplicationContext context;
    @Autowired
    private  DoctorService service;
    @Autowired
    private  SessionFactory factory;


    @Transactional
    @Test
    void createDoctorNotValidFalse(){
        Client client = new Client();
        client.setFirstName("1");
        client.setSecondName("2");
        client.setUsername("testusername");
        client.setPassword("4");
        client.setPhoneNumber(5L);
        client.setRole(Role.USER);
        assertFalse(service.createDoctor(client));
    }


    @Transactional
    @Test
    void createDoctorIsValidTrue(){
        DoctorCard card = new DoctorCard();
        card.setCard("test1");
        (doctorCardsRepository).save(card);

        DoctorInfo doctorInfo = new DoctorInfo();
        doctorInfo.setSpecialty(Specialty.CARDIOLOGIST);
        doctorInfo.setResult(0);
        doctorInfo.setSumVote(0);
        doctorInfo.setVoteAmount(0);
        Client client = new Client();
        client.setFirstName("1");
        client.setSecondName("2");
        client.setUsername("testusername");
        client.setPassword("4");
        client.setPhoneNumber(5L);
        client.setRole(Role.DOCTOR);
        client.setIdCard("test1");
        client.setDoctorInfo(doctorInfo);
        assertTrue(service.createDoctor(client));
    }
//
//    @Transactional
//    @Test
//    void createDoctor() {
//        DoctorCard card = new DoctorCard();
//        card.setCard("test1");
//        (doctorCardsRepository).save(card);
//
//        DoctorInfo doctorInfo = new DoctorInfo();
//        doctorInfo.setSpecialty(Specialty.CARDIOLOGIST);
//        doctorInfo.setResult(0);
//        doctorInfo.setSumVote(0);
//        doctorInfo.setVoteAmount(0);
//        Client client = new Client();
//        client.setFirstName("1");
//        client.setSecondName("2");
//        client.setUsername("testusername");
//        client.setPassword("4");
//        client.setPhoneNumber(5L);
//        client.setRole(Role.DOCTOR);
//        client.setIdCard("test1");
//        client.setDoctorInfo(doctorInfo);
//        service.createDoctor(client);
//        DoctorCard card1 = doctorCardsRepository.find("test1");
//        assertNull(card1);
//
//        Client testusername = doctorRepository.findByUsername("testusername");
//        assertNotNull(testusername);
//        assertNotNull(testusername.getDoctorInfo());
//
//        Client testusername1 = doctorRepository.findByUsername("testusername");
//        doctorInfoRepository.delete(testusername1.getDoctorInfo());
//        doctorRepository.delete(testusername1);
//    }
}