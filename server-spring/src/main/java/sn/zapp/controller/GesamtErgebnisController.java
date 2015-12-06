/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.zapp.controller;

import com.canoo.dolphin.BeanManager;
import com.canoo.dolphin.server.DolphinAction;
import com.canoo.dolphin.server.DolphinController;
import com.canoo.dolphin.server.DolphinModel;
import com.canoo.dolphin.server.Param;
import com.canoo.dolphin.server.event.TaskExecutor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import sn.zapp.persistence.MitgliedErgebnisse;
import sn.zapp.persistence.Mitglieder;
import sn.zapp.persistence.MitgliederRepository;
import sn.zappi.common.model.GesamtErgebnisModel;

@DolphinController("GesamtErgebnisController")
public class GesamtErgebnisController {

    @DolphinModel
    private GesamtErgebnisModel model;

    @Inject
    private MitgliederRepository repository;

    @Inject
    private BeanManager beanManager;

    @Inject
    private TaskExecutor taskExecutor;

    private HashMap<Mitglieder, HashMap<String, Integer>> rawFilterData;

    @PostConstruct
    public void init() {
        rawFilterData = new HashMap();
        for (Mitglieder mitglieder : repository.findAll()) {
            getFilterFields(MitgliedErgebnisse.class).forEach(field -> {
                if (rawFilterData.get(mitglieder) == null) {
                    rawFilterData.put(mitglieder, new HashMap());
                }
                rawFilterData.get(mitglieder).put(field, getFilterResult(mitglieder, field));
            });
        }
        System.out.println("");
    }

    private Integer getFilterResult(Mitglieder mitglied, String filter) {
        return new Integer(mitglied.getListeErgebisse()
                .stream()
                .mapToInt(ergebnis -> getValueOfDeclaredField(filter, ergebnis)).sum());
    }

    private Stream<String> getFilterFields(Class<?> clazz) {
        return Stream.of(clazz.getDeclaredFields())
                .filter(field -> !(field.getName().equals("id") || field.getName().equals("datum") || field.getName().equals("mitglied") || field.getName().equals("strafen")))
                .map(field -> field.getName());
    }

    private Integer getValueOfDeclaredField(String filter, MitgliedErgebnisse mitgliedErgebnisse) {
        Integer retVal = null;
        try {
            Field field = mitgliedErgebnisse.getClass().getDeclaredField(filter);
            field.setAccessible(true);
            retVal = Integer.parseInt((String) field.get(mitgliedErgebnisse));
        } catch (Exception ex) {
            Logger.getLogger(GesamtErgebnisController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retVal;
    }

    void getFilter() {
        getFilterFields(MitgliedErgebnisse.class).forEach(field -> model.getFilter().add(field));
        model.getData().clear();
    }

    @DolphinAction
    public void fillModelData(@Param("filter") String filter) {
        model.getData().clear();
        taskExecutor.execute(GesamtErgebnisController.class, e -> {
            final Series<String, Integer> series = beanManager.create(XYChart.Series.class);
            rawFilterData.entrySet().stream().map((mitgliedToFilterResultEntry) -> {
                final XYChart.Data<String, Integer> datas = beanManager.create(XYChart.Data.class);
                String datax = mitgliedToFilterResultEntry.getKey().getVorname() + " " + mitgliedToFilterResultEntry.getKey().getNachname();
                datas.setXValue(datax);
                Integer datay = mitgliedToFilterResultEntry.getValue().get(filter);
                datas.setYValue(datay);
                return datas;
            }).forEach((datas) -> {
                series.getData().add(datas);
            });
            model.getData().add(series);
        });

    }

    private XYChart.Series<String, Integer> getChartData() {
        Integer aValue = 17;
        Series<String, Integer> aSeries = beanManager.create(XYChart.Series.class);
        aSeries.setName("a");
        XYChart.Data<String, Integer> data = beanManager.create(XYChart.Data.class);
        XYChart.Data<String, Integer> data1 = beanManager.create(XYChart.Data.class);
        XYChart.Data<String, Integer> data2 = beanManager.create(XYChart.Data.class);
        data.setXValue("David Fiederichs");
        data.setYValue(aValue);
        data2.setXValue("Steffen Naus");
        data2.setYValue(aValue);
        data1.setXValue("Martin Nyaki");
        data1.setYValue(aValue);
        aSeries.getData().add(data);
        aSeries.getData().add(data1);
        aSeries.getData().add(data2);
        return aSeries;
    }
}
