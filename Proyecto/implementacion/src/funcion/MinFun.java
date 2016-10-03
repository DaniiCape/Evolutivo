import gaframework.*;
import java.util.*;
public class MinFun implements FitnessFunction<Integer>{

    private double[] vertices;
    
    public MinFun(double[] vertices){
    	this.vertices=vertices;
    }

    public double peso(int a , int b){
	double x1 = this.vertices[a-1];
	double y1 = this.vertices[a];
	double x2 = this.vertices[b-1];
	double y2 = this.vertices[b];
	if(x1<x2){
	    x1 = x1 + x2;
	    x2 = x1 - x2;
	    x1 = x1 - x2;
	}

	if(y1<y2){
	    y1 = y1 + y2;
	    y2 = y1 - y2;
	    y1 = y1 - y2;
	}
	return (Math.abs(x1-x2)+Math.abs(y1-y2));
	
    } 

    public double evaluate(Phenotype<Integer> p ){
	double fit =0;
	for(int i=0;i<p.size();i++){
	    int a = p.getAllele(i).intValue();
	    int b = p.getAllele(0).intValue();
	    if(i+1<p.size())
		b = p.getAllele(i+1).intValue();
	    System.out.println("("+a+","+b+")");
	}
	return fit;
	    
    }

    public static void main (String[] args){
	Phenotype<Integer> p = new Phenotype<>(5);
	p.setAllele(0,5);
	p.setAllele(1,4);
	p.setAllele(2,3);
	p.setAllele(3,2);
	p.setAllele(4,1);
	MinFun m = new MinFun(new double[10]);
	m.evaluate(p);
    }
}
