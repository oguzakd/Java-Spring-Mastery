package com.oguzhanakduman.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oguzhanakduman.controller.IRestPersonelController;
import com.oguzhanakduman.dto.DtoPersonel;
import com.oguzhanakduman.model.Personel;
import com.oguzhanakduman.service.IPersonelService;
import com.oguzhanakduman.utils.RestPageableEntity;
import com.oguzhanakduman.utils.RestPageableRequest;
import com.oguzhanakduman.utils.RestRootEntity;

@RestController
@RequestMapping("rest/api/personel")
public class RestPersonelControllerImpl extends RestBaseController implements IRestPersonelController{
	
	@Autowired
	IPersonelService personelService;

	@GetMapping("/list/pageable")
	@Override
	public RestRootEntity<RestPageableEntity<DtoPersonel>> findAllPageable(@ModelAttribute RestPageableRequest pageable) {
		Page<Personel> page = personelService.findAllPageable(toPageable(pageable));
		RestPageableEntity<DtoPersonel> pageableResponse = toPageableResponse(page, personelService.toDTOList(page.getContent()));
		return ok(pageableResponse);
	}

}
