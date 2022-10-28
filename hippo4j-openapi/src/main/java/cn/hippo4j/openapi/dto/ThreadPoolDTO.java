package cn.hippo4j.openapi.dto;

import java.util.Date;

import lombok.Data;

/**
 *@author : wh
 *@date : 2022/10/28 15:04
 *@description:
 */
@Data
public class ThreadPoolDTO {

	/**
	 * ID
	 */
	private String id;

	/**
	 * Tenant id
	 */
	private String tenantId;

	/**
	 * Iem id
	 */
	private String itemId;

	/**
	 * Thread-pool id
	 */
	private String tpId;

	/**
	 * Core size
	 */
	private Integer coreSize;

	/**
	 * Max size
	 */
	private Integer maxSize;

	/**
	 * Queue type
	 */
	private Integer queueType;

	/**
	 * Queue name
	 */
	private String queueName;

	/**
	 * Capacity
	 */
	private Integer capacity;

	/**
	 * Keep alive time
	 */
	private Integer keepAliveTime;

	/**
	 * Execute time out
	 */
	private Long executeTimeOut;

	/**
	 * Is alarm
	 */
	private Integer isAlarm;

	/**
	 * Capacity alarm
	 */
	private Integer capacityAlarm;

	/**
	 * Liveness alarm
	 */
	private Integer livenessAlarm;

	/**
	 * Rejected type
	 */
	private Integer rejectedType;

	/**
	 * AllowCore thread timeout
	 */
	private Integer allowCoreThreadTimeOut;

	/**
	 * Gmt create
	 */
	private Date gmtCreate;

	/**
	 * Gmt modified
	 */
	private Date gmtModified;
}
