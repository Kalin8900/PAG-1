import java.util.*;

public class RNG {

    private int max;
    private int n;
    private int target;

    public RNG(int max, int n, int s) {
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

    public ArrayList<int>() generate {
        Random rand = new Random();
        var numbers = new ArrayList<int>();
        for(int i = 0; i < this.n; ++i) {
            int cur = rand.nextInt(this.max);
            numbers.add(cur);
            if (cur == this.target)
                break;
        }

        return numbers;
    }

    public void out() {
        var arr = this.generate()

        int amount = this.n > arr.size() ? arr.size() : this.n;

        for (int i = 0; i < amount; ++i)
            System.out.println(arr[i]);
        for (int i = arr.size(); i > arr.size() - amount; --i)
            System.out.println(arr[i]);

        Set<T> set = new LinkedHashSet<>();
        set.addAll(arr);
        Collections.sort(set);
        for (const var elem : set)
            System.out.println(elem);
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