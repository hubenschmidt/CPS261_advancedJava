package Team;

/*
 * use generic types to restrict classes to using certain types. "Parameterization".
 */

import java.util.ArrayList;

class Player {
	String playerName;

	public Player(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerName() {
		return playerName;
	}

}

class FootballPlayer extends Player {
	public FootballPlayer(String playerName) {
		super(playerName);
	}
}

class BaseballPlayer extends Player {
	public BaseballPlayer(String playerName) {
		super(playerName);
	}
}

class HockeyPlayer extends Player {
	public HockeyPlayer(String playerName) {
		super(playerName);
	}
}

public class Team<T extends Player> {

	String teamName;
	ArrayList<T> players;
	int won;
	int lost;
	int gamePlayed;

	public void play(Team<T> otherTeam) {
		won++;
		gamePlayed++;

		otherTeam.lost++;
		otherTeam.gamePlayed++;
	}

	public Team(String teamName) {
		this.teamName = teamName;
		players = new ArrayList<>(); // she initializes inside constructor, but is this correct
	};

	public void addPlayer(T player) {
		players.add(player);
	}

	public void printPlayers() {
		for (T player : players) {
			System.out.println((player).getPlayerName());
		}
	}

	public static void main(String[] args) {
		HockeyPlayer hockeyPlayer = new HockeyPlayer("hockeyPlayer");
		BaseballPlayer baseballPlayer = new BaseballPlayer("baseballPlayer");
		Team<HockeyPlayer> hockeyTeam = new Team<>("hockeyTeam");
		Team<BaseballPlayer> baseballTeam = new Team("baseballTeam");
		hockeyTeam.addPlayer(hockeyPlayer);
//		hockeyTeam.addPlayer(baseballPlayer);
		hockeyTeam.printPlayers();
	}
}