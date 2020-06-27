package mr.esp.suivi.dto;

import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class UserDto {
	@NotBlank
	private String Username;
	
	
	@Email(message="donner un email correct")
	private String email;
	
	@NotBlank
	private String password;
	
	@NotNull
	private boolean enabled;
	
	
	private String ConfirmationPassword;

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		this.Username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getConfirmationPassword() {
		return ConfirmationPassword;
	}

	public void setConfirmationPassword(String confirmationPassword) {
		ConfirmationPassword = confirmationPassword;
	}
	
	
	
	
	

}
