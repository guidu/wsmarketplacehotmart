package br.com.wsmarketplacehotmart.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.wsmarketplacehotmart.model.AssessProduct;

@Repository
public interface AssessProductRepository extends JpaRepository<AssessProduct, Integer> {

	@Query("select a from AssessProduct a LEFT JOIN FETCH a.product p where p.identifier = :identifierproduct and dateassessment between :startdate and :enddate")
	public List<AssessProduct> findAssessProductByIdentefierPeriod(
			@Param("identifierproduct") Integer identifierProduct,
			@Param("startdate") LocalDateTime startDate,
			@Param("enddate") LocalDateTime endDate);

}
