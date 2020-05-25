package br.com.webcars.dtos;

import java.io.Serializable;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CarDetailDTO implements Serializable
{

	private static final long		serialVersionUID	= 1L;

	private CarResponseDTO			car;

	private List<CarResponseDTO>	othersCars;
}
