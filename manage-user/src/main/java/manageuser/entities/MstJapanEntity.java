package manageuser.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="mst_japan")
public class MstJapanEntity {
	
	@Id
	private String codeLevel;
	private String nameLevel;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)  
    @JoinTable(name = "tbl_detail_user_japan", //Tạoo ra mộtt join Table tênn là"address_person"
            joinColumns = @JoinColumn(name = "code_level"),  // TRong đóó, khóaa ngoạii chínhh làaddress_id trỏtớii class hiệnn tạii (Address)
            inverseJoinColumns = @JoinColumn(name = "user_id") //Khóaa ngoạii thứ2 trỏtớii thuộcc tínhh ởdướii (Person)
    )
    private List<TblUserEntity> tblUserEntities;
	
	public String getCodeLevel() {
		return codeLevel;
	}
	public void setCodeLevel(String codeLevel) {
		this.codeLevel = codeLevel;
	}
	public String getNameLevel() {
		return nameLevel;
	}
	public void setNameLevel(String nameLevel) {
		this.nameLevel = nameLevel;
	}
}
