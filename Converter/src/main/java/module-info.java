module com.manish.converter {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.manish.converter to javafx.fxml;
    exports com.manish.converter;
}