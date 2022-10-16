package com.emlakjet.adapter.listing;

import com.emlakjet.adapter.advert.AdvertMapper;
import com.emlakjet.adapter.advert.entity.AdvertEntity;
import com.emlakjet.advert.model.Advert;
import com.emlakjet.approval.enums.ApprovalStatus;
import com.emlakjet.listing.port.AdvertListingPort;
import com.emlakjet.listing.usecase.AdvertListingUseCase;
import com.emlakjet.publishing.enums.AdvertStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

@Service // TODO: Service kullanılmış diğer projelerde
@RequiredArgsConstructor
public class AdvertListingAdapter implements AdvertListingPort {

    private final EntityManager entityManager;

    private final AdvertMapper mapper;

    @Override
    public List<Advert> getPostsPaging(AdvertListingUseCase advertListingUseCase) {

        var cb = entityManager.getCriteriaBuilder();

        var query = cb.createQuery(AdvertEntity.class);
        var root = query.from(AdvertEntity.class);
        query.select(root);

        ArrayList<Predicate> statuses = new ArrayList<>();

        if (nonNull(advertListingUseCase.approvalStatusSlug())) {
            statuses.add(cb.equal(root.get("approvalStatus"), ApprovalStatus.findBySlug(advertListingUseCase.approvalStatusSlug())));
        }

        if (nonNull(advertListingUseCase.advertStatusSlug())) {
            statuses.add(cb.equal(root.get("advertStatus"), AdvertStatus.findBySlug(advertListingUseCase.advertStatusSlug())));
        }

        Predicate[] test = new Predicate[statuses.size()];

        statuses.toArray(test);

        query.where(cb.and(test));

        var result = entityManager.createQuery(query)
                .setFirstResult(startFrom(advertListingUseCase.page() - 1, advertListingUseCase.pageSize()))
                .setMaxResults(advertListingUseCase.pageSize());

        return result.getResultList().stream().map(mapper::toAdvert).toList();
    }

    private Integer startFrom(Integer page, Integer pageSize) {
        return page * pageSize;
    }
}
