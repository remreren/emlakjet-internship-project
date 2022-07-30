package com.emlakjet.adapter.advert;

import com.emlakjet.adapter.advert.repo.AdvertRepository;
import com.emlakjet.advert.model.Advert;
import com.emlakjet.advert.port.AdvertPort;
import com.emlakjet.advert.usecase.CreateAdvertUseCase;
import com.emlakjet.advert.usecase.UpdateAdvertUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component // TODO: Service kullanılmış diğer projelerde
@RequiredArgsConstructor
@Slf4j
public class AdvertAdapter implements AdvertPort {

    private final KafkaTemplate<String, Object> advertEventSender;

    private static final String ADVERT_EVENTS = "advert-events";

    private final AdvertRepository advertRepository;

    private final AdvertMapper mapper;

    @Override
    public Advert createPost(CreateAdvertUseCase advert) {

        var createdAdvert = advertRepository.save(mapper.toAdvertEntity(advert));

        advertEventSender.send(ADVERT_EVENTS, mapper.toAdvertCreatedMessage(createdAdvert));

        return mapper.toAdvert(createdAdvert);
    }

    @Override
    public Advert updatePost(UpdateAdvertUseCase advert) {

        var updatedAdvert = advertRepository.save(mapper.toAdvertEntity(advert));

        advertEventSender.send(ADVERT_EVENTS, mapper.toAdvertUpdatedMessage(updatedAdvert));

        return mapper.toAdvert(updatedAdvert);
    }

    @Override
    public void deletePost(Long advertId) {

        advertRepository.deleteById(advertId);

        advertEventSender.send(ADVERT_EVENTS, mapper.toAdvertDeletedMessage(advertId));

    }
}
