package com.emlakjet.adapter.approval;

import com.emlakjet.adapter.advert.AdvertMapper;
import com.emlakjet.adapter.advert.repo.AdvertRepository;
import com.emlakjet.advert.model.Advert;
import com.emlakjet.approval.port.AdvertApprovalPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component // TODO: Service kullanılmış diğer projelerde
@RequiredArgsConstructor
public class AdvertApprovalAdapter implements AdvertApprovalPort {

    private final AdvertRepository advertRepository;

    private final AdvertMapper mapper;

    @Override
    public Advert updateApprovalStatus(Advert advert) {

        advertRepository.save(mapper.toAdvertEntity(advert)); // TODO: save'den return edilen değeri fonksiyon return değeri olarak vermek daha iyi olabilir.

        return advert;

    }
}
