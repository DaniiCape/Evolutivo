import gaframework.*;
import java.util.*;

public class IntString implements Codification<Integer,String>{
    //Tamaño de genotipo
    private final int numGen;
    //Tamaño de fenotipo
    private final int numFen;

    private List<Integer> c;
    //Constructor que inicializa el tamanio
    public IntString(int f, int g){
	this.numGen = g;
	this.numFen = f;
    }

    public Genotype<Integer> encode (Phenotype<String> p){
	Genotype<Integer> out = new Genotype<>(numGen);
	c =new ArrayList<>();
	for(int i=1;i<this.numGen+1;i++){
	    c.add(i);
	}
	for(int i=0;i<p.size();i++){
	    
	}
    }

    public Phenotype<String> decode(Genotype<Integer> genotype){
	Phenotype<String> out = new Phenotype<>(this.numFen);
	c =new ArrayList<>();
	for(int i=1;i<this.numFen+1;i++){
	    c.add(i);
	}
	for(int i=0;i<genotype.size();i++){
	    int gen = genotype.getGene(i).intValue();
	    int phen = c.get(gen);
	    System.out.println(c);
	    System.out.println(phen);
	    c.remove(gen);   
	    out.setAllele(i,"C"+phen);
	}
	return out;
    }

    public Genotype<Integer> newRandomGenotype(){
	Genotype<Integer> out = new Genotype<>(this.numGen);
	int t = this.numGen;
	Random r = new Random();
	for(int i =0; i<this.numGen; i++){
	    int r1 = r.nextInt(t);
	    out.setGene(i,r1);
	    t--;
	}
	return out;
    }

    public static void main (String[] args){
	IntString i = new IntString(5,5);
	Genotype<Integer> g = i.newRandomGenotype();
	System.out.println(g);
	Phenotype<String> p = i.decode(g);
	System.out.println(p);
    }
}
