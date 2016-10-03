import gaframework.*;
import java.util.*;

/**
  *Clase que implementa la interfaz Corrector, la cual verifica que se cumplan las condiciones del agente viajero, ie, que la ciudad inicial y final sean la misma, y que no se repitan ciudades.
  */


public class CAgenteViajero implements Corrector<Integer>{

    private int inicial; //El numero correspondiente a la ciudad inicial
    private int tamGen;  //Tamaño del genotipo
    private Integer [] cuenta; //Auxiliar para contar

    public CAgenteViajero (int i, int tamGen){
	this.inicial = i;
	this.tamGen = tamGen;
    }

    public Genotype<Integer> repairGenotype(Genotype<Integer> g){
	int gz = g.size();
	Genotype<Integer> cout = new Genotype<Integer>(gz);
	cuenta = new Integer[gz];
	cuenta[gz-1] = inicial;
	for(int j=0; j<gz-1; j++){
	    if(cuenta[j] == null && cuenta[j]!=inicial)
		cuenta[j] = g.getGene(j);
	        System.out.print(cuenta[j]);
	}
	for(int i =0; i<gz-1; i++){
	    if(cuenta[i]== null){
		Integer k = buscaInt();
		cuenta[i] = k;
	    }
	}
	for(int m=0; m<gz; m++){
	    cout.setGene(m, cuenta[m]);
	}
	return cout;	
    }

    public Integer buscaInt (){
	Random r = new Random();
	int k = 0;
	int i = 0;
	while(k!=1){
	    int j= r.nextInt(tamGen-1);
	    if(cuenta[j]==null){
		i = j;
                
		
	    }
	}
	Integer out = new Integer(i);
	return out;
    }

    public static void main (String[] args){
	CAgenteViajero c = new CAgenteViajero(3, 5);
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
	Genotype<Integer> rg = c.repairGenotype(g);
	System.out.println(rg);	    
    }

}