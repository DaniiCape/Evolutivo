import gaframework.*;
import java.util.*;
public class MinFun implements FitnessFunction<Integer>{

    private double[] vertices;
    
    public MinFun(double[] vertices){
    	this.vertices=vertices;
    }

    private double peso(int a , int b){
	double x1 = (this.vertices[(a*2)-2]);
	double y1 = (this.vertices[(a*2)-1]);
	double x2 = (this.vertices[(b*2)-2]);
	double y2 = (this.vertices[(b*2)-1]);
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
	
	double v =Math.sqrt( ((x1-x2)*(x1-x2))+((y1-y2)*(y1-y2)) );
	return v;
	
    } 

    public double evaluate(Phenotype<Integer> p ){
	double fit =0;
	for(int i=0;i<p.size();i++){
	    int a = p.getAllele(i).intValue();
	    int b = p.getAllele(0).intValue();
	    if(i+1<p.size())
		b = p.getAllele(i+1).intValue();
	    fit = fit + peso(a,b);
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
	double[] v =new double[10];
	for(int i =0;i<10;i++)
	    v[i]=i;
        System.out.println(p);
	MinFun m = new MinFun(v);
	
	System.out.println(m.evaluate(p));
    }
   
}
