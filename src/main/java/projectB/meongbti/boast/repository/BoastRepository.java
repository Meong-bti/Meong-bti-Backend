package projectB.meongbti.boast.repository;

import projectB.meongbti.boast.entity.Boast;

import java.util.Optional;

public interface BoastRepository {

    public void saveBoast(Boast boast);

    public void deleteBoast(Boast boast);

    public Optional<Boast> findOne(Long boastId);
}
