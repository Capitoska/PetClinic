package by.bntu.fitr.povt.model;

public class ModelTest {
    private Integer phoneNumber;
    private String password;
    private String nickName;

    public ModelTest(Integer phoneNumber, String password, String nickName) {
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "ModelTest{" +
                "phoneNumber=" + phoneNumber +
                ", password='" + password + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
