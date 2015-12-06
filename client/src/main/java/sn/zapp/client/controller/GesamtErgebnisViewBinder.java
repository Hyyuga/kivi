/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.zapp.client.controller;

import com.canoo.dolphin.client.ClientContext;
import com.canoo.dolphin.client.Param;
import com.canoo.dolphin.client.javafx.AbstractViewBinder;
import com.canoo.dolphin.client.javafx.FXBinder;
import com.canoo.dolphin.client.javafx.FXWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.ComboBox;
import sn.zapp.client.app.Zapp;
import sn.zappi.common.model.GesamtErgebnisModel;

public class GesamtErgebnisViewBinder extends AbstractViewBinder<GesamtErgebnisModel> {

    @FXML
    private ComboBox<String> comboBoxFilter;

    @FXML
    private BarChart<String, Integer> barChart;

    public GesamtErgebnisViewBinder(ClientContext clientContext) {
        super(clientContext, "GesamtErgebnisController");
    }

    @Override
    protected void init() {
        ObservableList<XYChart.Series<String, Integer>> data = FXWrapper.wrapList(getModel().getData());
        ObservableList<String> list = FXWrapper.wrapList(getModel().getFilter());
        barChart.setData(data);
        comboBoxFilter.setItems(list);
        comboBoxFilter.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String oldValue, String newValue) {
                invoke("fillModelData", new Param("filter", newValue));
            }
        });
    }

    private ObservableList<XYChart.Series<String, Integer>> getChartData() {
        Integer aValue = 17;
        ObservableList<XYChart.Series<String, Integer>> answer = FXCollections.observableArrayList();
        Series<String, Integer> aSeries = new Series<String, Integer>();
        aSeries.setName("a");
            XYChart.Data<String, Integer> data = Zapp.getClientContext().getBeanManager().create(XYChart.Data.class);
            XYChart.Data<String, Integer> data1 = Zapp.getClientContext().getBeanManager().create(XYChart.Data.class);
            XYChart.Data<String, Integer> data2 = Zapp.getClientContext().getBeanManager().create(XYChart.Data.class);
            data.setXValue("David Fiederichs");
            data.setYValue(aValue);
            data2.setXValue("Steffen Naus");
            data2.setYValue(aValue);
            data1.setXValue("Martin Nyaki");
            data1.setYValue(aValue);
            aSeries.getData().add(data);
            aSeries.getData().add(data1);
            aSeries.getData().add(data2);
//            aSeries.getData().add(new XYChart.Data("David Fiederichs", aValue));
//            aValue = aValue + 5;
//            aSeries.getData().add(new XYChart.Data("Steffeb Fiederichs", aValue));
//            aValue = aValue + 5;
//            aSeries.getData().add(new XYChart.Data("Martin Fiederichs", aValue));
//            aValue = aValue + 5;
        answer.addAll(aSeries);
        return answer;
    }
}
