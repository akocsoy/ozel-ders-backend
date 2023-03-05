package ozelders.io.core.utils.mappers;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
	ModelMapper forRequest();
	ModelMapper forResponse();
}
