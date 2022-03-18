import java.util.*;
import java.lang.Math;

public class dice {
    public static void main(String[] args) {
        System.out.println("Ciao! Questo è un semplice programma che calcola quanti lanci di dati servono\nper raggiungere statisticamente la probabilità classica di 1/6 per ogni numero");
        System.out.println("Questo programma calcola il numbero di lanci necessari per stare entro un certo range di precisione usando la media di 100 tentativi per ogni range\n");
        //var declaration
        int d, f[], i, done;
        Random rand = new Random();
        double rapp, min, max, diff, tot;
        //standard pox of each number on a dice
        double stat = 0.166667;
        for (int j = 1; j<5; j++){
            //setting precision
            diff = Math.pow(0.1,j);
            min = stat - diff;
            max = stat + diff;
            System.out.println("Cerchiamo una probabilità compresa tra " + min + " e " + max);

            tot = 0;
            for (int l = 0; l < 100; l++){
                done = 0;
                i = 0;
                f = new int[6];
                for (int p = 0; p < 6; p++)
                    f[p] = 0;
                //while cicle: roll one dice each loop
                while (done < 5){
                    //counting how many times dice has been rolled
                    i++;
                    done = 0;
                    //dice rolling
                    d = rand.nextInt(6);
                    f[d]++;
                    //checking probability
                    for (int k = 0; k < 5; k++){
                        rapp = (float)f[k]/i;
                        if (rapp > min && rapp < max)
                            done++;
                    }
                }
                tot = tot + i;
                System.out.print(l + " ");
            }
            System.out.println ("Ho dovuto lanciare mediamente " + tot/100 + " dadi\n");
        }
    }
}