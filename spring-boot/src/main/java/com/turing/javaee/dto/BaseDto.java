package com.turing.javaee.dto;

import java.util.Date;
import lombok.Data;
@Data
public class BaseDto {

	private Long id;
	private Date created_at = new Date();
	private Date updated_at = new Date();
}
