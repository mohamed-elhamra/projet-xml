package fr.univrouen.rss22project.repositories;

import fr.univrouen.rss22project.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {

    Optional<Item> findByPubOuMajAndTitre(Date date, String titre);
}
