class EastState implements MowerState {
    private LawnMower mower;
    public EastState(LawnMower mower) {
        this.mower = mower;
    }

    @Override
    public void move() {
        if (mower.getJ() < mower.getM() - 1) {
            mower.incrementJ();
        } else {
            mower.setState(new SouthEastState(mower));
        }
        mower.notifyObservers();
    }
}
