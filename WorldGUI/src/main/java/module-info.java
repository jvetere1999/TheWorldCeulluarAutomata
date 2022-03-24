module com.vetere.worldgui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.jvetere.worldlogic;
    requires com.vetere.graphing;

    opens com.vetere to javafx.fxml;
    exports com.vetere.worldgui;
}