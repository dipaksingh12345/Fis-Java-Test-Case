package com.fis.FisFirstTestCase.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank
	    @Size(max = 15)
	    private String firstName;

	    @NotBlank
	    @Size(max = 30)
	    private String lastName;

	    @NotNull
	    @Temporal(TemporalType.DATE)
	    private Date dob;

	    @NotNull
	    @Max(99)
	    private Integer age;

	    @NotNull
	    @Digits(integer = 10, fraction = 2)
	    private BigDecimal salary;
	    
	  

	    @NotBlank
	    @Size(max = 30)
	    private String departmentName;

	    @NotBlank
	    @Size(max = 15)
	    private String departmentId;

	    @NotBlank
	    @Size(max = 40)
	    @Email(message = "Invalid email format")
	    private String emailId;

	    @NotBlank
	    @Pattern(regexp = "\\d{10}", message = "Contact number must be 10 digits")
	    private String contactNumber;

	    @NotBlank
	    private String createdBy;

	    @NotNull
	    private Date createdTimestamp;

	    private String updatedBy;

	    private Date updatedTimestamp;
}
