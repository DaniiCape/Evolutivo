import gaframework.*;
import java.util.*;
import org.moeaframework.problem.tsplib.TSPInstance;
import org.moeaframework.problem.tsplib.DistanceTable;
import org.moeaframework.problem.tsplib.Tour;
import java.io.File;
import java.io.IOException;
public class MinFun implements FitnessFunction<Integer>{
    private TSPInstance datos;
    public MinFun(TSPInstance datos){
        this.datos = datos;
    }
    
    public double evaluate(Phenotype<Integer> p ){
	int[] phen = new int[p.size()];
	for(int i=0;i<p.size();i++)
            phen[i]=p.getAllele(i);
        Tour t  = Tour.createTour(phen);
        double out =10000-t.distance(this.datos);
        return out;
    }
   
}
