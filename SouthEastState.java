class SouthEastState implements MowerState {
    private LawnMower mower;
    public SouthEastState(LawnMower mower) {
        this.mower = mower;
    }

    @Override
    public void move() {
        if (mower.edgeReached()) {
            mower.incrementI();
            mower.setState(new WestState(mower));
        } else {
            mower.incrementJ();
        }
    }
}
