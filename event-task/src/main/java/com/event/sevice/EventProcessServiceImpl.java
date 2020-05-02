package com.event.sevice;

import org.springframework.stereotype.Service;

@Service
public class EventProcessServiceImpl implements EventProcessService {

	@Override
	public boolean validateDL(String dlNo) {

		return dlNo.length() > 5;
	}

}
