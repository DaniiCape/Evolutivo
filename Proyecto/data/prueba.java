import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main{
    public static void comprueba(String palabras[]){
	for(int i=0; i<palabras.length;i++){
	    switch(palabras[1]){
	    case "hola":
		return;
	    default:
		System.out.println(palabras[i]);
		break;
	    }
	}
    }
    public static void main(String args[]){
        /**try(BufferedReader br = new BufferedReader(new FileReader(args[0]))){
	    String line;
	    while((line = br.readLine()) != null)
		System.out.println(line);
	}
	catch(IOException e){
	    e.printStackTrace();
	}
	**/
	try(Scanner sc = new Scanner(new File(args[0]))){
	    while(sc.hasNextLine()){
		String line = sc.nextLine();
		System.out.println(line);
		String[] words = line.split(" ");
		comprueba(words);
		
	    }
	}
	catch(IOException e){
	    e.printStackTrace();
	}
    }

}
