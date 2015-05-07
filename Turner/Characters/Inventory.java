import java.util.*;
public interface Inventory
{
   public ArrayList getWeapons();
   public ArrayList getArmor();
   public ArrayList getGeneral();
   public Item getItem(String name);
   public Item getItem(Item i);
   public void addItem(Item i);
   public void removeItem(String name);
   public void removeItem(Item i);
   public void listInventory();
   public ArrayList<ArrayList<Item>> getItems();
}