package com.zhihui.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class CustomerDateConvert implements Converter<String, Date> {

	SimpleDateFormat[] formats = new SimpleDateFormat[] { new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"),
			new SimpleDateFormat("yyyy-MM-dd"), new SimpleDateFormat("yyyyMMdd"), new SimpleDateFormat("yyyy/MM/dd") };

	@Override
	public Date convert(String str) {
		// TODO Auto-generated method stub
		if (str == null || str.trim().isEmpty()) {
			return null;
		}

		for (SimpleDateFormat sdf : formats) {
			try {
				// 把日期格式的字符串，转为一个日期对象
				return sdf.parse(str);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				continue;
			}
		}

		return null;
	}

}
