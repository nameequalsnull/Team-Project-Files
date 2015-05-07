public abstract class BadGuy extends Character
{
   private int dmin, dmax;
   private double hchance, schance, rchance;
   private int ptol, armorlvl;
   private boolean armored;
   private boolean armed;
   private String weapon;
   
   public BadGuy()
   {
      super();
      this.dmin = 10;
      this.dmax = 30;
      this.hchance = .50;
      this.schance = .20;
      this.rchance = .10;
      this.ptol = 5;
      this.armorlvl = 0;
      this.armored = false;
      this.armed = false;
      this.weapon = "MY MOTHERFUCKING FISTS";
      this.setSuper("BADGUY");
   }
   
   public BadGuy(int h, double dc, int umin, int umax, String n, String t, int dmin, int dmax)
   {
      super(h, dc, umin, umax, n, t);
      this.dmin = dmin;
      this.dmax = dmax;
      this.hchance = .50;
      this.schance = .20;
      this.rchance = .10;
      this.ptol = 5;
      this.armorlvl = 0;
      this.armored = false;
      this.armed = false;
      this.weapon = "MY MOTHERFUCKING FISTS";
      this.setSuper("BADGUY");
   }
}