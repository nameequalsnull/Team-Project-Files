public abstract class Weapon extends UseableItem
{
   int dmin;
   int dmax;
   
   public Weapon()
   {
      super();
      this.dmin = 10;
      this.dmax = 30;
   }
   
   public Weapon(int c, int tv, String ty, String n, int dmin, int dmax)
   {
      super(c, tv, ty, n);
      this.dmin = dmin < 5 ? 5 : (dmin > 70 ? 70 : dmin);
      this.dmax = dmax < 5 ? 5 : (dmax > 70 ? 70 : dmax);
   }
   
   public int getDmin(){return this.dmin;}
   public int getDmax(){return this.dmax;}
   public void setDmin(int d){this.dmin = d;}
   public void setDmax(int d){this.dmax = d;}
   
   public void use(Character c)
   {
      if(c.getSuper().equals("PARTY") || c.getSuper().equals("PLAYER"))
      {
         if(c.getSuper().equals("PARTY"))
         {
            Party temp = (Party)c;
            temp.setWeapon(this);
            temp.getInventory().removeItem(this);
            c = temp;
         }
         else
         {
            Player temp = (Player)c;
            temp.setWeapon(this);
            temp.getInventory().removeItem(this);
            c = temp;   
         }
      }
      else
         c.getInventory().addItem(this);
   }
   
}