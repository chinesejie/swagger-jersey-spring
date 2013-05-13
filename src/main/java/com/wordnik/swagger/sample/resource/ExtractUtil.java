package com.wordnik.swagger.sample.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiError;
import com.wordnik.swagger.annotations.ApiErrors;
import com.wordnik.swagger.annotations.ApiOperation;

import cn.edu.dhu.score.analyze.service.EtlService;

@Path("/gogo.json")
@Api(value="/gogo", description = "Operations about gogo")

@Produces(MediaType.APPLICATION_JSON)
public class ExtractUtil {
	
	private EtlService etlService;

	public EtlService getEtlService() {
		return etlService;
	}

	public void setEtlService(EtlService etlService) {
		this.etlService = etlService;
	}
	@GET
	@Path("/get")
	@ApiOperation(value = "Get user by user name", responseClass = "string")
	@ApiErrors(value = {
			@ApiError(code = 400, reason = "Invalid username supplied"),
			@ApiError(code = 404, reason = "User not found") })

	public Response getTest() {
		return Response.ok()
				.entity(etlService.getTest())
				.build();
	}
	

}
