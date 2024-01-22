class SouthWestState implements MowerState {
    private LawnMower mower;

    public SouthWestState(LawnMower mower) {
        this.mower = mower;
    }

    @Override
    public void move() {
        if (mower.edgeReached()) {
            mower.incrementI();
            mower.setState(new EastState(mower));
        } else {
            mower.decrementJ();
        }
    }
}
