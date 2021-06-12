package reading;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.TimerTask;

public class ReadingRoom extends TimerTask {
    private final int books;
    private final int seats;
    private final int readersInterval;
    private final int readingTime;
    private LinkedList<Reader> queue;
    private ArrayList<Integer> unavailableBooks;

    private int getRandom(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min) + min;
    }

    public ReadingRoom(int min, int max) {
        this.books = getRandom(min, max);
        this.seats = getRandom(min, max);
        this.readersInterval = getRandom(min, max);
        this.readingTime = getRandom(min, max);
    }

    @Override
    public String toString() {
        return   '\n' +
                "ReadingRoom{" +
                "books=" + books +
                ", seats=" + seats +
                ", readersInterval=" + readersInterval +
                ", readingTime=" + readingTime +
                '}';
    }

    @Override
    public void run() {

    }
}
