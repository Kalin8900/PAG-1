import java.io.*;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class RowConverter {
    private ArrayList<String> numbers;

    public RowConverter() {
        this.numbers = new ArrayList<String>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RowConverter that = (RowConverter) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return "RowConverter{" +
                "numbers=" + numbers +
                '}';
    }

    private static ArrayList<String[]> readDataFromFile(String path) {
        if (path.isEmpty())
            throw new InvalidPathException(path, "Path length must be greater than 0");
        var argsArr = new ArrayList<String[]>();
        var file = new File(path);
        if (!file.isFile())
            throw new InvalidPathException(path, "Couldn't find file from given path");

        try {
            var s = new Scanner(file);
            while (s.hasNextLine()) {
                String data = s.nextLine();
                String[] token = data.split(" ");
                argsArr.add(token);
            }
        } catch (IOException e) {
            System.out.println("Error occurred when loading the file from path " + path);
            e.printStackTrace();
        }
        return argsArr;
    }

    public String getIndex(int index) {
        if(index > -1 && index < this.numbers.size())
            return this.numbers.get(index);
        throw new IndexOutOfBoundsException("Index out of bounds");
    }

    public void read(String fileName) {
        var path = System.getProperty("user.dir") + "/data/" + fileName;

        var file = new File(path);
        if (!file.isFile())
            throw new InvalidPathException(path, "Couldn't find file from given path");

        try {
            this.numbers.clear();
            var s = new Scanner(file);
            while (s.hasNext()) {
                this.numbers.add(s.next());
            }
        } catch (IOException e) {
            System.out.println("Error occurred when loading the file from path " + path);
            e.printStackTrace();
        }
    }

    public void read(File file) throws IOException {
        if (!file.isFile())
            throw new IOException("Couldn't find file");

        try {
            this.numbers.clear();
            var s = new Scanner(file);
            while (s.hasNext()) {
                this.numbers.add(s.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(String fileName) throws IOException {
        var path = System.getProperty("user.dir") + "/data/" + fileName;
        File out = new File(path);
        FileOutputStream fos = new FileOutputStream(out);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        for (int i = 0; i < this.numbers.size(); ++i) {
            bw.write(this.getIndex(i));
            bw.newLine();
        }
        bw.close();
    }

    public void write(File file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        for (int i = 0; i < this.numbers.size(); ++i) {
            bw.write(this.getIndex(i));
            bw.newLine();
        }
        bw.close();
    }
}
