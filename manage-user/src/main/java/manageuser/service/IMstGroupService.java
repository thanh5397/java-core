package manageuser.service;

import java.util.List;

import manageuser.dto.MstGroupDTO;

public interface IMstGroupService {
	List<MstGroupDTO> findAll();
}
