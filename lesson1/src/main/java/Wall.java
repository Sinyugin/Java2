public class Wall implements Barrier {
    private  int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void overcome(Player player) {
        player.jump(this);

    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Стена высотой " + height + "метров";
    }
}
