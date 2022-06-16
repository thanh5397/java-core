package manageuser.service;

import java.util.List;

import manageuser.dto.MstGroupDTO;
import manageuser.entities.MstGroupEntity;

public interface IMstGroupService {
	List<MstGroupDTO> findAll();
	MstGroupDTO findMstGroupByGroupId(int groupId);
}
