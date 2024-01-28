module piotr.mazur {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens piotr.mazur to javafx.fxml;
    exports piotr.mazur;
}
