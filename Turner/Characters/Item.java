public interface Item
{
   public void examine();
   public boolean useable();
   public boolean questItem();
   public void use(Character c);
   public int value();
   public String getType();
   public String getName();
   //public int compareTo(Item i);
}