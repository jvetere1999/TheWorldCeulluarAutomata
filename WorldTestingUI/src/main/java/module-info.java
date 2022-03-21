module com.jvetere.worldtestingui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.jvetere.worldlogic;

    opens com.jvetere.worldtestingui to javafx.fxml;
    opens com.jvetere.worldlogic;
    exports com.jvetere.worldtestingui;
}