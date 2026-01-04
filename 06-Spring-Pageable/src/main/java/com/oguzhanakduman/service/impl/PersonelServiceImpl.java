package com.oguzhanakduman.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.oguzhanakduman.dto.DtoDepartment;
import com.oguzhanakduman.dto.DtoPersonel;
import com.oguzhanakduman.model.Personel;
import com.oguzhanakduman.repository.PersonelRepository;
import com.oguzhanakduman.service.IPersonelService;

@Service
public class PersonelServiceImpl implements IPersonelService{
	
	@Autowired
	PersonelRepository personelRepository;

	@Override
	public Page<Personel> findAllPageable(Pageable pageable) {
		Page<Personel> page = personelRepository.findAllPageable(pageable); 
		return page;
	}

	@Override
	public List<DtoPersonel> toDTOList(List<Personel> personelList) {
		List<DtoPersonel> dtoPersonels = new ArrayList<>();
		
		for (Personel personel : personelList) {
			DtoPersonel dtoPersonel = new DtoPersonel();
			DtoDepartment dtoDepartment = new DtoDepartment();
			
			BeanUtils.copyProperties(personel, dtoPersonel);
			BeanUtils.copyProperties(personel.getDepartment(), dtoDepartment);
			
			dtoPersonel.setDepartment(dtoDepartment);
			
			dtoPersonels.add(dtoPersonel);
		}
		
		return dtoPersonels;
	}

}
