package com.mmk.common.convert;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.convert.converter.Converter;

public class StringToDate implements Converter<String, Date> {

	protected Log log = LogFactory.getLog(this.getClass());

	@Override
	public Date convert(String source) {
		if (StringUtils.isNotBlank(source)) {
			try {
				return DateUtils.parseDate(source, "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd",
						"yyyy/MM/dd HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ss");
			} catch (ParseException e) {
				log.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		return null;
	}

}
