public enum Type {DOG(12), CAT(15), RABBIT(9), IGUANA(13);
    private double lifespan;
    private Type(double lifespan) {
        this.lifespan = lifespan;
    }
    public double lifespan() {
        return this.lifespan;
    }
}

