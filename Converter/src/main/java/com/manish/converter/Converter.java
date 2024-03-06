package com.manish.converter;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class Converter extends Application {
 
     public static void main(String[] args)
    {
        System.out.println("Main");
        launch();
    }
    @Override
    public void start(Stage stage) throws IOException
    {
        System.out.println("start");
        FXMLLoader fxmlLoader = new FXMLLoader(Converter.class.getResource("design.fxml"));
        VBox rootNode= fxmlLoader.load();

        MenuBar menuBar= createMenu();

        rootNode.getChildren().add(0,menuBar);


        Scene scene = new Scene(rootNode, 350, 400);
        stage.setTitle("Temperature Converter Tool!");
        stage.setScene(scene);
        stage.show();
    }
    private MenuBar createMenu()
    {
        //File Menu
        Menu fileMenu= new Menu("File");
        MenuItem newMenuItem=new MenuItem("New");



        MenuItem quitMenuItem=new MenuItem("Quit");

        // using the lambda it decreases the lines of code easily
        /*quitMenuItem.setOnAction(actionEvent -> {
           Platform.exit();
           System.exit(0);
        });*/  // this is the example of lambda
        quitMenuItem.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                Platform.exit();
                System.exit(0);
            }
        });

        fileMenu.getItems().addAll(newMenuItem,quitMenuItem);

        //Help Menu
        Menu helpMenu=new Menu("Help");
        MenuItem aboutMenuItem=new MenuItem("About");
        aboutMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
             public void handle(ActionEvent actionEvent) {
                aboutMenuItem();
            }
        });
        helpMenu.getItems().addAll(aboutMenuItem);
        //Menu Bar
        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);
        return menuBar;
    }
    private void aboutMenuItem()
    {
        //Alert
        Alert alertDialog=new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("My first application");
        alertDialog.setHeaderText("Learning javafx in internshala");
        alertDialog.setContentText("I am manish nishad i am learning java using internshala");
        ButtonType yesbtn=new ButtonType("Yes");
        ButtonType nobtn=new ButtonType("No");
        alertDialog.getButtonTypes().setAll(yesbtn,nobtn);

        Optional<ButtonType> clickbtn=  alertDialog.showAndWait();
        if (clickbtn.isPresent() &&clickbtn.get()==yesbtn)
        {
            //
            System.out.println("Button clicked");
        }
        else
        {
            System.out.println("Button not clicked");
        }
       /* if (clickbtn.isPresent() &&clickbtn.get()==nobtn)
        {
            //
            System.out.println("Button not clicked");
        }*/
    }

}