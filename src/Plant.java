import java.text.Format;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Plant {
    private String name;
    private String notes;
    private LocalDate planted;
    private LocalDate lastWatering;
    private int frequencyOfWatering;

    public Plant(String name, String notes, LocalDate planted, LocalDate lastWatering, int frequencyOfWatering) throws PlantException {
        this.name = name;
        this.notes = notes;
        this.planted = planted;
        setLastWatering(lastWatering);

        setFrequencyOfWatering(frequencyOfWatering);
    }

    public Plant(String name, int frequencyOfWatering) throws PlantException {
        this(name, "No notes", LocalDate.now(), LocalDate.now(), frequencyOfWatering);
    }

    public Plant(String name) throws PlantException {
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

    public void setLastWatering(LocalDate lastWatering) throws PlantException{
        if(lastWatering.isBefore(planted)){
            throw new PlantException("Last watering has to be after planting date");
        }
        this.lastWatering = lastWatering;
    }

    public int getFrequencyOfWatering() {
        return frequencyOfWatering;
    }

    public void setFrequencyOfWatering(int frequencyOfWatering) throws PlantException{
        if(frequencyOfWatering <= 0){
            throw new PlantException("Watering frequency has to be greater then 0.");
        }
        this.frequencyOfWatering = frequencyOfWatering;
    }
    // extra functions
    public String getWateringInfo(){
        return "name: " +name+ "; last time watered: " +lastWatering.format(DateTimeFormatter.ofPattern("d. M. yyyy"))+ "; next watering: " +lastWatering.plusDays(frequencyOfWatering).format(DateTimeFormatter.ofPattern("d. M. yyyy"));
    }

    public void doWateringNow() throws PlantException{
        setLastWatering(LocalDate.now());
    }

    public String formatForOutput(String delimiter){
        return String.join(delimiter, name, notes, Integer.toString(frequencyOfWatering), lastWatering.toString(), planted.toString());
    }
}
