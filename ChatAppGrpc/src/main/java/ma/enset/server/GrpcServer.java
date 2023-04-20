package ma.enset.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import ma.enset.service.ChatService;

public class GrpcServer {

    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(6666)
                .addService(new ChatService())
                .build();
        server.start();
        server.awaitTermination();
    }
}
