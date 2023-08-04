module com.example.ogin_cyberPost_jeffer {
    requires javafx.controls;
    requires javafx.fxml;



    exports com.example.login_cyberPost_jeffer;
    opens com.example.login_cyberPost_jeffer to javafx.fxml;
}