import java.util.*;

public class Catalog {
    
    private String name;
    private ArrayList<Item> list;

    public Catalog(String name){
        this.name = name;
        this.list = new ArrayList<Item>();
    }
    
    public void add(Item item){ // Adds the item to the catalog
        list.add(item);
    }

    public int size(){ // Returns the size of the catalog
        return list.size();
    }

    public Item get(int index){ // Returns the item at the given index in the catalog
        list.get(index);
        return list.get(index);
    }

    public String getName(){ // Returns the name of the catalog
        return name;
    }
}
