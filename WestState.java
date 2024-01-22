class WestState implements MowerState {
    private LawnMower mower;


    public WestState(LawnMower mower) {
        this.mower = mower;
    }

    @Override
    public void move() {
        if (mower.getJ() > 0) {
            mower.decrementJ();
        } else {
            mower.setState(new SouthWestState(mower));
        }
        mower.notifyObservers();
    }
}
