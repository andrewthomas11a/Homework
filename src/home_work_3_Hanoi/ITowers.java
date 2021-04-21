package home_work_3_Hanoi;

public interface ITowers {
    byte getMovesCount();

    void moveRings(byte[][] arr);

    void ringsMoving(byte[][] arr, int rodFrom, int rodTo);

    byte findUpperRing(byte[][] arr, byte rodNumber);

    byte checkInputRodNumber(byte[][] arr);
}
