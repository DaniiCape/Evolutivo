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

    public Genotype<Boolean> mutate(Genotype<Integer> g){
	Genotype<Boolean> out = new Genotype<>(g.size());
        Random r2 = new Random();
	for(int i=0; i<g.size();i++){
	    if(r.nextDouble()< this.prob){
	        int rm = r2.nextInt(tamGen);
                Integer iout = new Integer(rm);
		out.setGene(i, iout);
	    }else{
		out.setGene(i,g.getGene(i));
	    }
	}
	return out;

    }
} 
