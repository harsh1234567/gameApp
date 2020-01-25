package GaMEAPP;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.ConnectionImpl;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.util.ResultSetUtil;

public class GameyutilityImpl implements gameUtility {
	//connection DB
  	private static Connection connection=ConnectionDao.getInstance().getConnection();
	
	@Override
	public int insertGame(GameEntity GameEntity) {
		String PlayerName=GameEntity.getPlayersName();
		char PlayerGender=GameEntity.getPlayersGender();
		int team=GameEntity.getTeam();
		int gameTime=GameEntity.getGameTime();
		String Location=GameEntity.getLocation();
		int result=0;
		try{
		 // connection=ConnectionDao.getInstance().getConnection();
		  Statement s=(Statement) connection.createStatement();
		  String sqlquery="insert into gameData(playersName,playersGender,team,gameTime ,Location,reg_date) values('"+PlayerName + "','" + PlayerGender + "','"
						+ team + "','" + gameTime + "','"+Location+"',CURRENT_TIMESTAMP)";
		  result=s.executeUpdate(sqlquery);
		}catch(SQLException e){
			  e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<GameEntity> getAllGame() {
	    List<GameEntity> ls=new ArrayList<GameEntity>();
		try {
			 Statement s=(Statement) connection.createStatement();
			 String sqlQuery="select * from gameData";
			 ResultSet rs=s.executeQuery(sqlQuery);
			 while(rs.next()){
				 GameEntity ge=new GameEntity(rs.getString(2), rs.getString(3).charAt(0), rs.getInt(4), rs.getInt(5), rs.getString(6));
				 ls.add(ge);
			 }
		} catch (SQLException e) {
	      e.printStackTrace();
		 }
		return ls;
	}

	@Override
	public List<GameEntity> getGameLocation(String loc) {
		 List<GameEntity> ls=new ArrayList<GameEntity>();
			try {
				 Statement s=(Statement) connection.createStatement();
				 String sqlQuery="select * from gameData where Location='"+loc.toLowerCase()+"'";
				 ResultSet rs=s.executeQuery(sqlQuery);
				 
				 while(rs.next()){
					 GameEntity ge=new GameEntity(rs.getString(2), rs.getString(3).charAt(0), rs.getInt(4), rs.getInt(5), rs.getString(6));
					 ls.add(ge);
				 }
			} catch (SQLException e) {
		      e.printStackTrace();
			 }
			return ls;
	}

	@Override
	public List<String> getAllPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getAllMalePlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getAllFemalePlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deletePlayers(int playersId) {
		boolean check=false;
		try {
			 Statement s=(Statement) connection.createStatement();
			 String sqlQuery="delete from gameData where id='"+playersId+"'";
			  check =s.execute(sqlQuery);
			 
		} catch (SQLException e) {
	      e.printStackTrace();
		 }
		return check;
	}

	@Override
	public GameEntity PlayerNameSearch(String playerName) {
		GameEntity ge=null;
		try {
			 Statement s=(Statement) connection.createStatement();
			 String sqlQuery="select * from gameData where playersName='"+playerName.toLowerCase()+"'";
			 ResultSet r =s.executeQuery(sqlQuery);
          // System.out.println();r.first());
          System.out.println("data level"+playerName.toLowerCase()+r);
			 if(r.next()){
				 System.out.println("data fw");
			 ge=new GameEntity(r.getString(2),r.getString(3).charAt(0), r.getInt(4), r.getInt(5), r.getString(6));
			 }
		} catch (SQLException e) {
	      e.printStackTrace();
		 }
		return ge;
	}

}
