package br.com.webcars.factories;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import br.com.webcars.dtos.CarResponseDTO;
import br.com.webcars.dtos.OwnerResponseDTO;
import br.com.webcars.entities.Car;

public class ModelMapperFactory
{
	private static ModelMapper mapper;

	static
	{
		mapper = new ModelMapper();
		PropertyMap<Car, CarResponseDTO> carToCarResponse = new PropertyMap<Car, CarResponseDTO>()
		{

			@Override
			protected void configure()
			{
				map().setOwner(new OwnerResponseDTO());
				map().getOwner().setEmail(source.getOwner().getEmail());
				map().getOwner().setName(source.getOwner().getName());
				map().getOwner().setPhoneNumber(source.getOwner().getPhoneNumber());
			}
		};

		mapper.addMappings(carToCarResponse);
	}

	public ModelMapper getMapper()
	{
		return mapper;
	}

}
