package GaMEAPP;

import java.lang.invoke.SwitchPoint;
import java.util.List;
import java.util.Scanner;

public class MainGame {

	public static void main(String[] args) {
        GameyutilityImpl guI=new GameyutilityImpl();
		Scanner sr=new Scanner(System.in);
		System.out.println("what operation do you want ");
		String s=sr.next();
		switch (s) {
		case "insert":
		
			System.out.println("Please enter the details of game");
			
			System.out.println("Please enter no of game details");
			int n=sr.nextInt();
			while(n>0){
				System.out.println("Please enter the player Name");
				String PlayerName=sr.next();
				System.out.println("Please enter the player Gender");
				char PlayerGender=sr.next().charAt(0);
				System.out.println("Please enter the team");
				int team=sr.nextInt();
				System.out.println("Please enter the game time");
				int gameTime =sr.nextInt();
				System.out.println("Please enter the location");
				String gameLocation =sr.next();
				GameEntity g1=new GameEntity(PlayerName,PlayerGender,team,gameTime,gameLocation);
			    int r=guI.insertGame(g1);		
				String a=(r>0)?"inserted ":"not yet";
				System.out.println(a);
				n--;
			}
			
			break;
		case "getData":
			List<GameEntity> ls=guI.getAllGame();
			System.out.println(ls);
			for(GameEntity l:ls){
				System.out.println("Player name::"+l.getPlayersName()+"palayer Gender::"+l.getPlayersGender()+"player Team::"+l.getTeam()+
				"player game time::"+l.getGameTime()+"location:"+l.getLocation());
			}
		case "Filter":
			  System.out.println("please enter the type of filter");
			  String f=sr.next();
			  switch (f) {
			case "Location":
				System.out.println("please enter the location");
				String loc=sr.next();
				List<GameEntity> ls1=guI.getGameLocation(loc);
				System.out.println(ls1);
				for(GameEntity l:ls1){
					System.out.println("Player name::"+l.getPlayersName()+"palayer Gender::"+l.getPlayersGender()+"player Team::"+l.getTeam()+
					"player game time::"+l.getGameTime()+"location:"+l.getLocation());
				} 	
				break;

			default:
				break;
			}
			   
		case "Delete":
			   System.out.println("enter the id  that you wnat to delete");
			   int id=sr.nextInt();
			   if(guI.deletePlayers(id)){

				   System.out.println("not deleted!");
			   }else{
    
				   System.out.println("delete succssfully ");
				   List<GameEntity> ls2=guI.getAllGame();
					//System.out.println(l2);
					for(GameEntity l:ls2){
						System.out.println("Player name::"+l.getPlayersName()+"palayer Gender::"+l.getPlayersGender()+"player Team::"+l.getTeam()+
						"player game time::"+l.getGameTime()+"location:"+l.getLocation());
					}
			   }
		case "Search":
			 System.out.println("please enter the type of search ");
			 String search=sr.next();
			 switch (search) {
			case "PlayerName":
				String playerName=sr.next();
				   GameEntity l=guI.PlayerNameSearch(playerName);
					//System.out.println(l2);
				      if(l!=null){
						System.out.println("Player name::"+l.getPlayersName()+"palayer Gender::"+l.getPlayersGender()+"player Team::"+l.getTeam()+
						"player game time::"+l.getGameTime()+"location:"+l.getLocation());
				      }else{
				    	  System.out.println("not found");
				      }
			   
		   		break;
            
			default:
				break;
			}
		default:
		    	
			break;
		}		
		
	    
	}

}
