
import javax.xml.bind.annotation.XmlRootElement;

//Below statement means that class 'Country.java' is the root-element of our example
@XmlRootElement(namespace = "Country")
public class State {

    private String stateName;
    long statePopulation;

    @SuppressWarnings("unused")
    public State()
    {

    }
    public State(String stateName, long statePopulation) {
        super();
        this.stateName = stateName;
        this.statePopulation = statePopulation;
    }

    public String getStateName() {
        return stateName;
    }

    @SuppressWarnings("unused")
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @SuppressWarnings("unused")
    public long getStatePopulation() {
        return statePopulation;
    }

    @SuppressWarnings("unused")
    public void setStatePopulation(long statePopulation) {
        this.statePopulation = statePopulation;
    }
}