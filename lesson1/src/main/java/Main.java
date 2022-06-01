public class Main {
    public static void main(String[] args) {

        Course course = new Course(new Barrier[]{
                new Track(100),
                new Wall(5),
                new Track(200)});

        Team team = new Team("Шустрик", new Player[]{
                new Cat("Васька", 50, 4),
                new Cat("Барсик", 100, 2),
                new Robot("Боб", 60, 3),
                new Human("Иван", 150, 5)});

        course.runObstacles(team);
        team.resultInfo();
    }
}
