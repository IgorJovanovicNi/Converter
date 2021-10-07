package sample;

import java.util.LinkedHashMap;
import java.util.Map;

public class Currency {
    private String name;
    private Map<String,Double> listOfValue;



    public Currency(String name) {
        this.name = name;
        this.listOfValue=new LinkedHashMap<>();
    }

    public String getName() {
        return name;
    }

    public Map<String, Double> getListOfValue() {
        return listOfValue;
    }
}
