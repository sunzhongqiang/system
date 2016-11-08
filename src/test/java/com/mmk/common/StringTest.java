package com.mmk.common;

import static org.junit.Assert.*;

import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class StringTest {

	@Test
	public void testNull() {
		
		assertFalse(StringUtils.isNotBlank("  "));
		assertFalse(StringUtils.isNoneBlank("  "));
		
		assertFalse(StringUtils.isNotBlank(""));
		assertFalse(StringUtils.isNoneBlank(""));
		
		assertFalse(StringUtils.isNotBlank(null));
		assertFalse(StringUtils.isNoneBlank(null));
		
		assertTrue(StringUtils.isNotEmpty("  "));
		assertTrue(StringUtils.isNoneEmpty("   "));
		
		assertFalse(StringUtils.isNotEmpty(""));
		assertFalse(StringUtils.isNoneEmpty(""));
		
		assertFalse(StringUtils.isNotEmpty(null));
		assertFalse(StringUtils.isNoneEmpty(null));

		

		Random random = new Random();
	    int length =	random.nextInt(5);
	    int length1 =	random.nextInt(5);
	    int length2 =	random.nextInt(5);
	    int length3 =	random.nextInt(5);
	    int length4 =	random.nextInt(5);
	    int length5 =	random.nextInt(5);
	    int length6 =	random.nextInt(5);
		

	}

}
