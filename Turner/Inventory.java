public interface Inventory
{
   public Item getItem(int idx);
   public Item getItem(String name);
   public Item getItem(Item i);
   public void addItem(Item i);
   public void addItem(Item i, int idx);
   public void removeItem(int idx);
   public void removeItem(String name);
   public void removeItem(Item i);
   public void moveItem(int from, int to);
   public void moveItem(String name, int to);
   public void moveItem(Item i, int to);
   public Item takeItem(Inventory from);
   public void giveItem(Item i, Inventory to);
   
}