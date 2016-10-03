import gaframework.*;
import java.util.*;

public class IntInteger implements Codification<Integer,Integer>{
    //Tamaño de genotipo
    private final int numGen;
    //Tamaño de fenotipo
    private final int numFen;

    private List<Integer> c;
    //Constructor que inicializa el tamanio
    public IntInteger(int tam){
	this.numGen = tam;
        this.numFen = tam;
    }

    public Genotype<Integer> encode (Phenotype<Integer> phenotype){
	Genotype<Integer> out = new Genotype<>(numGen);
	c  =new ArrayList<>();
	for(int i=1;i<this.numGen+1;i++){
	    c.add(i);
	}
	for(int i=0;i<phenotype.size();i++){
	    int phen = phenotype.getAllele(i);
	    int gen = c.indexOf((Integer)phen);
	    c.remove((Integer)phen);
	    out.setGene(i,gen);
	}
	return out;
    }

    public Phenotype<Integer> decode(Genotype<Integer> genotype){
	Phenotype<Integer> out = new Phenotype<>(this.numFen);
	c =new ArrayList<>();
	for(int i=1;i<this.numFen+1;i++){
	    c.add(i);
	}
	for(int i=0;i<genotype.size();i++){
	    int gen = genotype.getGene(i).intValue();
	    //System.out.println("Imprimiendo gen" + String.valueOf(gen));
	    int phen = c.get(gen);
	    //c.remove(gen); 
            Integer ph = new Integer(phen);  
	    out.setAllele(i,ph);
	}
	return out;
    }

    public Genotype<Integer> newRandomGenotype(){
	Genotype<Integer> out = new Genotype<>(this.numGen);
	int t = this.numGen;
	Random r = new Random();
	for(int i =0; i<this.numGen; i++){
	    int r1 = r.nextInt(t);
            Integer inte = new Integer(r1);
	    out.setGene(i,inte);
	    //t--;
	}
	return out;
    }

    public static void main (String[] args){
	IntInteger i = new IntInteger(5);
	Genotype<Integer> g = i.newRandomGenotype();
	System.out.println(g);
	Phenotype<Integer> p = i.decode(g);
	System.out.println(p);
        g = i.encode(p);
	System.out.println(g);
    }
}
