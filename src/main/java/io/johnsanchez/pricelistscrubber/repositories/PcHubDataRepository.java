package io.johnsanchez.pricelistscrubber.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.johnsanchez.pricelistscrubber.entities.PcHubData;
import io.johnsanchez.pricelistscrubber.entities.PcHubDataId;

@Repository
public interface PcHubDataRepository extends PagingAndSortingRepository<PcHubData, PcHubDataId> {

	@Query("from PcHubData where recordedDate = (select max(recordedDate) from PcHubData)")
	public List<PcHubData> findLatest();
}
