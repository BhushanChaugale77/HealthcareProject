package com.xcure.dto;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserDto {

	@NonNull
	private Long userid;
	
	@Pattern(
	        regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
	        message = "Invalid email address"
	    )
	private String useremail;
	@NotBlank
	@NotEmpty
	@NonNull
	@Size(max = 25,min = 9)
	private String password;
	@NotBlank
	@NotEmpty
	@NonNull
	private String role;
	@NotBlank
	@NotEmpty
	@NonNull
	private String createdAt;
	
	public UserDto() {
		super();
 	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "UserDto [userid=" + userid + ", useremail=" + useremail + ", password=" + password + ", role=" + role
				+ ", createdAt=" + createdAt + "]";
	}

	 
	
}
