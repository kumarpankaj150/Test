package com.sparks.ra.request;

import com.sparks.ra.request.dto.ReportDto;
import com.sparks.ra.response.ResultKey;

public class SubmitReportRequest implements IRequest{

	private ReportDto report;

	public ReportDto getReport() {
		return report;
	}

	public void setReport(ReportDto report) {
		this.report = report;
	}

	@Override
	public ResultKey authenticateRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultKey validateRequest() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
