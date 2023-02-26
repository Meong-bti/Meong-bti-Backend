package projectB.meongbti.boast.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import projectB.meongbti.boast.entity.Boast;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class JpaBoastRepository implements BoastRepository {

    private final EntityManager em;

    @Override
    public void saveBoast(Boast boast) {
        em.persist(boast);
    }
}
