package com.br.wsmarketplacehotmart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.wsmarketplacehotmart.model.HistoryExec;
import com.br.wsmarketplacehotmart.repository.HistoryExecRepository;
@Service
public class HistoryExecService {
	@Autowired
	public HistoryExecRepository historyExecRepository;
	
	public HistoryExec salve(HistoryExec historyExec) {
		return historyExecRepository.save(historyExec);
	}
}
