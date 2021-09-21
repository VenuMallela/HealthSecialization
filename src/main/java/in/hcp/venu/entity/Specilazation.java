package in.hcp.venu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
@Table(name="specialization")
//@Setter
//@Getter	
public class Specilazation {
	
	
	
	@Id
	@GeneratedValue
	@Column(name="speicalid")
	private Integer id;
	@Column(name="speicalcode")
	private Integer code;
	@Column(name="speicalname")
	private String name;
	@Column(name="speicalnote")
	private String note;
	

}
