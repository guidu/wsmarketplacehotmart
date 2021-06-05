package com.br.wsmarketplacehotmart.engine;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import com.br.wsmarketplacehotmart.async.AsyncNewsAPIService;

@Component
@EnableScheduling
public class NewsAPISchedule {
	@Autowired
	public AsyncNewsAPIService asyncNewsAPIService;
 //   @Scheduled(fixedDelay = 2 * 60 * 1000, initialDelay = 5000)
//    @Scheduled(cron = "0 0 7,12,15,17 * * *")

    public void run() {
    	asyncNewsAPIService.asyncExecucaoPerfil();
    	System.out.println("Rodou ::::::::: "+LocalDateTime.now());
    }
}
