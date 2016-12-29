package com.mmk.random;

import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TestRandom {

	private static Log log = LogFactory.getLog(TestRandom.class);

	public static void main(String[] args) {
		Random random = new Random();
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		log.info(random.nextInt(10));
		
		int[] getRandomSequence2 = GetRandomSequence2(100);
		for (int i = 0; i < getRandomSequence2.length; i++) {
			log.info("test:"+getRandomSequence2[i]);
		}
	}
	
	
	public static int[] GetRandomSequence2(int total)
    {
  	  int[] sequence = new int[total];
        int[] output = new int[total];

        for (int i = 0; i < total; i++){
            sequence[i] = i;
        }

        Random random = new Random();
        int end = total - 1;

        for (int i = 0; i < total; i++){
            int num = random.nextInt(total);
            output[i] = sequence[num];
            sequence[num] = sequence[end];
            end--;
        }

        return output;
    }

}
