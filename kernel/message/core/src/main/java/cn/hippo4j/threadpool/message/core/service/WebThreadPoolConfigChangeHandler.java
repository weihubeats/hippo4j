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

package cn.hippo4j.threadpool.message.core.service;

import cn.hippo4j.common.api.ThreadPoolConfigChange;
import cn.hippo4j.common.toolkit.StringUtil;
import cn.hippo4j.threadpool.message.core.request.WebChangeParameterNotifyRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static cn.hippo4j.common.propertie.EnvironmentProperties.active;
import static cn.hippo4j.common.propertie.EnvironmentProperties.applicationName;
import static cn.hippo4j.common.propertie.EnvironmentProperties.itemId;
import static cn.hippo4j.common.propertie.IdentifyProperties.IDENTIFY;

/**
 * Web thread-pool config change handler.
 */
@RequiredArgsConstructor
@Slf4j
public class WebThreadPoolConfigChangeHandler implements ThreadPoolConfigChange<WebChangeParameterNotifyRequest> {

    private final ThreadPoolSendMessageService hippo4jSendMessageService;

    /**
     * Send pool config change message for web.
     *
     * @param requestParam change parameter notify request
     */
    @Override
    public void sendPoolConfigChange(WebChangeParameterNotifyRequest requestParam) {
        try {
            requestParam.setActive(active.toUpperCase());
            String appName = StringUtil.isBlank(itemId) ? applicationName : itemId;
            requestParam.setAppName(appName);
            requestParam.setIdentify(IDENTIFY);
            hippo4jSendMessageService.sendChangeMessage(requestParam);
        } catch (Throwable th) {
            log.error("Send web thread pool config change message failed.", th);
        }
    }
}
