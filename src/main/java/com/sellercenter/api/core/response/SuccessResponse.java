package com.sellercenter.api.core.response;

import java.util.Map;

public class SuccessResponse extends AbstractResponse {

	private String responseType;
	private String timestamp;

	/**
	 * Constructor
	 * @param requestAction
	 * @param responseType the type of data in the response
	 * @param timestamp timestamp of the response as string
     * @param body Map representing the 'body' section of the response
     */
	public SuccessResponse(String requestAction, String responseType, String timestamp, Map<String, Object> body) {
        super(requestAction, body);

		this.responseType = responseType;
		this.timestamp = timestamp;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isError() {
		return false;
	}

	/**
	 * Timestamp of the response
	 * @return timestamp as a string
     */
	public String getTimestamp() {
		return timestamp;
	}

	/**
	 * Type of the data in the body
	 * @return type as string
     */
	public String getResponseType() {
		return responseType;
	}
}
