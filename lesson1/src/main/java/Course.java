public class Course {

    Barrier[] barriers;

    public Course(Barrier[] barriers) {
        this.barriers = barriers;
    }

    void runObstacles(Team team){
        for (Barrier barrier: barriers){
           for (Player player: Team.players){
                barrier.overcome(player);
            }
        }
    }
}
