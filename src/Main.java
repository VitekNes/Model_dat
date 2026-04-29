import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PlantManager manager = new PlantManager();
        /*try {
            manager.addPlant(new Plant("prokus", "poznamka", LocalDate.of(2020, 9, 17), LocalDate.of(2026, 3, 10), 7));
            manager.addPlant(new Plant("test3"));
            manager.addPlant(new Plant("test2"));
            manager.addPlant(new Plant("test1"));
            System.out.println(manager.getPlant(0).getWateringInfo());
            manager.sortList();
            for(Plant plant : manager.getListCopy()){
                System.out.println(plant.getName());
            }
        } catch (PlantException e) {
            System.err.println("An error has occured: " + e.getMessage());
        }
        try{
            manager.savePlants("out/testSave1.txt", "\t");
        } catch(PlantException e){
            System.err.println("An error has occured: " + e.getMessage());
        }*/
        /*try {
            manager.loadPlants("out/testSave1.txt", "\t");
        } catch (PlantException e) {
            System.err.println("An error has occured: " + e.getMessage());
        }
        System.out.println("Stil running.");*/
    }
}
