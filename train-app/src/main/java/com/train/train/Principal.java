
package com.train.train;

public class Principal extends Wagon {
    private Engine engine;

    public Principal(int resistence, Engine engine) {
        super(resistence);
        this.engine = engine;
    }

    public int getTorque() {
        return engine.getTorque();
    }

    @Override
    public String getChar() {
        return "m";
    }

}
