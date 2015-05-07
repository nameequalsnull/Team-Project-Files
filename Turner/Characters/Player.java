import java.util.*;
public abstract class Player extends GoodGuy
{
   private ArrayList<Character> party;
   private boolean armored;
   private int armorlvl;
   
   public Player()
   {
      super(50, .50, 50, .50, .50, 10, 3, 10, "Player1", "Player", 1);
      this.armored = false;
      this.armorlvl = 0;
      party = new ArrayList<Character>();
      this.setInventory(new PlayerInventory());
      this.setSuper("PLAYER");
   }
   
   public Player(String n, String t, int h, int a, double hc, double dc, double cc, int s, int umin, int umax, int as)
   {
      super(n, t, h, a, hc,dc,cc,s,umin, umax, as);
      this.armored = false;
      this.armorlvl = 0;
      party = new ArrayList<Character>();
      this.setInventory(new PlayerInventory());
      this.setSuper("PLAYER");
   }
   
   public void addToParty(Character c)
   {
      if(c.getSuper().equals("PARTY"))
      {
         if(!party.contains(c))
         {
            c = (Party)c;
            party.add(c);
            applyEffects(c);
         }
         else
            System.err.println("Already in party.");
      }
      else
         System.err.println("Can only add good guys to party!");
   }
   
   public int getArmorLvl()
   {
      return this.armorlvl;
   }
   
   public void setArmorLvl(int h)
   {
      this.armorlvl = (h < 0 || h > 150) ? (h < 0 ? 0 : (h > 150 ? 150 : h)) : h;
   }
   
   public void removeFromParty(Character c)
   {
      party.remove(c);
      removeEffects(c);
   }
   
   public void removeFromParty(String name)
   {
      for(Character c : party)
         if(c.getName().compareTo(name) == 0)
            removeFromParty(c);
   }
   
   public void dismissParty()
   {
      for(Character c : party)
         removeFromParty(c);
   }
   
   public Character getPartyMember(Character c)
   {
      return party.get(party.indexOf(c));
   }
   
   public Character getPartyMember(String name)
   {
      for(Character c : party)
      {
         if(c.getName().compareTo(name) == 0)
            return c;
      }
      return null;
   }
   
   private void applyEffects(Character c)
   {
      if(c.getSuper().equals("PARTY"))
      {
         c = (Party)c;
         c.giveEffects(this);
      }
      else
         System.err.println("Only party members give bonuses to player!");
   }
   
   private void removeEffects(Character c)
   {
      if(c.getSuper().equals("PARTY"))
      {
         c = (Party)c;
         c.removeEffects(this);
      }
      else
         System.err.println("Only party memmbers can remove bonuses from player!");
   }
   
   public boolean defend()
   {
      if(this.confirmed(this.getDefChance()))
      {
         if(armored && armorlvl != 0)
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
   
   public void partyAttack(Character c)
   {
      for(Character temp : party)
      {
         if(temp.getSuper().equals("PARTY"))
            temp.attack(c);
      }
   }
   
   public void memberAttack(String name, Character temp)
   {
      for(Character c :  party)
      {
         if(c.getName().compareTo(name) == 0 && c.getSuper().equals("PARTY"))
         {
            c.attack(temp);
            break;     
         }
      }
   }
   
   public void getInfo(Character c)
   {
      System.out.println("NAME: " + c.getName());
      System.out.println("HEALTH: " + c.getHP());
      if(c.getSuper().equals("PARTY") || c.getSuper().equals("BADGUY"))
      {
         c = c.getSuper().equals("PARTY") ? (Party)c : (BadGuy)c;
         System.out.println("WEAPON: " + (c.getSuper().equals("PARTY") ? c.getWeapon().getType() : c.getWeapon()));
      }
      else
         System.out.println("UNARMED");
   }
   
   public void currentStats()
   {
      System.out.println("HP: " + this.getHp());
      System.out.println("ARMOR: " + this.getArmor());
   }
   
   public abstract void availableActionsEncounter(Scanner kb, Character encounter);
   public abstract void availableActionsNormal(Scanner kb);
}