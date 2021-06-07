package br.com.wsmarketplacehotmart.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wsmarketplacehotmart.model.AssessProduct;
import br.com.wsmarketplacehotmart.repository.AssessProductRepository;

@Service
public class AssessProductServiceImpl implements AssessProductService{
	@Autowired
	public AssessProductRepository assessProductRepository;
	
	public AssessProduct salve(AssessProduct assessProduct) {
		return assessProductRepository.save(assessProduct);
	}
	
	public List<AssessProduct> find(Iterable<Integer> identifierProduct) {
		return assessProductRepository.findAllById(identifierProduct);
	}

	public List<AssessProduct> findAssessProductByIdentefierPeriod
	(Integer identifierProduct, LocalDateTime startDate, LocalDateTime  endDate ) {
		return assessProductRepository.findAssessProductByIdentefierPeriod(identifierProduct, startDate, endDate);
	}
}
