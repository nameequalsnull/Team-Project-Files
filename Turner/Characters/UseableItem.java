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
   
   public UseableItem()
   {
      this.cp = 50;
      this.trade_val = 1;
      this.tval_modifier = 1.0;
      this.condition = "FAIR";
      this.type = "Useable";
      this.name = "Useable Item";
   }
   
   public UseableItem(int c, int tv, String ty, String n)
   {
      this.cp = c;
      this.tval_modifier = calcModifier(this.cp);
      this.trade_val = (int)(this.tval_modifier * tv);
      this.type = ty;
      this.name = n;
      this.condition = calcCondition(this.cp);
   }
   
   public int getValue(){return this.trade_val;}
   
   private static double calcModifier(int c)
   {
      if(c == 100)
         return 2.5;
      else if(c < 100 && c >= 90)
         return 2.0;
      else if(c < 90 && c >= 70)
         return 1.5;
      else if(c < 70 && c >= 50)
         return 1.0;
      else if(c < 50 && c >= 30)
         return 0.5;
      else if(c < 30 && c >= 10)
         return 0.2;
      else
         return 0.0;   
   }
   
   
   private static String calcCondition(int c)
   {
      if(c == 100)
         return "EXCELLENT";
      else if(c < 100 && c >= 90)
         return "VERY GOOD";
      else if(c < 90 && c >= 70)
         return "GOOD";
      else if(c < 70 && c >= 50)
         return "FAIR";
      else if(c < 50 && c >= 30)
         return "POOR";
      else if(c < 30 && c >= 10)
         return "VERY POOR";
      else
         return "PIECE OF SHIT/WORTHLESS";
   }
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
   
   
   public String getType()
   {
      return this.type;
   }
   
   public void changeCondition(int c)
   {
      if(c < 0 || c > 100)
      {
         if(c < 0)
            this.cp = 0;
         else
            this.cp = 100;
      }
      else
         this.cp = c;
      this.tval_modifier = calcModifier(this.cp);
      this.trade_val = (int)(this.trade_val * this.tval_modifier);
      this.condition = calcCondition(this.cp); 
   }
   public abstract void use();
   public abstract int compareTo(UseableItem i);
}