import gaframework.*;
public class MaxFun implements FitnessFunction<Integer>{
    public double evaluate(Phenotype<Integer> p ){
	int x = p.getAllele(0).intValue();
	//System.out.println(x);
	return x * (1024-x);
   }
}
