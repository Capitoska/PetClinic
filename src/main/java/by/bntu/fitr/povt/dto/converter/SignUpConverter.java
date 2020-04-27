package by.bntu.fitr.povt.dto.converter;

import by.bntu.fitr.povt.dto.SignUpUserDto;
import by.bntu.fitr.povt.model.Client;
import by.bntu.fitr.povt.model.DoctorInfo;
import by.bntu.fitr.povt.model.Role;
import by.bntu.fitr.povt.model.Specialty;
import org.springframework.stereotype.Component;

@Component
public class SignUpConverter {
    public Client toOwner(SignUpUserDto signUpUserDto){
        Client client = Client.builder()
                .firstName(signUpUserDto.getFirstName())
                .secondName(signUpUserDto.getSecondName())
                .username(signUpUserDto.getNickName())
                .password(signUpUserDto.getPassword())
                .phoneNumber(Long.parseLong(signUpUserDto.getPhone()))
                .role(Role.USER).build();
        return client;
    }

    public Client toDoctor(SignUpUserDto signUpUserDto){
        DoctorInfo doctorInfo =DoctorInfo.builder().specialty(Specialty.valueOf(signUpUserDto.getSpecialistic())).build();
        return  toOwner(signUpUserDto).builder()
                .role(Role.DOCTOR)
                .doctorInfo(doctorInfo).build();
    }
}
