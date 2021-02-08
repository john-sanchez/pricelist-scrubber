package io.johnsanchez.pricelistscrubber.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.johnsanchez.pricelistscrubber.entities.PcHubData;
import io.johnsanchez.pricelistscrubber.entities.PcHubDataId;

@Repository
public interface PcHubDataRepository extends JpaRepository<PcHubData, PcHubDataId> {

}
