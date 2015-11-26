
import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        ObjectProperty<Date> date = new SimpleObjectProperty<>(new Date());

        DatePicker datePicker = new DatePicker(LocalDate.now());
        Button addDayButton = new Button("Add day");
        addDayButton.setOnAction(event -> date.set(new Date(date.get().getTime() + 24 * 60 * 60 * 1000)));
        Button subtractDayButton = new Button("Subtract day");
        subtractDayButton.setOnAction(event -> date.set(new Date(date.get().getTime() - 24 * 60 * 60 * 1000)));

        Label label = new Label();
        DateFormat format = DateFormat.getDateInstance();
        label.textProperty().bind(Bindings.createStringBinding(() -> format.format(date.get()), date));

        date.addListener((obs, oldDate, newDate) -> {

            Instant instant = newDate.toInstant();
            ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, ZoneId.systemDefault());
            LocalDate localDate = zonedDateTime.toLocalDate();
            if (!datePicker.getValue().equals(localDate)) {
                datePicker.setValue(localDate);
            }
        });
        datePicker.valueProperty().addListener((obs, oldDate, newDate) -> {
            ZonedDateTime zonedDateTime = newDate.atStartOfDay(ZoneId.systemDefault());
            Instant instant = Instant.from(zonedDateTime);
            Date dateToSet = Date.from(instant);
            if (!dateToSet.equals(date.get())) {
                date.set(dateToSet);
            }
        });

        root.setCenter(datePicker);
        HBox controls = new HBox(5, subtractDayButton, addDayButton, label);
        controls.setPadding(new Insets(10));
        controls.setAlignment(Pos.CENTER);
        root.setBottom(controls);

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
