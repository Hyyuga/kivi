/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.zapp.controller;

import com.canoo.dolphin.BeanManager;
import com.canoo.dolphin.mapping.Property;
import com.canoo.dolphin.server.DolphinAction;
import com.canoo.dolphin.server.DolphinController;
import com.canoo.dolphin.server.DolphinModel;
import com.canoo.dolphin.server.event.TaskExecutor;
import java.sql.Date;
import java.time.LocalDate;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import sn.zapp.persistence.Mitglieder;
import sn.zapp.persistence.MitgliederRepository;
import sn.zapp.service.DatePickerService;
import sn.zappi.common.model.MitgliederDialogModel;

/**
 *
 * @author y9052
 */
@DolphinController("MitgliederDialogController")
public class MitgliederDialogController {

    @DolphinModel
    private MitgliederDialogModel model;

    @Autowired
    private MitgliederRepository repository;

    private Mitglieder mitglied = null;

    @Inject
    private DatePickerService service;

    @Inject
    private TaskExecutor taskExecutor;

    @Inject
    private BeanManager beanManager;

    @PostConstruct
    public void init() {
        mitglied = repository.findBynachname("Naus");
        model.setVorname(mitglied.getVorname());
        model.setNachname(mitglied.getNachname());
        model.setAdresse(mitglied.getAdresse());
        boolean c = beanManager.isManaged(this);
        LocalDate date =  mitglied.getGeburtstag().toLocalDate();
        boolean b = beanManager.isManaged(this);
        boolean d = beanManager.isManaged(model);
        boolean f = beanManager.isManaged(date);
        boolean e = beanManager.isManaged(repository);
//        model.setGebDate(date);
//        model.setGebDate();
//        beanManager.create(beanClass)
//        beanManager.create(LocalDate.class);
//        model.setGebDate(service.getLocalDate(mitglied.getGeburtstag()));
//        Date date = mitglied.getGeburtstag();
//        LocalDate lDate = date.toLocalDate();
//        model.setGebDate(lDate);
//        System.out.print("");

//        LocalDate date = mitglied.getGeburtstag().toLocalDate();
//        Date date = mitglied.getGeburtstag();
//        add(date);
//        model.setGebDate(date);
//        model.setImageViewFoto(new Image(getClass().getResource("../common/src/main/sn/zapp/resources/pictures/lol.JPG").toString()));
    }

    public void add(Date date) {
        taskExecutor.execute(MitgliederDialogController.class, c -> c.onAdded(date.toLocalDate()));
    }

    private void onAdded(LocalDate date) {
//        LocalDate toDoItem = beanManager.create(LocalDate.class);
//        toDoItem = date.toLocalDate();
        model.setGebDate(date);
    }

    @DolphinAction
    public void reset() {
        model.setVorname("Resetted");
        model.setNachname(null);
        model.setAdresse(null);
        model.setGebDate(null);
    }

    @DolphinAction
    public void save() {
        try {
            Mitglieder mitgliederResult = repository.findOne(mitglied.getId());
            LocalDate date = mitgliederResult.getGeburtstag().toLocalDate();
//            Property<LocalDate> das = model.gebDatePickerProperty();
//            LocalDate d = das.get();
//            model.gebDatePickerProperty().set(date);

//            Mitglieder mitgliederResult = repository.findOne(mitglied.getId());
//            mitgliederResult.setVorname(model.getTxtFieldVorname());
//            Image image = model.getImageViewFoto();
//             Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/entw?zeroDateTimeBehavior=convertToNull");
//            BufferedImage bimage = SwingFXUtils.fromFXImage(image, null);
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            ImageIO.write(bimage, "jpg", baos);
//            byte[] imageInByte = baos.toByteArray();
//           
//            Blob blob = conn.createBlob();
//            blob.setBytes(1, imageInByte);
//            mitgliederResult.setImagedatablob(blob);
//            bimage.getGraphics().drawImage(image, 0, 0, null);
//            WritableImage bismage = SwingFXUtils.toFXImage(bimage, null);
//            Blob blob = new Blob("");
//            ImageIO.getCacheDirectory()
//            image.get
//            mitgliederResult.setGeburtstag(Date.valueOf(model.getGebDate()));
//            Date ewValue = model.get();
//            String nameValue = model.getTxtFieldName();
//            Date strasse = new Date(3232323);
//            String ort = model.getTxtFieldEW();
//            String imageurl = null;
//            new Mitglieder(kzValue, null, nameValue, ort, null);
//            repository.save(mitgliederResult);
        } catch (Exception e) {
            model.setVorname("Error");
        }
    }

}
