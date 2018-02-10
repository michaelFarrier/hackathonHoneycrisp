import java.util.Hashtable;

public class Building{
    public String name;
    Hashtable fountainList = new Hashtable(100);

    public Building(String buildingName){
        name = buildingName;
    }

    public void addToList(int fountainID, Fountain instance){
        fountainList.put(fountainID, instance);
    }

    public Fountain getFountainByID(int id){
        return (Fountain) fountainList.get(id);
    }
}

