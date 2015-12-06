/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.zappi.common.model;

import com.canoo.dolphin.collections.ObservableList;
import com.canoo.dolphin.mapping.DolphinBean;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;

@DolphinBean
public class GesamtErgebnisModel {

    private ObservableList<String> filter;

    private ObservableList<XYChart.Series<String, Integer>> data;

    /**
     * @return the filter
     */
    public ObservableList<String> getFilter() {
        return filter;
    }

    /**
     * @param filter the filter to set
     */
    public void setFilter(ObservableList<String> filter) {
        this.filter = filter;
    }

    /**
     * @return the data
     */
    public ObservableList<XYChart.Series<String, Integer>> getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(ObservableList<XYChart.Series<String, Integer>> data) {
        this.data = data;
    }

}
