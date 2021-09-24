package in.hcp.venu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="doctor_tab")
public class Doctor {
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="doc_id_col")
	private Long id;
	
	@Column(name="doc_fn_col")
	private String firstname;
	
	@Column(name="doc_ln_col")
	private String lastname;
	
	@Column(name="doc_mail_col")
	private String mail;
	@Column(name="doc_mn_col")
	private String mobileno;
	
	@Column(name="doc_addr_col")
	private String address;
	
	@Column(name="doc_gen_col")
	private String gender;
	
	@Column(name="doc_img_col")
	private String photoLoc;
	
}
