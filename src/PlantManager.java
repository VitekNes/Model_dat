import java.io.*;
import java.time.Duration;
import java.time.LocalDate;
import java.util.*;

public class PlantManager {
    List<Plant> plantList = new ArrayList<>();

    public void addPlant(Plant plant){
        plantList.add(plant);
    }

    public Plant getPlant(int i) throws PlantException{
        if(i < 0 || i >= plantList.size()){
            throw new PlantException("Index " +i+ " not in plant list");
        }
        return plantList.get(i);
    }

    public void removePlant(int i) throws PlantException{
        if(i < 1 || i > plantList.size()){
            throw new PlantException("Index " +i+ " not in plant list");
        }
        plantList.remove(i-1);
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

    public List<Plant> getWateringList() throws PlantException{
        List<Plant> temp = new ArrayList<>();
        for(Plant plant : plantList){
            if(Duration.between(plant.getLastWatering(), LocalDate.now()).toDays() > plant.getFrequencyOfWatering()){
                try{
                    temp.add(new Plant(plant.getName(), plant.getNotes(), plant.getPlanted(), plant.getLastWatering(), plant.getFrequencyOfWatering()));
                } catch (PlantException e){
                    throw new PlantException("Failed to load plant:" + e.getMessage());
                }
            }
        }
        return temp;
    }

    public void sortList(SortBy type){
        if(type == SortBy.Name){
            plantList.sort(Comparator.comparing(Plant::getName));
        } else{
            plantList.sort(Comparator.comparing(Plant::getLastWatering));
        }
    }

    public void sortList(){
        plantList.sort(Comparator.comparing(Plant::getName));
    }

    public void loadPlants(String fileName, String delimiter) throws PlantException {
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)))){
            while(scanner.hasNextLine()){
                String[] line = scanner.nextLine().split(delimiter);
                if (line.length != 5) {
                    throw new Exception("Incorect line lenght.");
                }
                addPlant(new Plant(line[0], line[1], LocalDate.parse(line[4]), LocalDate.parse(line[3]), Integer.parseInt(line[2])));
            }
        } catch (Exception e) {
            throw new PlantException("Failed to load the file: " + e.getMessage());
        }
    }

    public void savePlants(String fileName, String delimiter) throws PlantException{
        try(PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))){
            for(Plant plant : plantList){
                writer.println(plant.formatForOutput(delimiter));
            }
        } catch(IOException e){
            throw new PlantException("Failed to save file: " + e.getMessage());
        }
    }
}
