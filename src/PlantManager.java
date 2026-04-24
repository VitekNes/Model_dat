import java.util.ArrayList;
import java.util.List;

public class PlantManager {
    List<Plant> plantList = new ArrayList<>();

    public void addPlant(Plant plant){
        plantList.add(plant);
    }

    public Plant getPlant(int i){
        // Needs exeption check
        return plantList.get(i);
    }

    public void removePlant(int i){
        //Needs exeption check
        plantList.remove(i);
    }

    public List<Plant> getListCopy() throws PlantException{
        List<Plant> temp = new ArrayList<>();
        for(Plant plant : plantList){
            try{
                temp.add(new Plant(plant.getName(), plant.getNotes(), plant.getPlanted(), plant.getLastWatering(), plant.getFrequencyOfWatering()));
            } catch(PlantException e){
                throw new PlantException("Failed to load plant:" + e.getMessage());
            }
        }
        return temp;
    }
}
