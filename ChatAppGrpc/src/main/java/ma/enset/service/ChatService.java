package ma.enset.service;

import io.grpc.stub.StreamObserver;
import ma.enset.stubs.Chat;
import ma.enset.stubs.ChatAppGrpc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ChatService extends ChatAppGrpc.ChatAppImplBase {

    private AtomicInteger clientAtomicId = new AtomicInteger(1);

    private Map<StreamObserver<Chat.Response>,Integer> clientsChat = new ConcurrentHashMap<>();

    @Override
    public StreamObserver<Chat.Request> fullRequest(StreamObserver<Chat.Response> responseObserver) {
        int clientChatId = clientAtomicId.getAndIncrement();
        clientsChat.put(responseObserver,clientChatId);
        Chat.Response response = Chat.Response.newBuilder()
                .setResponse("Bienvenue vous étes client ID : "+clientChatId)
                .build();

        responseObserver.onNext(response);

        return new StreamObserver<Chat.Request>() {
            @Override
            public void onNext(Chat.Request request) {
                String messageRequest = request.getRequest().trim();
                if(messageRequest.contains("=>")){
                    String[] messageEnv = messageRequest.split("=>");
                    if(messageEnv.length>=2){
                        try {
                            int clientReceiver = Integer.parseInt(messageEnv[1]);
                            Chat.Response response1 = Chat.Response.newBuilder()
                                    .setClientId(clientReceiver)
                                    .setRequest("")
                                    .setResponse(messageEnv[0])
                                    .build();

                            System.out.println("Sending message to client : "+messageEnv[1]);
                            sendMessageToClientById(response1,clientReceiver);
                        }catch (NumberFormatException e)
                        {
                            System.out.println("Error : Invalid client receiver ID");
                            Chat.Response response1 = Chat.Response.newBuilder()
                                    .setRequest("")
                                    .setResponse("Error : Invalid client receiver ID")
                                    .build();
                            sendMessageToAllClients(response1,responseObserver);
                        }
                    }
                }else
                {
                    Chat.Response response1 = Chat.Response.newBuilder()
                            .setRequest("")
                            .setResponse(request.getRequest())
                            .build();
                    sendMessageToAllClients(response1,responseObserver);
                }
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {

            }
        };

    }


    private void sendMessageToClientById(Chat.Response response, int id)
    {
        for(Map.Entry<StreamObserver<Chat.Response>,Integer> entry: clientsChat.entrySet()){
            StreamObserver<Chat.Response> observer = entry.getKey();
            int clientId  = entry.getValue();
            if(clientId == id)
            {
                Chat.Response.Builder builder= response.toBuilder();
                builder.setClientId(clientId);
                observer.onNext(builder.build());

            }
        }
    }



    private void sendMessageToAllClients(Chat.Response response, StreamObserver<Chat.Response> excludeObserver)
    {
     for (Map.Entry<StreamObserver<Chat.Response>,Integer> entry:clientsChat.entrySet()){
         StreamObserver<Chat.Response> observer = entry.getKey();
         int clientId = entry.getValue();
         if(observer != excludeObserver)
         {
             Chat.Response.Builder builder = response.toBuilder();
             builder.setClientId(clientId);
             observer.onNext(builder.build());
         }
     }
    }
}
