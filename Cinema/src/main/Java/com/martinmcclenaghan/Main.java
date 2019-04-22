package Java.com.martinmcclenaghan;

//https://www.codewars.com/kata/562f91ff6a8b77dfe900006e

public class Main {

    public static void main(String[] args) {

        int card = 500;
        int normalTicket = 15;
        double percentage = 0.9;

        System.out.println(movie(card, normalTicket, percentage));


    }

    public static int movie(int card, int ticket, double perc) {

        int i = 0;
        double normalTicket = 0;
        double specialTicket = card;

        //use Math.ceil as challenge states "when rounded up to the next dollar"

        while (Math.ceil(specialTicket) >= normalTicket) {

            i++;
            normalTicket = ticket * i;
            specialTicket += (ticket * Math.pow(perc, i));

        }

        return i;
    }
}

