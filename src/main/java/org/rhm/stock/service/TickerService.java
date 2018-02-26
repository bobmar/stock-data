package org.rhm.stock.service;

import org.rhm.stock.dao.TickerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TickerService {
	@Autowired
	private TickerRepo tickerRepo = null;
}
