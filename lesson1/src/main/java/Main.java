public class Main {
    public static void main(String[] args) {
        Player [] players = {
                new Cat("Васька", 90, 3),
                new Cat("Рыжик", 100, 8),
                new Robot("Боб", 40, 5),
                new Human("Миша", 180, 15),
                new Human("Саша", 200, 13),
        };

        Barrier[] barriers = {
                new Track(100),
                new Wall(5),
                new Track(200)
        };

        for (Barrier barrier: barriers){
            for (Player player: players){
                barrier.overcome(player);
            }
        }

        System.out.println("====Успешно финишировали=====");

        for (Player player : players) {
            if (player.isPlay()){
                System.out.println(player);
            }
        }
    }
}
