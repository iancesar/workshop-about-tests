package br.com.webcars.dtos;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OwnerResponseDTO implements Serializable
{

	private static final long	serialVersionUID	= 1L;

	private String					name;

	private String					email;

	private String					phoneNumber;

}
