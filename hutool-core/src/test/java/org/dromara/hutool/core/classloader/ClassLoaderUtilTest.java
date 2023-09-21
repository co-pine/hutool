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

package org.dromara.hutool.core.classloader;

import org.dromara.hutool.core.map.Dict;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClassLoaderUtilTest {

	@Test
	void getCallerClassLoaderTest() {
		final ClassLoader callerClassLoader = ClassLoaderUtil.getCallerClassLoader();
		Assertions.assertEquals(ClassLoaderUtilTest.class.getClassLoader(), callerClassLoader);
	}

	@Test
	public void isPresentTest() {
		final boolean present = ClassLoaderUtil.isPresent("org.dromara.hutool.core.classloader.ClassLoaderUtil");
		Assertions.assertTrue(present);
	}

	@Test
	public void loadClassTest() {
		String name = ClassLoaderUtil.loadClass("java.lang.Thread.State").getName();
		Assertions.assertEquals("java.lang.Thread$State", name);

		name = ClassLoaderUtil.loadClass("java.lang.Thread$State").getName();
		Assertions.assertEquals("java.lang.Thread$State", name);
	}

	@Test
	public void loadArrayClassTest(){
		final String s = Dict[].class.getName();

		final Class<Object> objectClass = ClassLoaderUtil.loadClass(s);
		Assertions.assertEquals(Dict[].class, objectClass);
	}

	@Test
	public void loadInnerClassTest() {
		String name = ClassLoaderUtil.loadClass("org.dromara.hutool.core.classloader.ClassLoaderUtilTest.A").getName();
		Assertions.assertEquals("org.dromara.hutool.core.classloader.ClassLoaderUtilTest$A", name);
		name = ClassLoaderUtil.loadClass("org.dromara.hutool.core.classloader.ClassLoaderUtilTest.A.B").getName();
		Assertions.assertEquals("org.dromara.hutool.core.classloader.ClassLoaderUtilTest$A$B", name);
	}

	@SuppressWarnings("unused")
	private static class A{
		private static class B{

		}
	}
}
