import java.util.*;
import gaframework.*;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class Main{
    
    public static void main(String args[]){
	List<Double> l = new ArrayList<>();
	int tam;
	
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
	Double[] v =l.toArray(new Double[l.size()]);
	for(int i=0;i<v.length;i++){
	    System.out.println(v[i]);
	}
	System.out.println(v);
	//System.out.println(l);

	//BinInteger bini = new BinInteger(10,1);
	//Ruleta<Boolean,Integer> ru = new Ruleta<>(1,2);
	//UniformMutation um = new UniformMutation(.001,1);
	//OnePointCrossover<Boolean> opc = new OnePointCrossover<>(1,.001);
	//NumGeneraciones ng = new NumGeneraciones(200);
	//MaxFun mf = new MaxFun();
	//Simple<Boolean,Integer> sim = new Simple<>(bini, null, opc, um, ru, mf, null, ng, 1000);
	//gaframeworkgui.GAGUI.setGA(sim);
	//gaframeworkgui.GAGUI.launch(gaframeworkgui.GAGUI.class);
    }
}
