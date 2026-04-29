import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PlantManager manager = new PlantManager();
        try {
            manager.loadPlants("in/kvetiny.txt", "\t");
        } catch (PlantException e) {
            System.err.println("Failed to load file: " + e.getMessage());
        }
        try {
            for(Plant plant : manager.getListCopy()){
                System.out.println(plant.getWateringInfo());
            }
            manager.addPlant(new Plant("Lilie", "modra", LocalDate.of(2024, 6, 12), LocalDate.now(), 5));
            for(int i = 1; i < 11; i++){
                manager.addPlant(new Plant("Tulipán na prodej " +i, 14));
            }
            manager.removePlant(3);
        } catch (PlantException e) {
            System.err.println("An error has occured: " + e.getMessage());
        }
        try{
            manager.savePlants("out/testSave.txt", "\t");
        } catch(PlantException e){
            System.err.println("Failed to save: " + e.getMessage());
        }

        PlantManager manager2 = new PlantManager();
        try {
            manager2.loadPlants("out/testSave.txt", "\t");
        } catch (PlantException e) {
            System.err.println("Failed to load file: " + e.getMessage());
        }
        try {
            System.out.println();
            for(Plant plant : manager2.getListCopy()){
                System.out.println(plant.getWateringInfo());
            }
            manager2.sortList();
            System.out.println();
            for(Plant plant : manager2.getListCopy()){
                System.out.println(plant.getWateringInfo());
            }
            manager2.sortList(SortBy.LastWatering);
            System.out.println();
            for(Plant plant : manager2.getListCopy()){
                System.out.println(plant.getWateringInfo());
            }
            System.out.println("Finished");
        } catch (PlantException e){
            System.err.println("An error has occured: " + e.getMessage());
        }

    }
}
