package com.sparks.ra.request;

import com.sparks.ra.response.ResultKey;

public interface IRequest {

	public ResultKey authenticateRequest();
	public ResultKey validateRequest();
}
