/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.zapp.client.controller;

import com.canoo.dolphin.client.ClientContext;
import com.canoo.dolphin.client.javafx.AbstractViewBinder;
import com.canoo.dolphin.client.javafx.BidirectionalConverter;
import com.canoo.dolphin.client.javafx.FXBinder;
import com.canoo.dolphin.client.javafx.FXWrapper;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import sn.kivi.client.util.FXWrapper2;
import sn.zappi.common.model.ChartData;
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
        XYChart.Series<String, Integer> townCountSeries = new XYChart.Series<>();
        barChart.dataProperty().get().add(townCountSeries);
        townCountSeries.setData(FXWrapper2.wrapList(getModel().getData(), new DataConverter()));
        
        comboBoxFilter.setItems(FXWrapper.wrapList(getModel().getFilter()));
        
        FXBinder.bind(comboBoxFilter.valueProperty()).bidirectionalTo(getModel().getSelectedFilter());
    }

    private class DataConverter implements BidirectionalConverter<ChartData, XYChart.Data<String, Integer>> {

        @Override
        public ChartData convertBack(XYChart.Data<String, Integer> value) {
            throw new RuntimeException("DP API ERROR!");
        }

        @Override
        public XYChart.Data<String, Integer> convert(ChartData value) {
            XYChart.Data<String, Integer> data = new XYChart.Data(value.getCategory(), value.getValue());
            value.categoryProperty().onChanged(e -> data.setXValue(value.getCategory()));
            value.valueProperty().onChanged(e -> data.setYValue(value.getValue()));
            return data;
        }
    }
}
