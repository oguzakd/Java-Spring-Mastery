package com.oguzhanakduman.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oguzhanakduman.cofiguration.DataSource;
import com.oguzhanakduman.cofiguration.GlobalProperties;
import com.oguzhanakduman.cofiguration.Server;

@RestController
@RequestMapping(path = "rest/api/property")
public class PropertySourceControllerImpl {
	
	@Autowired
	private GlobalProperties globalProperties;
	
	@GetMapping(path = "/datasource")
	public DataSource getDataSource() {
//		DataSource dataSource = new DataSource();
//		dataSource.setUrl(globalProperties.getUrl());
//		dataSource.setUsername(globalProperties.getUsername());
//		dataSource.setPassword(globalProperties.getPassword());
		return null;
	}
	
	@GetMapping(path = "/getServers")
	public List<Server> getServers() {
		return globalProperties.getServers();
	}
	

}
