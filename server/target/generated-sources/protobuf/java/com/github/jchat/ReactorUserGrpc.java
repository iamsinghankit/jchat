package com.github.jchat;

import static com.github.jchat.UserGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;


@javax.annotation.Generated(
value = "by ReactorGrpc generator",
comments = "Source: User.proto")
public final class ReactorUserGrpc {
    private ReactorUserGrpc() {}

    public static ReactorUserStub newReactorStub(io.grpc.Channel channel) {
        return new ReactorUserStub(channel);
    }

    public static final class ReactorUserStub extends io.grpc.stub.AbstractStub<ReactorUserStub> {
        private UserGrpc.UserStub delegateStub;

        private ReactorUserStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = UserGrpc.newStub(channel);
        }

        private ReactorUserStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = UserGrpc.newStub(channel).build(channel, callOptions);
        }

        @Override
        protected ReactorUserStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ReactorUserStub(channel, callOptions);
        }

        public reactor.core.publisher.Mono<com.github.jchat.UserCreateResponse> create(reactor.core.publisher.Mono<com.github.jchat.UserCreateRequest> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::create, getCallOptions());
        }

        public reactor.core.publisher.Mono<com.github.jchat.UserDeleteResponse> delete(reactor.core.publisher.Mono<com.github.jchat.UserDeleteRequest> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::delete, getCallOptions());
        }

        public reactor.core.publisher.Mono<com.github.jchat.UserCreateResponse> create(com.github.jchat.UserCreateRequest reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::create, getCallOptions());
        }

        public reactor.core.publisher.Mono<com.github.jchat.UserDeleteResponse> delete(com.github.jchat.UserDeleteRequest reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::delete, getCallOptions());
        }

    }

    public static abstract class UserImplBase implements io.grpc.BindableService {

        public reactor.core.publisher.Mono<com.github.jchat.UserCreateResponse> create(reactor.core.publisher.Mono<com.github.jchat.UserCreateRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        public reactor.core.publisher.Mono<com.github.jchat.UserDeleteResponse> delete(reactor.core.publisher.Mono<com.github.jchat.UserDeleteRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            com.github.jchat.UserGrpc.getCreateMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.github.jchat.UserCreateRequest,
                                            com.github.jchat.UserCreateResponse>(
                                            this, METHODID_CREATE)))
                    .addMethod(
                            com.github.jchat.UserGrpc.getDeleteMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.github.jchat.UserDeleteRequest,
                                            com.github.jchat.UserDeleteResponse>(
                                            this, METHODID_DELETE)))
                    .build();
        }

        protected io.grpc.CallOptions getCallOptions(int methodId) {
            return null;
        }

    }

    public static final int METHODID_CREATE = 0;
    public static final int METHODID_DELETE = 1;

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final UserImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(UserImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_CREATE:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((com.github.jchat.UserCreateRequest) request,
                            (io.grpc.stub.StreamObserver<com.github.jchat.UserCreateResponse>) responseObserver,
                            serviceImpl::create);
                    break;
                case METHODID_DELETE:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((com.github.jchat.UserDeleteRequest) request,
                            (io.grpc.stub.StreamObserver<com.github.jchat.UserDeleteResponse>) responseObserver,
                            serviceImpl::delete);
                    break;
                default:
                    throw new java.lang.AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                default:
                    throw new java.lang.AssertionError();
            }
        }
    }

}
