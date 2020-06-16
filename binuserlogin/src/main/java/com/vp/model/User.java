package com.vp.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;


@Entity
@Data
@NonNull
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Userid;
	@NotBlank(message=" enter a username ")
	String Username;
	@NotEmpty(message="password cannot be empty")
	@Size(min=5,message="password atleast have 5 characters")
	@Size(max=15, message="password should not exceed 40 character")
	String Password;
	@javax.validation.constraints.Email(message="email should format should be abc@gmail.com")
	String Email;
	String Usertype;
	
}
