import java.util.*;
public class PlayerInventory implements Inventory
{
   private ArrayList<Item> weapons;
   private ArrayList<Item> armor;
   private ArrayList<Item> general;
   
   public PlayerInventory()
   {
      this.weapons = new ArrayList<Item>();
      this.armor = new ArrayList<Item>();
      this.general = new ArrayList<Item>();
   }
   
   public ArrayList getWeapons(){return this.weapons;}
   public void listWeapons()
   {
      System.out.println("WEAPONS:");
      for(Item i : weapons)
         System.out.println(i.getName());
   }
   public ArrayList getArmor(){return this.armor;}
   public void listArmor()
   {
      System.out.println("ARMOR:");
      for(Item i : armor)
         System.out.println(i.getName());
   }
   public ArrayList getGeneral(){return this.general;}
   public void listGeneral()
   {
      System.out.println("OTHER ITEMS:");
      for(Item i : general)
         System.out.println(i.getName()); 
   }
   
   public void addItem(Item i)
   {
      if(i.getType().equals("WEAPON"))
         weapons.add(i);
      else if(i.getType().equals("ARMOR"))
         armor.add(i);
      else
         general.add(i);
   }
   
   public Item getItem(String name)
   {
      for(Item i : weapons)
         if(i.getName().equals(name))
            return i;
      for(Item i : armor)
         if(i.getName().equals(name))
            return i;
      for(Item i : general)
         if(i.getName().equals(name))
            return i;
      return null;
   }
   
   public Item getItem(Item i)
   {
      if(i.getType().equals("WEAPON"))
         return weapons.get(weapons.indexOf(i));
      else if(i.getType().equals("ARMOR"))
         return armor.get(armor.indexOf(i));
      else
         return general.get(general.indexOf(i));
   }
   
   public Item takeItem(Item i, Inventory from)
   {
      Item took = from.getItem(i);
      from.removeItem(i);
      return took;
   }
   public Item takeItem(String name, Inventory from)
   {
      Item took = from.getItem(name);
      from.removeItem(name);
      return took;
   }
   public void giveItem(Item i, Inventory to)
   {
      to.addItem(i);
   }
   
   public void removeItem(Item i)
   {
      if(i.getType().equals("WEAPON"))
         weapons.remove(i);
      else if(i.getType().equals("ARMOR"))
         armor.remove(i);
      else
         general.remove(i);
   }
   
   public void removeItem(String name)
   {
      for(Item i : weapons)
      {
         if(i.getName().equals(name))
         {
            weapons.remove(i);
            return;
         }
      }
      for(Item i : armor)
      {
         if(i.getName().equals(name))
         {
            armor.remove(i);
            return;
         }
      }
      for(Item i : general)
      {
         if(i.getName().equals(name))
         {
            general.remove(i);
            return;
         }
      }
   }
   
   public void listInventory()
   {
      listWeapons();  
      listArmor();
      listGeneral();
   }
   
   public ArrayList<ArrayList<Item>> getItems()
   {
      ArrayList<ArrayList<Item>> items = new ArrayList<ArrayList<Item>>();
      items.add(this.weapons);
      items.add(this.armor);
      items.add(this.general);
      return items;
   }
}