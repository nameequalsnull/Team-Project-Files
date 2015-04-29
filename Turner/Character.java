/*
   Abstract character class on which all game character classes are built.
   Constrcuts default state for all characters and provides
   for default behaviors.
*/

import java.util.*;
public abstract class Character 
{
   private int hp;
   private double dchance;
   private String name;
   private String type;
   private static Inventory items;
   
   private int unarmedMIN;
   private int unarmedMAX;
   
   private static final int UNARM_MAX = 50;
   
   private static final int DEFAULT_HP = 50;
   private static final double DEFAULT_DEF = .30;
   
   private static final int MAX_HP = 300;
   private static final int MIN_HP_INST = 10;
   private static final double MAX_CHC = 1.0;
   private static final double MIN_CHC = 0.05;
   
   
   public Character()
   {
      this.hp = DEFAULT_HP;
      this.dchance = DEFAULT_DEF;
      this.unarmedMIN = 1;
      this.unarmedMAX = 5;
      this.name = "Default Character";
      this.type = "Character";
   }
   
   /*
   Protected constructor for internal use.
   Assumes all arguments are correct and within allowed ranges.
   */
   protected Character(int h, double dc, int umin, int umax, String n, String t)
   {
      this.hp = h;
      this.dchance = dc;
      this.name = n;
      this.type = t;
      this.unarmedMIN = umin;
      this.unarmedMAX = umax;
   }
   
   /*
   Public constructor for all game characters.
   Checks arguments for correctness and sets to default
   if out of range.
   
   Used primarily for creating playable characters.
   
   Convention is name followed by stats in order.
   
   Perhaps we should change this behavior, maybe.
   */
   public Character(String n, String t, int h, double dc, int umin, int umax)
   {
      if(n == null || n.compareTo("") == 0 || n.compareTo("\n") == 0 || n.compareTo("\r") == 0 || n.compareTo(" ") == 0)
         this.name = "Default Character Name";
      else
         this.name = n;
         
      if(t == null || t.compareTo("") == 0 || t.compareTo("\n") == 0 || t.compareTo("\r") == 0 || t.compareTo(" ") == 0)
         this.type = "Character";
      else
         this.type = t;
      
      if(h < MIN_HP_INST || h > MAX_HP)
      {
         if(h < MIN_HP_INST) //assumption that if HP < MIN_HP_INST that creator wants character with low HP
            this.hp = MIN_HP_INST;
         else
            this.hp = DEFAULT_HP;   
      }
      else
         this.hp = h;
      
      this.dchance = (dc - MIN_CHC < 0.0 || MAX_CHC - dc < 0.0) ? (dc -  MIN_CHC < 0.0 ? MIN_CHC : DEFAULT_DEF) : dc;
         
      if(umax < 1 || umax > UNARM_MAX)
      {
         if(umax < 1)
            this.unarmedMAX = 1;
         else
            this.unarmedMAX = UNARM_MAX;
      }
      else
         this.unarmedMAX = umax;
      
      if(umin < 1 || (umin > umax || umin > this.unarmedMAX))
      {
         if(umin < 1)
            this.unarmedMIN = 1;
         else
         {
            umin = this.unarmedMAX == 0 ? umax - 5 : this.unarmedMAX - 5;
            this.unarmedMIN = umin < 1 ? 1 : umin;  
         }
      }
   }
   
   public String getType()
   {
      return this.type;
   }
   
   public void setType(String t)
   {
      if(t == null || t.compareTo("") == 0 || t.compareTo("\n") == 0 || t.compareTo("\r") == 0 || t.compareTo(" ") == 0)
         this.type = "Character";
      else
         this.type = t;   
   }
   
   public void setHP(int h)
   {
      if(h < 0 || h > MAX_HP)
      {
         if(h < 0)
            this.hp = 0;
         else
            this.hp = MAX_HP;
      }
      else
         this.hp = h;
   }
   
   public void setDefChance(double dc)
   {
      this.dchance = (dc < 0.0 || MAX_CHC - dc < 0.0) ? (dc < 0.0 ? 0.0 : MAX_CHC) : dc;
   }
   
   public double getDefChance(){return this.dchance;}
   
   public void setName(String n)
   {
      if(n != null && !n.equals("") && !n.equals(" ") && !n.equals("\n") && !n.equals("\r") && !n.equals("\0"))
         this.name = n;
      else
         this.name = "Give Me A Better Name";
   }
   
   public int getHP(){return this.hp;}
   public String getName(){return this.name;}
   
   public Inventory getInventory(){return this.items;}
   public void setInventory(Inventory i)
   {
      if(i != null)
         this.items = i;
   }
   
   public boolean isDead(){return this.hp == 0;}
   public boolean hasItems(){return this.items == null;}
   public abstract void displayStats();
   
   public boolean confirmed(double chc)
   {
      int thresh = (int)(100 * chc);
      Random rng = new Random();
      
      int num = rng.nextInt(100)+1;
      
      return num <= thresh;
   }
   
   public abstract void displayInfo();
   public abstract void getInfo(Character c);
}