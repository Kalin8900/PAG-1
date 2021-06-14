package reading;

import java.util.Vector;
import java.util.LinkedList;
import java.util.Random;
import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;

public class ReadingRoom extends TimerTask {
//    private final int books;
//    private final int seats;
    private final int readersInterval;
    private final int readingTime;
//    private LinkedList<Reader> queue;
    private Vector<Integer> books;
    private Vector<Integer> seats;
    private Vector<Integer> reservedBooks;
    private Vector<Integer> reservedSeats;
    private BlockingQueue<Integer> queue;

    private int getRandom(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min) + min;
    }

    public ReadingRoom(int min, int max) {
        var booksNum = getRandom(min, max);

        for(var i = 0; i < booksNum; ++i)
            books.add(i);

        var seatsNum = getRandom(min, max);
        for(var i = 0; i < seatsNum; ++i)
            seats.add(i);

        this.readersInterval = getRandom(min, max);
        this.readingTime = getRandom(min, max);
    }

    public void start() {
        while (true) {
            
        }
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
