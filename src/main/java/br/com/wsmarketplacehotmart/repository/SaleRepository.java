package br.com.wsmarketplacehotmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.wsmarketplacehotmart.model.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer>{
	@Query("select count(s) from Sale s JOIN s.product p where p.identifier = :identifier ")
	public long amountOfSales(@Param("identifier") Integer identifier);
}
