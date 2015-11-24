/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.kivi.serverspring.basis.controller;

import com.canoo.dolphin.server.DolphinAction;
import com.canoo.dolphin.server.DolphinController;
import com.canoo.dolphin.server.DolphinModel;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import sn.kivi.common.basis.model.SuchenDialogModel;
import sn.kivi.serverspring.basis.persistence.entities.SuchDialog;
import sn.kivi.serverspring.basis.persistence.entities.SuchDialogRepository;

/**
 *
 * @author y9052
 */
@DolphinController("SuchenDialogController")
public class SuchenDialogController {

    @DolphinModel
    private SuchenDialogModel model;

    @Autowired
    private SuchDialogRepository repository;

    @PostConstruct
    public void init() {
        SuchDialog dialog = repository.findOne(6);
        model.setKassenzeichen(dialog.getKassenzeichen());
        model.setEWNummer(dialog.getEinheitswertnummer());
        model.setName(dialog.getName());
        model.setOrt(dialog.getOrt());
        model.setStrasse(dialog.getStrasse());
        model.setLagebezeichnung(dialog.getLagebezeichung());
    }

    @DolphinAction
    public void reset() {
        model.setKassenzeichen(null);
        model.setEWNummer(null);
        model.setName(null);
        model.setStrasse(null);
        model.setOrt(null);
        model.setLagebezeichnung(null);
    }
    
    @DolphinAction
    public void save() {
        try {
            String kzValue = model.getTxtFieldKZ();
            String ewValue = model.getTxtFieldEW();
            String nameValue = model.getTxtFieldName();
            String strasse = model.getTxtFieldStrasse();
            String ort = model.getTxtFieldOrt();
            String lageValue = model.getTxtFieldLage();

            SuchDialog suchdialog = new SuchDialog(kzValue, ewValue, nameValue, strasse, ort, lageValue);

            repository.save(suchdialog);
        } catch (Exception e) {
            model.setKassenzeichen("Error");
        }
    }

}
