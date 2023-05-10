package Fusion.Internship.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//add more specific functions
	//ON CLICK: (msg)

	public void infoMessage(String accessedPage) {
		logger.info("ON CLICK: " + accessedPage);
	}

	public void errorMessage(String accessedPage) {
		logger.error("ERROR: " + accessedPage);
	}

}
