/*
   Abstract useable item class used for constructing basic items
   such as weapons, armor, spells and other related objects.
*/

public abstract class UseableItem implements Item
{
   private int cp;
   private int trade_val;
   private double tval_modifier;
   private String condition;
   private String type;
   private String name;
   
   public void examine()
   {
      System.out.println("ITEM: " + this.name);
      System.out.println("TYPE: " + this.type);
      System.out.println("CONDITION: " + this.condition);
      System.out.println("VALUE: " + this.trade_val);
   }
   
   public boolean useable()
   {
      return true;
   }
   
   public boolean questItem()
   {
      return false;
   }
   
   public abstract boolean questNecessary();
   public abstract void use();
   public abstract void useForQuest();
   public abstract int compareTo(UseableItem i);
}