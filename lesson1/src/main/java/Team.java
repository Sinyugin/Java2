public class Team {
   public String teamName;

    public static Player [] players;

    public Team(String teamName,  Player[] players) {
        this.teamName = teamName;
        this.players = players;
    }

    void resultInfo(){
        System.out.println("==== Успешно финишировали =====");
        for (Player player : players) {
            if (player.isPlay()){
                System.out.println(player + " из команды " + teamName);
            }
        }
    }
}
