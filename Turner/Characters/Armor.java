public abstract class Armor extends UseableItem
{
   private int protection;
   
   public Armor()
   {
      super();
      this.protection = 30;
   }
   
   public Armor(int c, int tv, String ty, String n, int p)
   {
      super(c, tv, ty, n);
      this.protection = p < 5 ? 5 : (p > 50 ? 50 : p);
   }
   
   public void use(Character c)
   {
      if(c.getSuper().equals("PARTY") || c.getSuper().equals("PLAYER"))
      {
         if(c.getSuper().equals("PARTY"))
         {
            Party temp = (Party)c;
            temp.setArmorlvl(temp.getArmorlvl() + this.protection);
            temp.getInventory().removeItem(this);
            c = temp;
         }
         else
         {
            Player temp = (Player)c;
            temp.setArmorlvl(temp.getArmorlvl() + this.protection);
            temp.getInventory().removeItem(this);
            c = temp;
         }
      }
      else
         c.getInventory().addItem(this);
   }
}