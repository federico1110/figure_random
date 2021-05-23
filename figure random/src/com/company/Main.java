package com.company;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.*;

import java.util.Random;


public class Main extends Application {

    Button btnCancel = null;
    Button btnRandom = null;
    Button clearAll = new Button("clear All");


    @Override
    public void start(Stage primaryStage) throws Exception{

        VBox prova = dueBtn();
        VBox prova2 = dueBtn();
        VBox prova3 = dueBtn();
        VBox prova4 = dueBtn();
        VBox prova5 = dueBtn();
        VBox prova6 = dueBtn();

        VBox prova7 = treBtn();
        VBox prova8 = treBtn();
        VBox prova9 = treBtn();



        GridPane root = new GridPane();

        root.add(prova, 0, 0);
        root.add(prova2, 0, 1);
        root.add(prova3, 1, 1);
        root.add(prova4, 2, 1);
        root.add(prova5, 1, 2);
        root.add(prova6, 2, 2);

        root.add(prova7, 1, 0);
        root.add(prova8, 2, 0);
        root.add(prova9, 0, 2);



        ColumnConstraints column1 = new ColumnConstraints();
        ColumnConstraints column2 = new ColumnConstraints();
        ColumnConstraints column3 = new ColumnConstraints();

        root.getColumnConstraints().addAll(column1, column2, column3);

        root.setVgap(10);
        root.setHgap(10);
        root.setGridLinesVisible(true);
        root.setPadding(new Insets(10, 10, 10, 10));


        Button clearAll = new Button("clear All");
        Button check = new Button("Check");

        clearAll.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                btnCancel.fire();
            }
        });

        HBox btnBottom = new HBox();
        btnBottom.getChildren().addAll(clearAll, check);
        btnBottom.setSpacing(20);
        btnBottom.setAlignment(Pos.CENTER);
        btnBottom.setPadding(new Insets(0, 0, 10, 0));

        VBox root2 = new VBox();
        root2.getChildren().addAll(root, btnBottom);




        Scene scene = new Scene(root2);

        primaryStage.setTitle("TRE!");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    VBox dueBtn(){

        btnCancel = new Button("C");
        btnRandom = new Button("R");


        HBox btnBox2 = new HBox();

        btnBox2.getChildren().addAll(btnCancel, btnRandom);

        VBox vbox2 = new VBox();

        Circle crl1 = new Circle(43);
        crl1.setFill(Color.RED);
        Circle crl2 = new Circle(40);
        crl2.setFill(Color.YELLOW);

        StackPane circles = new StackPane();
        circles.getChildren().addAll(crl1, crl2);

        Rectangle r = new Rectangle(86, 86);
        r.setFill(Color.RED);

        Rectangle emptyR = new Rectangle(86, 86);
        emptyR.setFill(Color.WHITE);


        EventHandler<ActionEvent> cancelDueBtn  = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                vbox2.getChildren().removeAll( btnBox2, r, circles, emptyR);
                vbox2.getChildren().add(emptyR);
                vbox2.getChildren().add(btnBox2);
            }
        };

        btnCancel.setOnAction(cancelDueBtn);

        clearAll.setOnAction(cancelDueBtn);

        btnRandom.setOnAction(new EventHandler<ActionEvent>() {
            final Random generator = new Random();
            int i=0;
            @Override
            public void handle(ActionEvent actionEvent) {
                vbox2.getChildren().removeAll(btnBox2, circles, r, emptyR);
                i = generator.nextInt(2);      //scelgo in modo random tra un cerchio e un quadrato
                if(i==0){
                    vbox2.getChildren().add(circles);
                } else{
                    vbox2.getChildren().add(r);
                }
                vbox2.getChildren().add(btnBox2);
            }
        });

        vbox2.getChildren().add(circles);
        vbox2.getChildren().add(btnBox2);


        //vbox2.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        vbox2.setAlignment(Pos.CENTER);
        btnBox2.setAlignment(Pos.CENTER);

        vbox2.setSpacing(10);

        vbox2.setPadding(new Insets(10, 10, 10, 10));

        return vbox2;
    }

    VBox treBtn(){
        Button cancelbtn = new Button("C");
        Button circlebtn = new Button("O");
        Button trianglebtn = new Button("T");

        HBox btnBox3 = new HBox();
        btnBox3.getChildren().addAll(cancelbtn, circlebtn, trianglebtn);
        btnBox3.setAlignment(Pos.CENTER);

        VBox vbox3 = new VBox();


        Circle crl1 = new Circle(43);
        crl1.setFill(Color.BLACK);
        Circle crl2 = new Circle(40);
        crl2.setFill(Color.BLUE);

        StackPane circles = new StackPane();
        circles.getChildren().addAll(crl1, crl2);

        Rectangle r = new Rectangle(86, 86);
        r.setFill(Color.GREEN);

        Rectangle emptyR = new Rectangle(86, 86);
        emptyR.setFill(Color.WHITE);


        cancelbtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                vbox3.getChildren().removeAll( btnBox3, r, circles, emptyR);
                vbox3.getChildren().add(emptyR);
                vbox3.getChildren().add(btnBox3);
            }
        });

        circlebtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                vbox3.getChildren().removeAll( btnBox3, r, circles, emptyR);
                vbox3.getChildren().add(circles);
                vbox3.getChildren().add(btnBox3);
            }
        });

        trianglebtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                vbox3.getChildren().removeAll( btnBox3, r, circles, emptyR);
                vbox3.getChildren().add(r);
                vbox3.getChildren().add(btnBox3);
            }
        });


        vbox3.getChildren().addAll(r, btnBox3);
        vbox3.setAlignment(Pos.CENTER);
        vbox3.setSpacing(10);


        return  vbox3;

    }



    public static void main(String[] args) {
        launch(args);
    }
}


