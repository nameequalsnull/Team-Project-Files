public abstract class Party extends GoodGuy
{
   private int armorlvl;
   public Party()
   {
      super();
      this.armorlvl = 10;
      this.setInventory(new NPCInventory());
      this.setSuper("PARTY");
   }
   
   public Party(String n, String t, int h, int a, double hc, double dc, double cc, int s, int umin, int umax, int as, int al)
   {
      super(n, t, h, a, hc,dc,cc,s,umin, umax, as);
      setArmor(al);
      this.setInventory(new NPCInventory());
      this.setSuper("PARTY");
   }
   
   public int getArmor()
   {
      return this.armorlvl;
   }
   
   public void setArmor(int h)
   {
      this.armorlvl = (h < 0 || h > 100) ? (h < 0 ? 0 : (h > 100 ? 100 : h)) : h; //learn ternary operators bros
                                                                                 //they make conditional statements so
                                                                                 //much easier  
   }
   
   public abstract void displayStats();
   
   public abstract void attack(Character opponent);
   
   public boolean defend()
   {
      if(this.confirmed(this.getDefChance()))
      {
         if(armorlvl != 0)
            System.out.println(this.getName() + "'s armor stopped the blow!");
         else
            System.out.println(this.getName() + " successfully blocked the attack!");
         return true;
      }
      else
      {
         System.out.println(this.getName() + " was unable to defend against the attack!");
         return false;
      }
   }
}