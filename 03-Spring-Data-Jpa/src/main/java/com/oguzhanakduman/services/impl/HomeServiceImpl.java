package com.oguzhanakduman.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oguzhanakduman.dto.DtoHome;
import com.oguzhanakduman.dto.DtoRoom;
import com.oguzhanakduman.entites.Home;
import com.oguzhanakduman.entites.Room;
import com.oguzhanakduman.repository.HomeRepository;
import com.oguzhanakduman.services.IHomeService;

@Service
public class HomeServiceImpl implements IHomeService{
	
	@Autowired
	private HomeRepository homeRepository;
	
	public DtoHome findHomeById(Long id) {
		DtoHome dtoHome = new DtoHome();
		List<DtoRoom> dtoRoomList = new ArrayList<>();
		
		Optional<Home> optional = homeRepository.findById(id);
		
		if(optional.isEmpty()) {
			return null;
		}
		
		Home home = optional.get();
		
		BeanUtils.copyProperties(home, dtoHome);
		for(Room room : home.getRoom()) {
			DtoRoom dtoRoom = new DtoRoom();
			BeanUtils.copyProperties(room, dtoRoom);
			dtoRoomList.add(dtoRoom);
		}
		// BeanUtils.copyProperties(home.getRoom(), dtoRoomList);
		
		
		dtoHome.setRooms(dtoRoomList);
		
		return dtoHome;
	}

}
