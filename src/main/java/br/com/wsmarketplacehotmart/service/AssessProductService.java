package br.com.wsmarketplacehotmart.service;

import java.time.LocalDateTime;
import java.util.List;

import br.com.wsmarketplacehotmart.model.AssessProduct;

public interface AssessProductService {

	public AssessProduct salve(AssessProduct assessProduct);

	public List<AssessProduct> find(Iterable<Integer> identifierProduct);

	public List<AssessProduct> findAssessProductByIdentefierPeriod(Integer identifierProduct, LocalDateTime startDate,
			LocalDateTime endDate);
}
