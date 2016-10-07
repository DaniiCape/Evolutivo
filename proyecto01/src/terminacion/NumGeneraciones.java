import gaframework.*;
import java.util.*;

public class NumGeneraciones implements TerminationCondition<Integer,Integer>{
    private int numGen;
    
    public NumGeneraciones(int numGen){
	this.numGen = numGen;
    }

    public boolean conditionReached(Population<Integer,Integer> p){
	return p.getGeneration()>=numGen;
    }
}
