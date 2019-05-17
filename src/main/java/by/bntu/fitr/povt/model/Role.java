package by.bntu.fitr.povt.model;

public enum Role {
    USER("user"),
    DOCTOR("doctor");

    private String display;

    public String getDisplay() {
        return display;
    }

    Role(String display) {

        this.display = display;
    }
}
