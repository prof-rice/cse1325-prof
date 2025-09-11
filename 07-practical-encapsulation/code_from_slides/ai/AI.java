import java.util.Stack;
import eliza.Eliza;

public class AI {
    public AI(Engine engine) {
        this.engine = engine;
        this.queries = new Stack<>();
        if(engine == Engine.Eliza) {
            this.eliza = new Eliza();
            System.out.println(eliza.processInput(eliza.welcome));
        }
    }
    public String query(String query) {
        queries.push(query);
        if(eliza != null) return eliza.processInput(query);
        else return "That's a puzzler!";
    }
    public Stack getQueryHistory() {
        return queries;
    }
    public boolean isFinished() {
        if(eliza != null) return eliza.finished();
        return false;
    }

    private Engine engine;
    private Stack<String> queries;
    private Eliza eliza;
}
