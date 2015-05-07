public interface Item extends Comparable<Item>
{
   public void examine();
   public boolean useable();
   public boolean questItem();
   public void use();
   public String getType();
   public String getName();
   public int compareTo(Item i);
}