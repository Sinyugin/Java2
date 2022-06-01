public class Human implements Player {

    private final String name;
    private final int runLimit;
    private final int jumpLimit;
    private boolean play;

    public Human(String name, int runLimit, int jumpLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
        this.play = true;
    }

    @Override
    public void setPlay(boolean play) {

    }

    @Override
    public int getJumpLimit() {
        return jumpLimit;
    }

    @Override
    public int getRunLimit() {
        return runLimit;
    }

    @Override
    public boolean isPlay() {
        return play;
    }

    @Override
    public String toString() {
        return "Человек по имени " + name;
    }
}
