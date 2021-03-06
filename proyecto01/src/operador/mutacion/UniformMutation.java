import gaframework.*;
import java.util.Random;

/**
 *Clase que realiza la mutación.
 *El tipo de mutacion es uniforme, si el gen tiene que cambiar
 *se elige un numero random y asi es la mutacion para cada gen
 */

public class UniformMutation implements MutationOp<Integer>{
    private double prob;
    private Random r;
    private int tamGen;

    public UniformMutation(double prob, int seed, int tamGen){
	this.prob = prob;
	r = new Random(seed);
        this.tamGen = tamGen;
    }

    public Genotype<Integer> mutate(Genotype<Integer> g){
	Genotype<Integer> out = new Genotype<>(g.size());
        Random r2 = new Random();
	int m = tamGen;
	for(int i=0; i<g.size();i++){
	    double r3 = r.nextDouble();
	    //System.out.println(r3);
	    if(r3 < this.prob){
	        int rm = r2.nextInt(m-i);
                Integer iout = new Integer(rm);
		out.setGene(i, iout);
	    }else{
		out.setGene(i,g.getGene(i));
	    }
	}
	return out;

    }

public static void main (String[] args){
    UniformMutation um = new UniformMutation(.9, 1, 5);
    Genotype<Integer> g = new Genotype<Integer>(5);
	Random r = new Random();
	for(int i=0; i<5; i++){
	    int ra = r.nextInt(5);
	    //System.out.println(ra);
	    Integer in = new Integer(ra);
	    //System.out.println(in);
	    g.setGene(i,in);
	}
	System.out.println(g);
	Genotype<Integer> rg = um.mutate(g);
	System.out.println(rg);	    
    
 }
} 
