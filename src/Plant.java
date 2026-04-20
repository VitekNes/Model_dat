import java.text.Format;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Plant {
    private String name;
    private String notes;
    private LocalDate planted;
    private LocalDate lastWatering;
    private int frequencyOfWatering;

    public Plant(String name, String notes, LocalDate planted, LocalDate lastWatering, int frequencyOfWatering){
        this.name = name;
        this.notes = notes;
        this.planted = planted;
        this.lastWatering = lastWatering;
        this.frequencyOfWatering = frequencyOfWatering;
    }

    public Plant(String name, int frequencyOfWatering) {
        this(name, "", LocalDate.now(), LocalDate.now(), frequencyOfWatering);
    }

    public Plant(String name) {
        this(name, 7);
    }
    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getPlanted() {
        return planted;
    }

    public void setPlanted(LocalDate planted) {
        this.planted = planted;
    }

    public LocalDate getLastWatering() {
        return lastWatering;
    }

    public void setLastWatering(LocalDate lastWatering) {
        this.lastWatering = lastWatering;
    }

    public int getFrequencyOfWatering() {
        return frequencyOfWatering;
    }

    public void setFrequencyOfWatering(int frequencyOfWatering) {
        this.frequencyOfWatering = frequencyOfWatering;
    }
    // extra functions
    public String getWateringInfo(){
        return "name: " +name+ "; last time watered: " +lastWatering.format(DateTimeFormatter.ofPattern("d. M. yyyy"))+ "; next watering: " +lastWatering.plusDays(frequencyOfWatering).format(DateTimeFormatter.ofPattern("d. M. yyyy"));
    }

    public void doWateringNow(){
        setLastWatering(LocalDate.now());
    }
}
