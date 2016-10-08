import org.moeaframework.problem.tsplib.TSPInstance;
import org.moeaframework.problem.tsplib.DistanceTable;
import org.moeaframework.problem.tsplib.Tour;
import gaframework.*;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException{
	// Cargar los datos de problema:
	TSPInstance prob = new TSPInstance(new File("data/tsp/burma14.tsp"));
	// Imprimir la información del problema:
	System.out.println(prob.getName());
	System.out.println(prob.getComment());
	System.out.println("Numero de nodos: " + prob.getDimension());
	int dimension = prob.getDimension();
	IntInteger bini = new IntInteger(dimension);
	MinFun mf = new MinFun(prob);
	OnePointCrossover<Integer> opc = new  OnePointCrossover<>(1,0.01);
	 UniformMutation um = new UniformMutation(0.01,1,dimension);
	 Ruleta<Integer,Integer> ru = new Ruleta<>(1,100);
	 NumGeneraciones ng = new NumGeneraciones(200);
        Simple<Integer,Integer> sim = new Simple<>(bini, null, opc, um, ru, mf, null, ng, 200);
        sim.run(); 
//       gaframeworkgui.GAGUI.setGA(sim);
//       gaframeworkgui.GAGUI.launch(gaframeworkgui.GAGUI.class);
    }
}
