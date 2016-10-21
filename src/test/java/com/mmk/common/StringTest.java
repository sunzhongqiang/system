package com.mmk.common;

import static org.junit.Assert.*;

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
		
	}

}
