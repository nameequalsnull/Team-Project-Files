public class Map
{
   private Character[][] world;
   private int badguys;
   private int npcs;
   
   public Map()
   {
      world = new Character[10][30];
      for(int c = 0; c < world[0].length; c++)
         world[0][c] = new GenericCharacter();
      for(int c = 0; c < world[world.length - 1].length; c++)
         world[world.length - 1][c] = new GenericCharacter();
      for(int r = 0; r < world.length; r++)
         world[r][0] = new GenericCharacter();
      for(int r = 0; r < world.length; r++)
         world[r][29] = new GenericCharacter();
   }
   
   public void display()
   {
      for(int r = 0; r < world.length; r++)
      {
         for(int c = 0; c < world[r].length; c++)
            System.out.print(world[r][c] == null ? "" : (world[r][c].getSuper().equals("GENERIC") ? "*" : (world[r][c].getSuper().equals("NPC") ? "N" : (world[r][c].getSuper().equals("BADGUY") ? "B" : (world[r][c].getSuper().equals("PLAYER") ? "X" : "?")))));
         System.out.println();    
      }
      System.out.println("LEGEND: ");
      System.out.println("* - Map boundaries \t\t N - NPC \t\t B - bad guy \t\t X - you \t\t ? - error");
   }
   
   /*public void movePlayer(Character player, int x_from, int y_from, int x_to, int y_to, GameEngine g)
   {
      if(x_to >= world[0].length || y_to >= world.length)
      {
         System.err.println("Cannot move player out of bounds!");
         return;
      }
      else if(world[y_to][x_to] != null)
      {
         if(world[y_to][x_to].getSuper().equals("GENERIC"))
         {
            System.err.println("Cannot move player out of bounds!");
            return;  
         }
         else
         {
            if(world[y_to][x_to].getSuper().equals("NPC"))
            {
               g.updateState("NPC_ENCOUNTER");
               return;   
            }
            else if(world[y_to][x_to].getSuper().equals("BADGUY"))
            {
               g.updateState("COMBAT_WOMBAT");
               return;
            }
            else
            {
               world[y_from][x_from] = null;
               world[y_to][x_to] = null;
               world[y_to][x_to] = player;
            }
         }
      }
      else
      {
         world[y_from][x_from] = null;
         world[y_to][x_to] = player;   
      }
   }*/
}