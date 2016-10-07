import java.util.*;
import gaframework.*;
import org.moeaframework.problem.tsplib.*;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class Main{
    
    public static void main(String args[]){
	/**ArrayList<Double> l = new ArrayList<Double>();
	try(Scanner sc = new Scanner(new File("uli.txt"))){
	    while(sc.hasNextLine()){
		String line =  sc.nextLine();
		///System.out.println(line);
		String[] words = line.split(" ");
		//System.out.println(words.length);
		for(int i=0;i<words.length;i++){
		    l.add(Double.parseDouble(words[i]));
		    //System.out.println(words[i]);
		}
		
	    }
	}catch(IOException e){
	    
	}
	double[] v = new double[l.size()];
	for(int i = 0;i<v.length;i++){
		v[i] = l.get(i).doubleValue();
	}

	
	IntInteger bini = new IntInteger(v.length/2);
        System.out.println(v.length/2);
	//CAgenteViajero c = new CAgenteViajero(0,v.length/2);
	MinFun mf = new MinFun(v);
	 OnePointCrossover<Integer> opc = new  OnePointCrossover<>(1,0.01);
	 UniformMutation um = new UniformMutation(0.01,1,v.length/2);
	 Ruleta<Integer,Integer> ru = new Ruleta<>(1,100);
	 NumGeneraciones ng = new NumGeneraciones(200);
	 
	Simple<Integer,Integer> sim = new Simple<>(bini, null, opc, um, ru, mf, null, ng, 200);
	//sim.run(); 	
	gaframeworkgui.GAGUI.setGA(sim);
 	gaframeworkgui.GAGUI.launch(gaframeworkgui.GAGUI.class);**/
 	
 	//TSPProblem problem = new TSPProblem(new File("./data/tsp/pcb442.tsp"));
       // problem.addTour(new File("./data/tsp/pcb442.opt.tour"));
        Tour t = new Tour();
        //for (Tour tour : problem.getTours()) {
           // System.out.println(tour.distance(problem));
        //}
    }
}
