import gaframework.*;
import java.util.*;

public class BinInteger implements Codification<Boolean,Integer>{
    //Tamaño de genotipo
    private final int numGen;
    //Tamaño de fenotipo
    private final int numFen;
    //Constructor que inicializa el taman
    public BinInteger(int f, int g){
	this.numGen = f;
	this.numFen = g;
    }

    public Genotype<Boolean> encode (Phenotype<Integer> p){
	Genotype<Boolean> out = new Genotype<>(numGen);
	int bin = p.getAllele(0).intValue();
	for(int i=numGen-1; i>=0; i--){
	    int modu = bin%2;
	    bin = bin/2;
	    if(modu == 1){
		out.setGene(i,true);
	    }else{
		out.setGene(i,false);
	    }
	}
	return out;
    }

    public Phenotype<Integer> decode(Genotype<Boolean> genotype){
	Phenotype<Integer> out = new Phenotype<>(numFen);
	int tg = genotype.size();
	int ph =0;
	int pw = 0;
	for(int i=tg-1; i>=0; i--){
	    boolean b = genotype.getGene(i);
	    int n = 0;
	    if(b){
		ph = ph + (int)Math.pow(2,pw);
	    }else{
		
	    }
	    
	    pw++;
	    
	}    
	//System.out.println(ph);
	out.setAllele(0,ph);
	return out;
    }

    public Genotype<Boolean> newRandomGenotype(){
	Genotype<Boolean> out = new Genotype<>(numGen);
	Random r = new Random(1);
	for(int i =0; i<numGen; i++){
	    int r1 = r.nextInt();
	    if(r1>0){
		out.setGene(i,true);
	    }else{
		out.setGene(i,false);
	    }
	}
	return out;
    }
}
