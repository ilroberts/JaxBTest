import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        writeXML();
        readXML();
    }

    public static void readXML(){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Country.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            File XMLFile = new File("CountryRecord.xml");

            Country india = (Country) jaxbUnmarshaller.unmarshal(XMLFile);

            System.out.println("Country name: " +india.getCountryName());
            System.out.println("Population: "+india.getCountryPopulation());

            ArrayList<State> listOfStates=india.getListOfStates();

            int i=0;
            for(State state:listOfStates){
                i++;
                System.out.println("State: "+i+" "+state.getStateName());
            }

        } catch (JAXBException e){
            e.printStackTrace();
        }
    }

    public static void writeXML(){
        // creating country object
        Country countryIndia=new Country();
        countryIndia.setCountryName("India");
        countryIndia.setCountryPopulation(5000000);

        // Creating listOfStates
        ArrayList<State> stateList=new ArrayList<State>();
        State mpState=new State("Madhya Pradesh",1000000);
        stateList.add(mpState);
        State maharastraState=new State("Maharastra",2000000);
        stateList.add(maharastraState);

        countryIndia.setListOfStates(stateList);

        try {

            // create JAXB context and initializing Marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(Country.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // for getting nice formatted output
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //specify the location and name of xml file to be created
            File XMLfile = new File("CountryRecord.xml");

            // Writing to XML file
            jaxbMarshaller.marshal(countryIndia, XMLfile);
            // Writing to console
            jaxbMarshaller.marshal(countryIndia, System.out);

        } catch (JAXBException e) {
            // some exception occurred
            e.printStackTrace();
        }
    }
}
