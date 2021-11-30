package DataBase;
import java.util.List;

//edo ilopoioume to dao pattern
public class PlayerDaoImplementation{

    private  List<Player> players;

    public PlayerDaoImplementation(List<Player> players) {
        this.players = players;
    }

    //pairnoume olous tou paiktes poy iparxoyn stin lista Player
    public  List<Player> getAllPlayers() {
        return this.players;
    }

   //pairnoume ena sigkekrimeno paikti analoga me to name
    public Player getSpecificPlayer(String name) {
        for (Player player : players) {
            if (name.equals(player.getName())) {
                return player;
            }
        }
        return null;
    }

}

