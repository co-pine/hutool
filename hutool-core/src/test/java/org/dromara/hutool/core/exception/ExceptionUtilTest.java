/*
 * Copyright (c) 2023 looly(loolly@aliyun.com)
 * Hutool is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 *          https://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND,
 * EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT,
 * MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */

package org.dromara.hutool.core.exception;

import org.dromara.hutool.core.convert.Convert;
import org.dromara.hutool.core.io.IORuntimeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * 异常工具单元测试
 *
 * @author looly
 */
public class ExceptionUtilTest {

	@Test
	public void wrapTest() {
		final IORuntimeException e = ExceptionUtil.wrap(new IOException(), IORuntimeException.class);
		Assertions.assertNotNull(e);
	}

	@Test
	public void getRootTest() {
		// 查找入口方法
		final StackTraceElement ele = ExceptionUtil.getRootStackElement();
		Assertions.assertEquals("main", ele.getMethodName());
	}

	@Test
	public void convertTest() {
		// RuntimeException e = new RuntimeException();
		final IOException ioException = new IOException();
		final IllegalArgumentException argumentException = new IllegalArgumentException(ioException);
		final IOException ioException1 = ExceptionUtil.convertFromOrSuppressedThrowable(argumentException, IOException.class, true);
		Assertions.assertNotNull(ioException1);
	}

	@Test
	public void bytesIntConvertTest(){
		final String s = Convert.toStr(12);
		final int integer = Convert.toInt(s);
		Assertions.assertEquals(12, integer);

		final byte[] bytes = Convert.intToBytes(12);
		final int i = Convert.bytesToInt(bytes);
		Assertions.assertEquals(12, i);
	}
}
