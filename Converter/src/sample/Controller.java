package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;

public class Controller {
    private ObservableMap<String,Currency> currencyList;
    @FXML
    private Label resultDisplay;
    @FXML
    private Spinner<Integer> amount;
     @FXML
    private ComboBox<String> listCurrencyFrm;
     @FXML
     private ComboBox<String> listCurrencyTo;

     private  Currency selectedCurrencyFrom,selectedCurrencyTo;

    public  void initialize(){
        currencyList= FXCollections.observableHashMap();
        Currency currency1=new Currency("US Dollar");
        Currency currency2=new Currency("EUR Euro");
        Currency currency3=new Currency("GBP British Pound");
        Currency currency4=new Currency("CAD Canadian Dollar");
        Currency currency5=new Currency("RSD Dinar");

        currency1.getListOfValue().put("EUR Euro",0.85);
        currency1.getListOfValue().put("GBP British Pound",0.73);
        currency1.getListOfValue().put("CAD Canadian Dollar",1.26);
        currency1.getListOfValue().put("RSD Dinar",100.16);

        currency2.getListOfValue().put("US Dollar",1.17);
        currency2.getListOfValue().put("GBP British Pound",0.85);
        currency2.getListOfValue().put("CAD Canadian Dollar",1.48);
        currency2.getListOfValue().put("RSD Dinar",117.16);

        currency3.getListOfValue().put("US Dollar",1.37);
        currency3.getListOfValue().put("EUR Euro",1.17);
        currency3.getListOfValue().put("CAD Canadian Dollar",1.73);
        currency3.getListOfValue().put("RSD Dinar",137.22);

        currency4.getListOfValue().put("US Dollar",0.79);
        currency4.getListOfValue().put("EUR Euro",0.68);
        currency4.getListOfValue().put("GBP British Pound",0.58);
        currency4.getListOfValue().put("RSD Dinar",79.26);

        currency5.getListOfValue().put("US Dollar",0.01);
        currency5.getListOfValue().put("EUR Euro",0.01);
        currency5.getListOfValue().put("GBP British Pound",0.01);
        currency5.getListOfValue().put("CAD Canadian Dollar",0.01);


        currencyList.put(currency1.getName(),currency1);
        currencyList.put(currency2.getName(),currency2);
        currencyList.put(currency3.getName(),currency3);
        currencyList.put(currency4.getName(),currency4);
        currencyList.put(currency5.getName(),currency5);

        System.out.println(currencyList.size());

        listCurrencyFrm.getItems().setAll(currencyList.keySet());
        listCurrencyTo.getItems().setAll(currencyList.keySet());

        Currency one=currencyList.get("US Dollar");
        System.out.println(one.getListOfValue().entrySet());

    }

    @FXML
    public void onMouseEntered(){
        resultDisplay.setScaleX(2.0);
        resultDisplay.setScaleY(2.0);
    }

    @FXML
    public void onMouseExited(){
        resultDisplay.setScaleX(1.0);
        resultDisplay.setScaleY(1.0);
    }


    @FXML
    public void convert(){

        selectedCurrencyFrom=currencyList.get(listCurrencyFrm.getSelectionModel().getSelectedItem());

        selectedCurrencyTo=currencyList.get(listCurrencyTo.getSelectionModel().getSelectedItem());

        System.out.println(selectedCurrencyTo.getListOfValue().get(selectedCurrencyFrom.getName())+"");

        if (selectedCurrencyTo.getName().equals(selectedCurrencyFrom.getName())){
            resultDisplay.setText("Choose different currency.");
            return;
        }

        int amountToChange=amount.getValue();
        Double valueForCurrency=selectedCurrencyFrom.getListOfValue().get(selectedCurrencyTo.getName());

        System.out.println(amountToChange+"->"+valueForCurrency);

        Double changed=amountToChange * valueForCurrency;
        resultDisplay.setText(amountToChange+" "+selectedCurrencyFrom.getName()+" is "+
                changed+" "+selectedCurrencyTo.getName());
    }
}
