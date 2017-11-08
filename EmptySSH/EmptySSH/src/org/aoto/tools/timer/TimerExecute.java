package org.aoto.tools.timer;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author AOTO
 *
 */
@Component
public class TimerExecute {
	
	/**
	 * ¶¨Ê±Ö´ÐÐ
	 *
	 */
	//@Scheduled(fixedDelay = 5000)
	public static void job(){
		System.out.println(123);
	}

}
