package ma.enset.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import ma.enset.stubs.Chat;
import ma.enset.stubs.ChatAppGrpc;

import java.io.IOException;

public class clientGrpcChatJavaFX extends Application {

    StreamObserver<Chat.Request> clientRequestStream;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Client Chat GRPC");
        BorderPane borderPane = new BorderPane();

        Label labelHost = new Label("Host : ");
        TextField textFieldHost = new TextField("localhost");

        Label labelPort = new Label("Port : ");
        TextField textFieldPort = new TextField("6666");
        javafx.scene.control.Button buttonConnecte = new Button("Connecter");

        HBox hBox1= new HBox();
        hBox1.setSpacing(10);
        hBox1.setPadding(new Insets(10));
        hBox1.setBackground(new Background(new BackgroundFill(Color.ORANGE,null,null)));
        hBox1.getChildren().addAll(labelHost,textFieldHost,labelPort,textFieldPort,buttonConnecte);

        borderPane.setTop(hBox1);
        VBox vBox= new VBox();
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10));

        ObservableList<String> data = FXCollections.observableArrayList();
        ListView<String> listView = new ListView<>(data);
        vBox.getChildren().add(listView);

        borderPane.setCenter(vBox);

        Label labelMessage = new Label("Message : ");
        TextField textFieldMessage  =new TextField();
        textFieldMessage.setPrefSize(400,30);
        Button buttonEnvoyer = new Button("Envoyer");

        HBox hBox2 = new HBox();
        hBox2.setSpacing(10);
        hBox2.setPadding(new Insets(10));
        hBox2.getChildren().addAll(labelMessage,textFieldMessage,buttonEnvoyer);

        borderPane.setBottom(hBox2);

        Scene scene = new Scene(borderPane,800,600);

        stage.setScene(scene);
        stage.show();

        buttonConnecte.setOnAction((evt->{
            String host = textFieldHost.getText();
            int port = Integer.parseInt(textFieldPort.getText());
            ManagedChannel managedChannel = ManagedChannelBuilder.forAddress(host,port)
                    .usePlaintext()
                    .build();
            ChatAppGrpc.ChatAppStub asyncStub = ChatAppGrpc.newStub(managedChannel);

            new Thread(new Runnable() {
                @Override
                public void run() {
                   try {

                       clientRequestStream = asyncStub.fullRequest(new StreamObserver<Chat.Response>() {
                           @Override
                           public void onNext(Chat.Response response) {

                              // System.out.println(response.getResponse());

                               try {
                                   Platform.runLater(()->{
                                       data.add(response.getResponse());
                                   });
                               }catch (Exception e)
                               {
                                   System.out.println(e.getMessage());
                               }

                           }

                           @Override
                           public void onError(Throwable throwable) {

                           }

                           @Override
                           public void onCompleted() {

                           }
                       });

                   }catch (Exception e)
                   {
                       System.out.println(e.getMessage());
                   }
                }
            }).start();

        }));


        buttonEnvoyer.setOnAction((evt)->{
            String message = textFieldMessage.getText();
            Chat.Request request = Chat.Request.newBuilder()
                    .setRequest(message)
                    .build();
            clientRequestStream.onNext(request);
        });

    }



}
