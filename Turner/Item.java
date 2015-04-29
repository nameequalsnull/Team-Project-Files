public interface Item extends Comparable<Item>
{
   public void examine();
   public boolean useable();
   public boolean questItem();
   public boolean questNecessary();
   public void use();
   public void useForQuest();
   public String getType();
   public int compareTo(Item i);
}