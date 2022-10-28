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

package cn.hippo4j.openapi.api;

import java.util.List;

import cn.hippo4j.openapi.dto.ThreadPoolDTO;
import cn.hippo4j.openapi.dto.ThreadPoolDelReqDTO;
import cn.hippo4j.openapi.dto.ThreadPoolQueryReqDTO;

/**
 *@author : wh
 *@date : 2022/10/28 13:54
 *@description:
 */
public interface Hippo4jOpenApiService {

	/**
	 * get all threadPollos
	 * @param reqDTO
	 * @return
	 */
	List<ThreadPoolDTO> getThreadPolls(ThreadPoolQueryReqDTO reqDTO);

	/**
	 * delete threadPool
	 * @param reqDTO
	 */
	void deletePool(ThreadPoolDelReqDTO reqDTO);
	
	
	
}
