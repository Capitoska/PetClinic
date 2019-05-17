package by.bntu.fitr.povt.model;

public enum Specialty {
    THERAPIST("Терапевт"),
    SURGEON("Хирург"),
    OPHTHALMOLOGIST("Офтальмолог"),
    DERMATOLOGIST("Дерматолог"),
    CARDIOLOGIST("Кардиолог"),
    DENTIST("Стоматолог"),
    GYNECOLOGIST("Гинеколог"),
    PROPHYLACTOLOGIST("Профилактолог"),;

    private String displayName;

    Specialty(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
