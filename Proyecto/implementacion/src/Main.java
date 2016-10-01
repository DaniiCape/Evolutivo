import java.util.*;
import gaframework.*;

public class Main{

    public static void main(String args[]){
	BinInteger bini = new BinInteger(10,1);
	Ruleta<Boolean,Integer> ru = new Ruleta<>(1,2);
	UniformMutation um = new UniformMutation(.001,1);
	OnePointCrossover<Boolean> opc = new OnePointCrossover<>(1,.001);
	NumGeneraciones ng = new NumGeneraciones(200);
	MaxFun mf = new MaxFun();
	Simple<Boolean,Integer> sim = new Simple<>(bini, null, opc, um, ru, mf, null, ng, 1000);
	gaframeworkgui.GAGUI.setGA(sim);
	gaframeworkgui.GAGUI.launch(gaframeworkgui.GAGUI.class);
    }
}
