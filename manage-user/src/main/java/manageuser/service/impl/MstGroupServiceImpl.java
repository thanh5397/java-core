package manageuser.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manageuser.converter.MstGroupConverter;
import manageuser.dto.MstGroupDTO;
import manageuser.entities.MstGroupEntity;
import manageuser.repository.MstGroupRepository;
import manageuser.service.IMstGroupService;

@Service
public class MstGroupServiceImpl implements IMstGroupService {
	
	@Autowired
	MstGroupRepository mstGroupRepository;
	
	@Autowired
	MstGroupConverter mstGroupConverter;

	@Override
	public List<MstGroupDTO> findAll() {
		MstGroupDTO mstGroupDTO = new MstGroupDTO();
		List<MstGroupDTO> listMstGroupDTO = new ArrayList<MstGroupDTO>();
		List<MstGroupEntity> listMstGroupEntity = mstGroupRepository.findAll();
		for (MstGroupEntity mstGroupEntity : listMstGroupEntity) {
			mstGroupDTO = mstGroupConverter.toDTO(mstGroupEntity);
			listMstGroupDTO.add(mstGroupDTO);
		}
		return listMstGroupDTO;
	}
	
}
