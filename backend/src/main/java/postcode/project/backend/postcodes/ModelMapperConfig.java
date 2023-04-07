package postcode.project.backend.postcodes;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import postcode.project.backend.converters.StringTrimConvertor;

@Configuration
public class ModelMapperConfig {
	
@Bean
public ModelMapper modelMapper() {
	ModelMapper mapper = new ModelMapper();
	mapper.typeMap(String.class, String.class).setConverter(new StringTrimConvertor());
	return mapper;
}

}
