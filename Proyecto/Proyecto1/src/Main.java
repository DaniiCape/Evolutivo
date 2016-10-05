import java.util.*;
import gaframework.*;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class Main{
    
    public static void main(String args[]){
	ArrayList<Double> l = new ArrayList<Double>();
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
	Double[] v = l.toArray(new Double[l.size()]);

	
	IntInteger bini = new IntInteger(v.length/2);
	CAgenteViajero c = new CAgenteViajero(1,v.length/2);
	MinFun mf = new MinFun(v);
	 OnePointCrossover<Integer> opc = new  OnePointCrossover<>(1,0.01);
	 UniformMutation um = new UniformMutation(0.01,1,v.length/2);
	 Ruleta<Integer,Integer> ru = new Ruleta<>(1,100);
	 NumGeneraciones ng = new NumGeneraciones(200);
	 
	Simple<Integer,Integer> sim = new Simple<>(bini, c, opc, um, ru, mf, null, ng, 200);
 	gaframeworkgui.GAGUI.setGA(sim);
 	gaframeworkgui.GAGUI.launch(gaframeworkgui.GAGUI.class);
    }
}