package ma.enset.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import ma.enset.stubs.Chat;
import ma.enset.stubs.ChatAppGrpc;

import java.io.IOException;
import java.util.Scanner;

public class clientGrpcChatConsole {
    public static void main(String[] args) throws IOException {

        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost",6666)
                .usePlaintext()
                .build();
        ChatAppGrpc.ChatAppStub asyncStub = ChatAppGrpc.newStub(managedChannel);



        StreamObserver<Chat.Request> clientRequestStream = asyncStub.fullRequest(new StreamObserver<Chat.Response>() {
            @Override
            public void onNext(Chat.Response response) {

                System.out.println(response.getResponse());
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {

            }
        });

        Scanner sc = new Scanner(System.in);

        while (true) {
            String message = sc.next();
            Chat.Request request = Chat.Request.newBuilder()
                    .setRequest(message)
                    .build();
            clientRequestStream.onNext(request);
        }

    }
}
