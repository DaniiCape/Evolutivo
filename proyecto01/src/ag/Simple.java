
import gaframework.*;
import java.util.*;

public class Simple<G,P> implements GeneticAlgorithm<G,P> {

    private Breeder<G,P> breeder;
    private CrossoverOp<G> crossoverOp;
    private MutationOp<G> mutationOp;
    private SelectionOp<G,P> selectionOp;
    private TerminationCondition<G,P> termination;
    private ObjectiveFunction<G,P> objFun;
    private final int popSize;
    private boolean cont;
    
    
    public Simple(Codification<G,P> cod,
		  Corrector<G> cor,
		  CrossoverOp<G> cro,
		  MutationOp<G> muo,
		  SelectionOp<G,P> seo,
		  FitnessFunction<P> fun,
		  ObjectiveFunction<G,P> objFun,
		  TerminationCondition<G,P> ter,
		  int popSize){
	this.breeder = new Breeder<>(cod, cor, fun);
	this.crossoverOp = cro;
	this.mutationOp = muo;
	this.selectionOp = seo;
	this.termination = ter;
	this.objFun = objFun;
	this.popSize = popSize;
	this.cont = true;
    }

    public Population<G,P> iteration(Population<G,P> current) {
	Population<G,P> out = new Population<>(current.getGeneration() + 1);
	while (out.size() < current.size()) {
	    // Seleccion
	    List<Individual<G,P>> selectionList = selectionOp.select(current);
	    // Cruza
	    List<Genotype<G>> genotypeList = new LinkedList<>();
	    for (Individual<G,P> s:selectionList)
		genotypeList.add(s.getGenotype());
	    List<Genotype<G>> crossedList = crossoverOp.crossover(genotypeList);
	    // Mutacion
	    List<Genotype<G>> mutatedList = new LinkedList<>();
	    for (Genotype<G> c:crossedList)
		mutatedList.add(mutationOp.mutate(c));
	    // Nuevos individuos
	    for (Genotype<G> m:mutatedList)
		out.addIndividual(breeder.newIndividual(m));
	    // Evaluación función objetivo
	    if (objFun != null) {
		objFun.evaluate(out);
		out.sort();
	    }
	}
	return out;	    
    }

    public void run(){
        double mejor = 10000;
	Population<G,P> p = breeder.newRandomPopulation(popSize);
	while(!termination.conditionReached(p)){
	    p = iteration(p);
	    System.out.println("Generation: " + (p.getGeneration()));
	    System.out.println("El mejor");
            System.out.println(p.getBestIndividual());
            System.out.println("distancia");
	    System.out.println(10000 - p.getBestIndividual().getFitness());
	    if(mejor>10000 - p.getBestIndividual().getFitness())
	       mejor = 10000 - p.getBestIndividual().getFitness();
            System.out.println("El peor");
	    System.out.println(p.getWorstIndividual());
            System.out.println("distancia");
            System.out.println(10000 - p.getWorstIndividual().getFitness());
	}
	System.out.println("Mejor distancia del experimento");
        System.out.println(mejor);
    }

    @Override
    public void run(List<Statistics> l){
	Population<G,P> p = breeder.newRandomPopulation(popSize);
	while(!termination.conditionReached(p) && cont){
	    l.add(new Statistics(p));
	    p = iteration(p);
	    System.out.println("Generation: " + (10000-p.getGeneration()));
	    System.out.println(p.getBestIndividual());
	    System.out.println(p.getWorstIndividual());
	}
    }

    public void stop(){
	cont = false;
    }

}
