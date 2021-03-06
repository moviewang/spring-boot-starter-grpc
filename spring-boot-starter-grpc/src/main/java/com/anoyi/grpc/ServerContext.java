package com.anoyi.grpc;

import com.alibaba.fastjson.JSONObject;
import com.anoyi.grpc.constant.SerializeTypeEnum;
import com.anoyi.grpc.service.GrpcRequest;
import com.anoyi.grpc.service.GrpcResponse;
import com.anoyi.grpc.service.SerializeService;
import com.anoyi.grpc.util.SerializeUtils;
import com.anoyi.rpc.CommonServiceGrpc;
import com.anoyi.rpc.GrpcService;
import com.google.protobuf.ByteString;
import io.grpc.Channel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServerContext {

    private Channel channel;

    private final SerializeService defaultSerializeService;

    private CommonServiceGrpc.CommonServiceBlockingStub blockingStub;

    ServerContext(Channel channel, SerializeService serializeService) {
        this.channel = channel;
        this.defaultSerializeService = serializeService;
        blockingStub = CommonServiceGrpc.newBlockingStub(channel);
    }

    /**
     * 处理 gRPC 请求
     */
    public GrpcResponse handle(SerializeTypeEnum serializeType, GrpcRequest grpcRequest) {
        SerializeService serializeService = SerializeUtils.getSerializeService(serializeType, this.defaultSerializeService);
        ByteString bytes = serializeService.serialize(grpcRequest);
        int value = (serializeType == null ? -1 : serializeType.getValue());
        GrpcService.Request request = GrpcService.Request.newBuilder().setSerialize(value).setRequest(bytes).build();
        GrpcService.Response response;
        try{
            response = blockingStub.handle(request);
        }catch (Exception e){
            log.warn("GRPC handle error, re-handle: " + JSONObject.toJSONString(grpcRequest));
            response = blockingStub.handle(request);
        }
        return serializeService.deserialize(response);
    }

    /**
     * 获取 Channel
     */
    public Channel getChannel() {
        return channel;
    }

}
