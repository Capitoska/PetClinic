package by.bntu.fitr.povt.model;

import lombok.Getter;

@Getter
public enum PetGender {
    FEMALE(0), MALE(1);

    private Integer gender;

    PetGender(Integer gender) {
        this.gender = gender;
    }

    public static PetGender getGenderById(Integer id){
        for (PetGender petGender : PetGender.values())
            if(petGender.gender.equals(id)) return petGender;
        return null;
    }
}
