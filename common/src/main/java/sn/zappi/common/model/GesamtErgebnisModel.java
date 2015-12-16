/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.zappi.common.model;

import com.canoo.dolphin.collections.ObservableList;
import com.canoo.dolphin.mapping.DolphinBean;
import com.canoo.dolphin.mapping.Property;

@DolphinBean
public class GesamtErgebnisModel {

    private ObservableList<String> filter;

    private ObservableList<ChartData> data;
    
    private Property<String> selectedFilter;

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
    public ObservableList<ChartData> getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(ObservableList<ChartData> data) {
        this.data = data;
    }

    /**
     * @return the selectedFilter
     */
    public Property<String> getSelectedFilter() {
        return selectedFilter;
    }

    /**
     * @param selectedFilter the selectedFilter to set
     */
    public void setSelectedFilter(Property<String> selectedFilter) {
        this.selectedFilter = selectedFilter;
    }

}
