package com.oguzhanakduman.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.oguzhanakduman.dto.DtoPersonel;
import com.oguzhanakduman.model.Personel;

public interface IPersonelService {
	
	Page<Personel> findAllPageable(Pageable pageable);
	
	List<DtoPersonel> toDTOList(List<Personel> personelList);

}
