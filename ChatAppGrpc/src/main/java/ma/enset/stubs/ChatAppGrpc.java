package ma.enset.stubs;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: chat.proto")
public final class ChatAppGrpc {

  private ChatAppGrpc() {}

  public static final String SERVICE_NAME = "ChatApp";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ma.enset.stubs.Chat.Request,
      ma.enset.stubs.Chat.Response> getFullRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "fullRequest",
      requestType = ma.enset.stubs.Chat.Request.class,
      responseType = ma.enset.stubs.Chat.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<ma.enset.stubs.Chat.Request,
      ma.enset.stubs.Chat.Response> getFullRequestMethod() {
    io.grpc.MethodDescriptor<ma.enset.stubs.Chat.Request, ma.enset.stubs.Chat.Response> getFullRequestMethod;
    if ((getFullRequestMethod = ChatAppGrpc.getFullRequestMethod) == null) {
      synchronized (ChatAppGrpc.class) {
        if ((getFullRequestMethod = ChatAppGrpc.getFullRequestMethod) == null) {
          ChatAppGrpc.getFullRequestMethod = getFullRequestMethod = 
              io.grpc.MethodDescriptor.<ma.enset.stubs.Chat.Request, ma.enset.stubs.Chat.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "ChatApp", "fullRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ma.enset.stubs.Chat.Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ma.enset.stubs.Chat.Response.getDefaultInstance()))
                  .setSchemaDescriptor(new ChatAppMethodDescriptorSupplier("fullRequest"))
                  .build();
          }
        }
     }
     return getFullRequestMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ChatAppStub newStub(io.grpc.Channel channel) {
    return new ChatAppStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ChatAppBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ChatAppBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ChatAppFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ChatAppFutureStub(channel);
  }

  /**
   */
  public static abstract class ChatAppImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<ma.enset.stubs.Chat.Request> fullRequest(
        io.grpc.stub.StreamObserver<ma.enset.stubs.Chat.Response> responseObserver) {
      return asyncUnimplementedStreamingCall(getFullRequestMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFullRequestMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                ma.enset.stubs.Chat.Request,
                ma.enset.stubs.Chat.Response>(
                  this, METHODID_FULL_REQUEST)))
          .build();
    }
  }

  /**
   */
  public static final class ChatAppStub extends io.grpc.stub.AbstractStub<ChatAppStub> {
    private ChatAppStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChatAppStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatAppStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChatAppStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ma.enset.stubs.Chat.Request> fullRequest(
        io.grpc.stub.StreamObserver<ma.enset.stubs.Chat.Response> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getFullRequestMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class ChatAppBlockingStub extends io.grpc.stub.AbstractStub<ChatAppBlockingStub> {
    private ChatAppBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChatAppBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatAppBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChatAppBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class ChatAppFutureStub extends io.grpc.stub.AbstractStub<ChatAppFutureStub> {
    private ChatAppFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChatAppFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatAppFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChatAppFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_FULL_REQUEST = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ChatAppImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ChatAppImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FULL_REQUEST:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.fullRequest(
              (io.grpc.stub.StreamObserver<ma.enset.stubs.Chat.Response>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ChatAppBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ChatAppBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ma.enset.stubs.Chat.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ChatApp");
    }
  }

  private static final class ChatAppFileDescriptorSupplier
      extends ChatAppBaseDescriptorSupplier {
    ChatAppFileDescriptorSupplier() {}
  }

  private static final class ChatAppMethodDescriptorSupplier
      extends ChatAppBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ChatAppMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ChatAppGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ChatAppFileDescriptorSupplier())
              .addMethod(getFullRequestMethod())
              .build();
        }
      }
    }
    return result;
  }
}
