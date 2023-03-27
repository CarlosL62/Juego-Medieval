
package com.train.train;

public class Train {

    private Wagon[] wagons;
    private Principal principal;
    private int position =0;

    public Train(Principal principal, int i) {
        this.principal = principal;
        wagons = new Wagon[4];
        wagons[0] = new PayLoadWagon(4);
        wagons[1] = new PassengerWagon(2);
        wagons[2] = new PayLoadWagon(4);
        wagons[3] = new Principal(2, new Engine(0));

    }

    public int getPosition() {
        return position;
    }

    public String paint() {
        String res = "";
        for (int i = 0; i < wagons.length; i++) {
            res+=wagons[i].getChar();
        }
        res+="P";
        return res;
    }

    public void accelerate() {
        int power = principal.getTorque() - getResistence();

        if (power >0)        {
            System.out.println("nos movenos");
            position+=power;
        }
        else{
            System.out.println("no se mueve");
        }
    }

    private int getResistence(){
        int total = 0;
        for (int i = 0; i < wagons.length; i++) {
            total+=wagons[i].getMovementResistence();
        }
        total+=principal.getMovementResistence();
        return total;
    }

    public void stop() {
        System.out.println("no nos movemos");
    }

    public void whistle() {
        System.out.println("*******************");
        System.out.println("     chu chu     ");
        System.out.println("*******************");
    }

}
