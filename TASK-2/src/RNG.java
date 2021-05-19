import java.util.*;

public class RNG {

    private int max;
    private int n;
    private int target;

    public RNG(int max, int n, int s) {

        if(s > max || s < 0)
            throw new IllegalArgumentException("Stop number must be a positive number less than Max");

        if(max <= 0)
            throw new IllegalArgumentException("Max must be positive");

        if(n < 0)
            throw new IllegalArgumentException("The amount of values to print must be a positive number");

        this.max = max;
        this.n = n;
        this.target = s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RNG rng = (RNG) o;
        return getMax() == rng.getMax() && getN() == rng.getN() && getTarget() == rng.getTarget();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMax(), getN(), getTarget());
    }

    public ArrayList<Integer> generate() {
        Random rand = new Random();
        var numbers = new ArrayList<Integer>();
        int cur;
        do {
            cur = rand.nextInt(this.max);
            numbers.add(cur);
        } while(cur != this.target);

        return numbers;
    }

    public void out() {
        var arr = this.generate();

        int amount = Math.min(this.n, arr.size());

        System.out.print("Raw: ");
        for (var elem : arr)
            System.out.print(elem.toString() + ' ');

        System.out.println(' ');

        System.out.print("From start: ");
        for (int i = 0; i < amount; ++i)
            System.out.print(arr.get(i).toString() + ' ');

        System.out.println(' ');

        System.out.print("From end: ");
        for (int i = arr.size() - 1; i > arr.size() - amount - 1; --i)
            System.out.print(arr.get(i).toString() + ' ');

        System.out.println(' ');

        Set<Integer> set = new TreeSet<>(arr);
        System.out.print("Sorted, without duplicates: ");
        for (var elem : set)
            System.out.print(elem.toString() + ' ');

        System.out.println(' ');
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }
}