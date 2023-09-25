package xtech.qrvenus.core.utilities.mappers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;
import xtech.qrvenus.entities.concretes.QrCode;

@Service
@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService {
    private ModelMapper modelMapper;

    @Override
    public ModelMapper forResponse() {
        modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        // strateji: gevşek mapleme yap yani entity için veri tabanında 10 farklı alan olsun
        // ama response nesnesinde 3 alan olsun, bunu LOOSE mapleme ile yapar kızmaz.
        return modelMapper;
    }

    @Override
    public ModelMapper forRequest() {
        modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STANDARD);
        // strateji: her şey maplensin, her şeyin bir karşılığı olsun yoksa kızar.
        return modelMapper;
    }

//    @Override
//    public ModelMapper forQrCodeResponse() {
//        modelMapper.getConfiguration()
//                .setAmbiguityIgnored(true)
//                .setMatchingStrategy(MatchingStrategies.LOOSE);
//
//        // many-to-many mapping for User and Group entities
//        modelMapper.createTypeMap(QrCode.class, UserDTO.class)
//                .addMappings(mapper -> {
//                    mapper.map(src -> src.getGroups().stream().map(Group::getId).collect(Collectors.toSet()),
//                            UserDTO::setGroupIds);
//                });
//
//        modelMapper.createTypeMap(Group.class, GroupDTO.class)
//                .addMappings(mapper -> {
//                    mapper.map(src -> src.getUsers().stream().map(User::getId).collect(Collectors.toSet()),
//                            GroupDTO::setUserIds);
//                });
//
//        return modelMapper;
//        return modelMapper;
//    }


}
