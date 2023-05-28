/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.hippo4j.rpc.handler;

import cn.hippo4j.rpc.exception.HandlerNotFoundException;
import cn.hippo4j.rpc.model.DefaultRequest;
import cn.hippo4j.rpc.model.DefaultResponse;
import cn.hippo4j.rpc.model.Request;
import cn.hippo4j.rpc.model.Response;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;

/**
 * The final handler, which returned an exception because no usable handler could be found
 *
 * @since 2.0.0
 */
@ChannelHandler.Sharable
public class ErrorServerHandler extends AbstractTakeHandler {

    private static final String ERR_MSG = "no handler found that matches the request";

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        HandlerNotFoundException exception = new HandlerNotFoundException(ERR_MSG);
        if (!(msg instanceof DefaultRequest)) {
            ctx.close();
            throw exception;
        }
        Request request = (Request) msg;
        Response response = new DefaultResponse(request.getRID(), ERR_MSG);
        ctx.writeAndFlush(response);
    }
}
