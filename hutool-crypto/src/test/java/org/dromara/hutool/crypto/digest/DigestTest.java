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

package org.dromara.hutool.crypto.digest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.dromara.hutool.core.io.IoUtil;
import org.dromara.hutool.core.util.CharsetUtil;

/**
 * 摘要算法单元测试
 * @author Looly
 *
 */
public class DigestTest {

	@Test
	public void digesterTest(){
		final String testStr = "test中文";

		final Digester md5 = new Digester(DigestAlgorithm.MD5);
		final String digestHex = md5.digestHex(testStr);
		Assertions.assertEquals("5393554e94bf0eb6436f240a4fd71282", digestHex);
	}

	@Test
	public void md5Test(){
		final String testStr = "test中文";

		final String md5Hex1 = DigestUtil.md5Hex(testStr);
		Assertions.assertEquals("5393554e94bf0eb6436f240a4fd71282", md5Hex1);

		final String md5Hex2 = DigestUtil.md5Hex(IoUtil.toStream(testStr, CharsetUtil.UTF_8));
		Assertions.assertEquals("5393554e94bf0eb6436f240a4fd71282", md5Hex2);
	}

	@Test
	public void md5WithSaltTest(){
		final String testStr = "test中文";

		final Digester md5 = new Digester(DigestAlgorithm.MD5);

		//加盐
		md5.setSalt("saltTest".getBytes());
		final String md5Hex1 = md5.digestHex(testStr);
		Assertions.assertEquals("762f7335200299dfa09bebbb601a5bc6", md5Hex1);
		final String md5Hex2 = md5.digestHex(IoUtil.toUtf8Stream(testStr));
		Assertions.assertEquals("762f7335200299dfa09bebbb601a5bc6", md5Hex2);

		//重复2次
		md5.setDigestCount(2);
		final String md5Hex3 = md5.digestHex(testStr);
		Assertions.assertEquals("2b0616296f6755d25efc07f90afe9684", md5Hex3);
		final String md5Hex4 = md5.digestHex(IoUtil.toUtf8Stream(testStr));
		Assertions.assertEquals("2b0616296f6755d25efc07f90afe9684", md5Hex4);
	}

	@Test
	public void sha1Test(){
		final String testStr = "test中文";

		final String sha1Hex1 = DigestUtil.sha1Hex(testStr);
		Assertions.assertEquals("ecabf586cef0d3b11c56549433ad50b81110a836", sha1Hex1);

		final String sha1Hex2 = DigestUtil.sha1Hex(IoUtil.toStream(testStr, CharsetUtil.UTF_8));
		Assertions.assertEquals("ecabf586cef0d3b11c56549433ad50b81110a836", sha1Hex2);
	}

	@Test
	public void hash256Test() {
		final String testStr = "Test中文";
		final String hex = DigestUtil.sha256Hex(testStr);
		Assertions.assertEquals(64, hex.length());
	}

	@Test
	public void hash512Test() {
		final String testStr = "Test中文";
		final String hex = DigestUtil.sha512Hex(testStr);
		Assertions.assertEquals(128, hex.length());
	}
}
