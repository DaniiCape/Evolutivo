import gaframework.*;
import java.util.*;


/**
  *Clase que implementa la interfaz Corrector, la cual verifica que se cumplan las condiciones del agente viajero, ie, que la ciudad inicial y final sean la misma, y que no se repitan ciudades.
  */


public class CAgenteViajero implements Corrector<Integer>{

    private int inicial; //El numero correspondiente a la ciudad inicial
    private int tamGen;  //Tamaño del genotipo
    private Integer[] cuenta; //Auxiliar para contar

    public CAgenteViajero (int i, int tamGen){
	this.inicial = i;
	this.tamGen = tamGen;
    }

    public Genotype<Integer> repairGenotype(Genotype<Integer> g){
	int gz = g.size();
	Genotype<Integer> cout = new Genotype<Integer>(gz);
	cuenta = new Integer[tamGen];
	this.cuenta[tamGen-1] = this.inicial;
     	for(int j=0; j<gz-1; j++){
	    boolean p = esta(g.getGene(j));
	    //System.out.println(g.getGene(j));
	    //System.out.println(p);
	    if(!p){
	    	this.cuenta[j] = g.getGene(j);
            }
        }
	    
	for(int h=0; h<gz; h++){
           Integer out = new Integer(-1);
           if (cuenta[h] == null)
              this.cuenta[h] = out;
	   //System.out.print(cuenta[h]);
        }
	//System.out.println("Primer for");
	for(int i =0; i<gz-1; i++){
	     if(this.cuenta[i].intValue() == -1){
		cuenta[i] = buscaInt();
	     }
	}
	
	for(int m=0; m<gz; m++){
            //System.out.println(cuenta[m]);
	    cout.setGene(m, cuenta[m]);
	}
	return cout;	
    }

    public Integer buscaInt (){
	Random r = new Random();
	while(true){
          int k = r.nextInt(this.tamGen);
	  Integer out = new Integer(k);
	  if(!esta(out))
	     return out;
        }
	
	
    }

    public boolean esta(Integer b){
       for(int j =0; j<this.tamGen; j++){
          if(this.cuenta[j] != null && this.cuenta[j].intValue()== b.intValue()){
             //System.out.print(this.cuenta[j]);
	     return true;
          }
       }
       return false;
       		
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
