public interface Player {

    int getJumpLimit();
    void setPlay(boolean play);
    int getRunLimit();
    boolean isPlay();

    default void jump(Wall wall){
        if (isPlay()){
            if (getJumpLimit() >= wall.getHeight()){
                System.out.println(this + " успешно преодолел " + wall);
            } else {
                System.out.println( this + " не прошел препятствие " + wall);
                setPlay(false);
            }
        }
    };

    default void run(Track track){
        if (isPlay()){
            if (getRunLimit() >= track.getLength()){
                System.out.println(this + " успешно преодолел" + track);
            } else {
                System.out.println( this + " не прошел препятствие" + track);
                setPlay(false);
            }
        }
    };
}
