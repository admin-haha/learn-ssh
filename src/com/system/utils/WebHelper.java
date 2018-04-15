package com.system.utils;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;

import com.system.po.Users;

public class WebHelper {

	private static final Logger logger = LoggerFactory.getLogger(WebHelper.class);


	// 将多个追溯号压缩成用来显示的字符串
	public static String compressLotNumber(final String lotNumberStr) {
		if (StringUtils.isBlank(lotNumberStr)) {
			return "";
		}
		if (!lotNumberStr.contains(",")) {
			return lotNumberStr;
		}
		final String[] str1 = lotNumberStr.split(",");
		final List<String> list = new ArrayList<String>();
		for (final String element : str1) {
			list.add(element);
		}
		Collections.sort(list);
		final StringBuilder sb = new StringBuilder();
		sb.append(list.get(0));
		Boolean isFirstCompress = true;
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i).length() >= 3) {
				Long frontNumber = Long.parseLong(list.get(i - 1));
				frontNumber = frontNumber + 1;
				String longStr = String.valueOf(frontNumber);
				if (longStr.length() != list.get(i).length()) {
					longStr = list.get(i - 1).substring(0,
							(list.get(i - 1).length() - longStr.length()))
							+ longStr;
				}
				if (longStr.equals(list.get(i))) {
					if (isFirstCompress) {
						sb.append("~" + longStr.substring(longStr.length() - 3, longStr.length()));
					} else {
						sb.replace(sb.length() - 3, sb.length(), longStr.substring(
								longStr.length() - 3, longStr.length()));
					}
					isFirstCompress = false;
				} else {
					sb.append("," + list.get(i));
					isFirstCompress = true;
				}
			} else {
				sb.append("," + list.get(i));
			}
		}
		return sb.toString();
	}

	public static Users getCurrentUser(final HttpServletRequest request) {
		return null;
	}

	public static String isExist(final Object obj) {
		if (obj != null) {
			return "1";
		}
		return "0";
	}

	public static boolean isNull(final Object service, final Long id) {
		if (id == null) {
			return false;
		}
		try {
			final Method method = service.getClass().getMethod("get", Long.class);
			logger.debug(method.getName());
			final Object o = method.invoke(service, id);
			if (o == null) {
				return false;
			}
		} catch (final Exception e) {
			WebHelper.logger.error(e.getMessage());
			return false;
		}
		return true;
	}

	public static void main(final String[] args) {
		System.out.println(WebHelper.compressLotNumber("123000,123001"));

	}

	public static String makeJson(final List<?> objects, final String[] methodNames,
			final String[] attributNames) {

		try {
			final StringBuffer sb = new StringBuffer();
			sb.append("[");
			for (final Iterator<?> iterator = objects.iterator(); iterator.hasNext();) {
				final Object object = iterator.next();
				sb.append("{");
				for (int i = 0; i < methodNames.length; i++) {
					final String methodName = methodNames[i];
					final Method method = object.getClass().getMethod(methodName);

					final Object value = method.invoke(object);
					sb.append(attributNames[i] + ": '" + value + "'");

					if (i < methodNames.length - 1) {
						sb.append(",");
					}
				}
				sb.append("}");
				if (iterator.hasNext()) {
					sb.append(",");
				}
			}
			sb.append("]");
			return sb.toString();
		} catch (final Exception e) {
			WebHelper.logger.error("error", e);
			return "";
		}
	}

	public static void sendData(final HttpServletResponse response, final String data) {
		try {
			logger.info("返回数据："+data);
			response.setContentType("text/html; charset=utf-8");
			response.setCharacterEncoding("utf-8");
			response.getWriter().print(data);
		} catch (final Exception e) {
			logger.error("Error occurred.", e);
		} finally {
			try {
				response.getWriter().close();
			} catch (final IOException e) {
			}
		}
	}

	public static void sendJsonData(final HttpServletResponse response, final String data) {
		try {
			logger.info("返回数据："+data);
			response.setContentType("application/json; charset=utf-8");
			response.setCharacterEncoding("utf-8");
			response.getWriter().print(data);
		} catch (final Exception e) {
			logger.error("Error occurred.", e);
		} finally {
			try {
				response.getWriter().close();
			} catch (final IOException e) {
			}
		}
	}
}
