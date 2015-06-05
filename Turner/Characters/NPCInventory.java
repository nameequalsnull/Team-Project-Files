import java.util.*;

public class NPCInventory implements Inventory
{
   private ArrayList<Item> inventory;
   
   public NPCInventory()
   {
      this.inventory = new ArrayList<Item>();
   }
   
   public void addItem(Item i)
   {
      inventory.add(i);
   }
   
   public Item getItem(String name)
   {
      for(Item i : inventory)
         if(i.getName().equals(name))
            return i;
      return null;
   }
   
   public Item getItem(Item i)
   {
      return inventory.get(inventory.indexOf(i));
   }
   
   public void removeItem(String name)
   {
      for(Item i : inventory)
         if(i.getName().equals(name))
            this.inventory.remove(i);
   }
   
   public void removeItem(Item i)
   {
      this.inventory.remove(i);
   }
   
   public void listInventory()
   {
      for(Item i : inventory)
         System.out.println(i.getName() + "\nValue: " + i.value() + " gold.");
   }
   
   public ArrayList getWeapons()
   {
      System.out.println("NPCs make no item class distinctions, returning NPC inventory.");
      return this.inventory;
   }
   
   public ArrayList getArmor()
   {
      return getWeapons();  
   }
   
   public ArrayList getGeneral()
   {
      return this.inventory;
   }
   
   public ArrayList<ArrayList<Item>> getItems()
   {
      ArrayList<ArrayList<Item>> items = new ArrayList<ArrayList<Item>>();
      items.add(this.inventory);
      return items;
   }
}