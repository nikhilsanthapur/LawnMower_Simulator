import java.util.ArrayList;
import java.util.List;

class LawnMower {
    private MowerState state;
    private List<MowerObserver> observers;
    private int i, j, n, m;
    public LawnMower(int i, int j, int n, int m) {
        this.i = i;
        this.j = j;
        this.n = n;
        this.m = m;

        state = new EastState(this);

        observers = new ArrayList<>();
    }

    public void setState(MowerState state) {
        this.state = state;
    }

    public MowerState getState() {
        return state;
    }

    public void move() {
        state.move();
        notifyObservers();
    }

    public void incrementI() {
        if (i < n - 1) {
            i++;
        }
    }

    public void incrementJ() {
        if (j < m - 1) {
            j++;
        }
    }

    public void decrementJ() {
        if (j > 0) {
            j--;
        }
    }

    public boolean edgeReached() {
        return j == 0 || j == m - 1 || i == n - 1;
    }

    public void attach(MowerObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (MowerObserver observer : observers) {
            observer.update(i, j);
        }
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }
}

