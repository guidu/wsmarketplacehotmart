package br.com.wsmarketplacehotmart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wsmarketplacehotmart.model.HistoryExec;
import br.com.wsmarketplacehotmart.repository.HistoryExecRepository;
@Service
public class HistoryExecService {
	@Autowired
	public HistoryExecRepository historyExecRepository;
	
	public HistoryExec salve(HistoryExec historyExec) {
		return historyExecRepository.save(historyExec);
	}
}
