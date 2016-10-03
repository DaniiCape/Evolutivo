import java.util.*;
import gaframework.*;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class Main{
    
    public static void main(String args[]){
	List<Double> l = new ArrayList<>();
	try(Scanner sc = new Scanner(new File("burma14.txt"))){
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
	double[] v =l.toArray(new double[l.size()]);

	
	IntInteger bini = new IntInteger(v.length/2);
	CAgenteViajero c = new CAgenteViajero(1,v.length/2);
	MinFun min = new MinFun(v);
	 OnePointCrossover one = new  OnePointCrossover(1,0.01);
	 UniformMutation<Integer> uni = new UniformMutation<>(0.01,1,v.length/2);
	 Ruleta<Integer,Integer> r = new Ruleta<>(1,100);
	 NumGeneraciones<Integer,Integer> gen = new NumGeneraciones<>(100);
	 
// 	Simple<Boolean,Integer> sim = new Simple<>(bini, null, opc, um, ru, mf, null, ng, 1000);
// 	gaframeworkgui.GAGUI.setGA(sim);
// 	gaframeworkgui.GAGUI.launch(gaframeworkgui.GAGUI.class);
    }
}
