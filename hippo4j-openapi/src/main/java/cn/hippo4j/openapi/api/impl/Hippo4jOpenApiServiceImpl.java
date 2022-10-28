package cn.hippo4j.openapi.api.impl;

import java.util.List;

import cn.hippo4j.openapi.api.Hippo4jOpenApiService;
import cn.hippo4j.openapi.dto.ThreadPoolDelReqDTO;
import cn.hippo4j.openapi.dto.ThreadPoolQueryReqDTO;
import cn.hippo4j.openapi.dto.ThreadPoolDTO;

/**
 *@author : wh
 *@date : 2022/10/28 15:13
 *@description:
 */
public class Hippo4jOpenApiServiceImpl implements Hippo4jOpenApiService {


	@Override
	public List<ThreadPoolDTO> getThreadPolls(ThreadPoolQueryReqDTO reqDTO) {
		return null;
	}

	@Override
	public void deletePool(ThreadPoolDelReqDTO reqDTO) {

	}
}
