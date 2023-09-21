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

package org.dromara.hutool.json.jwt;

import org.dromara.hutool.core.date.DateUtil;
import org.dromara.hutool.crypto.KeyUtil;
import org.dromara.hutool.json.jwt.signers.AlgorithmUtil;
import org.dromara.hutool.json.jwt.signers.JWTSigner;
import org.dromara.hutool.json.jwt.signers.JWTSignerUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JWTSignerTest {

	@Test
	public void hs256Test(){
		final String id = "hs256";
		final JWTSigner signer = JWTSignerUtil.createSigner(id, KeyUtil.generateKey(AlgorithmUtil.getAlgorithm(id)));
		Assertions.assertEquals(AlgorithmUtil.getAlgorithm(id), signer.getAlgorithm());

		signAndVerify(signer);
	}

	@Test
	public void hs256Test2(){
		final JWTSigner signer = JWTSignerUtil.hs256("123456".getBytes());

		signAndVerify(signer);
	}

	@Test
	public void hs384Test(){
		final String id = "hs384";
		final JWTSigner signer = JWTSignerUtil.createSigner(id, KeyUtil.generateKey(AlgorithmUtil.getAlgorithm(id)));
		Assertions.assertEquals(AlgorithmUtil.getAlgorithm(id), signer.getAlgorithm());

		signAndVerify(signer);
	}

	@Test
	public void hs512Test(){
		final String id = "hs512";
		final JWTSigner signer = JWTSignerUtil.createSigner(id, KeyUtil.generateKey(AlgorithmUtil.getAlgorithm(id)));
		Assertions.assertEquals(AlgorithmUtil.getAlgorithm(id), signer.getAlgorithm());

		signAndVerify(signer);
	}

	@Test
	public void rs256Test(){
		final String id = "rs256";
		final JWTSigner signer = JWTSignerUtil.createSigner(id, KeyUtil.generateKeyPair(AlgorithmUtil.getAlgorithm(id)));
		Assertions.assertEquals(AlgorithmUtil.getAlgorithm(id), signer.getAlgorithm());

		signAndVerify(signer);
	}

	@Test
	public void rs384Test(){
		final String id = "rs384";
		final JWTSigner signer = JWTSignerUtil.createSigner(id, KeyUtil.generateKeyPair(AlgorithmUtil.getAlgorithm(id)));
		Assertions.assertEquals(AlgorithmUtil.getAlgorithm(id), signer.getAlgorithm());

		signAndVerify(signer);
	}

	@Test
	public void rs512Test(){
		final String id = "rs512";
		final JWTSigner signer = JWTSignerUtil.createSigner(id, KeyUtil.generateKeyPair(AlgorithmUtil.getAlgorithm(id)));
		Assertions.assertEquals(AlgorithmUtil.getAlgorithm(id), signer.getAlgorithm());

		signAndVerify(signer);
	}

	@Test
	public void es256Test(){
		final String id = "es256";
		final JWTSigner signer = JWTSignerUtil.createSigner(id, KeyUtil.generateKeyPair(AlgorithmUtil.getAlgorithm(id)));
		Assertions.assertEquals(AlgorithmUtil.getAlgorithm(id), signer.getAlgorithm());

		signAndVerify(signer);
	}

	@Test
	public void es384Test(){
		final String id = "es384";
		final JWTSigner signer = JWTSignerUtil.createSigner(id, KeyUtil.generateKeyPair(AlgorithmUtil.getAlgorithm(id)));
		Assertions.assertEquals(AlgorithmUtil.getAlgorithm(id), signer.getAlgorithm());

		signAndVerify(signer);
	}

	@Test
	public void es512Test(){
		final String id = "es512";
		final JWTSigner signer = JWTSignerUtil.createSigner(id, KeyUtil.generateKeyPair(AlgorithmUtil.getAlgorithm(id)));
		Assertions.assertEquals(AlgorithmUtil.getAlgorithm(id), signer.getAlgorithm());

		signAndVerify(signer);
	}

	@Test
	public void ps256Test(){
		final String id = "ps256";
		final JWTSigner signer = JWTSignerUtil.createSigner(id, KeyUtil.generateKeyPair(AlgorithmUtil.getAlgorithm(id)));
		Assertions.assertEquals(AlgorithmUtil.getAlgorithm(id), signer.getAlgorithm());

		signAndVerify(signer);
	}

	@Test
	public void ps384Test(){
		final String id = "ps384";
		final JWTSigner signer = JWTSignerUtil.createSigner(id, KeyUtil.generateKeyPair(AlgorithmUtil.getAlgorithm(id)));
		Assertions.assertEquals(AlgorithmUtil.getAlgorithm(id), signer.getAlgorithm());

		signAndVerify(signer);
	}

	@Test
	public void hmd5Test(){
		final String id = "hmd5";
		final JWTSigner signer = JWTSignerUtil.createSigner(id, KeyUtil.generateKey(AlgorithmUtil.getAlgorithm(id)));
		Assertions.assertEquals(AlgorithmUtil.getAlgorithm(id), signer.getAlgorithm());

		signAndVerify(signer);
	}

	@Test
	public void hsha1Test(){
		final String id = "hsha1";
		final JWTSigner signer = JWTSignerUtil.createSigner(id, KeyUtil.generateKey(AlgorithmUtil.getAlgorithm(id)));
		Assertions.assertEquals(AlgorithmUtil.getAlgorithm(id), signer.getAlgorithm());

		signAndVerify(signer);
	}

	@Test
	public void sm4cmacTest(){
		final String id = "sm4cmac";
		final JWTSigner signer = JWTSignerUtil.createSigner(id, KeyUtil.generateKey(AlgorithmUtil.getAlgorithm(id)));
		Assertions.assertEquals(AlgorithmUtil.getAlgorithm(id), signer.getAlgorithm());

		signAndVerify(signer);
	}

	@Test
	public void rmd2Test(){
		final String id = "rmd2";
		final JWTSigner signer = JWTSignerUtil.createSigner(id, KeyUtil.generateKeyPair(AlgorithmUtil.getAlgorithm(id)));
		Assertions.assertEquals(AlgorithmUtil.getAlgorithm(id), signer.getAlgorithm());

		signAndVerify(signer);
	}

	@Test
	public void rmd5Test(){
		final String id = "rmd5";
		final JWTSigner signer = JWTSignerUtil.createSigner(id, KeyUtil.generateKeyPair(AlgorithmUtil.getAlgorithm(id)));
		Assertions.assertEquals(AlgorithmUtil.getAlgorithm(id), signer.getAlgorithm());

		signAndVerify(signer);
	}

	@Test
	public void rsha1Test(){
		final String id = "rsha1";
		final JWTSigner signer = JWTSignerUtil.createSigner(id, KeyUtil.generateKeyPair(AlgorithmUtil.getAlgorithm(id)));
		Assertions.assertEquals(AlgorithmUtil.getAlgorithm(id), signer.getAlgorithm());

		signAndVerify(signer);
	}

	@Test
	public void dnoneTest(){
		final String id = "dnone";
		final JWTSigner signer = JWTSignerUtil.createSigner(id, KeyUtil.generateKeyPair(AlgorithmUtil.getAlgorithm(id)));
		Assertions.assertEquals(AlgorithmUtil.getAlgorithm(id), signer.getAlgorithm());

		signAndVerify(signer);
	}

	@Test
	public void dsha1Test(){
		final String id = "dsha1";
		final JWTSigner signer = JWTSignerUtil.createSigner(id, KeyUtil.generateKeyPair(AlgorithmUtil.getAlgorithm(id)));
		Assertions.assertEquals(AlgorithmUtil.getAlgorithm(id), signer.getAlgorithm());

		signAndVerify(signer);
	}

	@Test
	public void enoneTest(){
		final String id = "enone";
		final JWTSigner signer = JWTSignerUtil.createSigner(id, KeyUtil.generateKeyPair(AlgorithmUtil.getAlgorithm(id)));
		Assertions.assertEquals(AlgorithmUtil.getAlgorithm(id), signer.getAlgorithm());

		signAndVerify(signer);
	}

	@Test
	public void esha1Test(){
		final String id = "esha1";
		final JWTSigner signer = JWTSignerUtil.createSigner(id, KeyUtil.generateKeyPair(AlgorithmUtil.getAlgorithm(id)));
		Assertions.assertEquals(AlgorithmUtil.getAlgorithm(id), signer.getAlgorithm());

		signAndVerify(signer);
	}

	private static void signAndVerify(final JWTSigner signer){
		final JWT jwt = JWT.of()
				.setPayload("sub", "1234567890")
				.setPayload("name", "looly")
				.setPayload("admin", true)
				.setExpiresAt(DateUtil.tomorrow())
				.setSigner(signer);

		final String token = jwt.sign();
		Assertions.assertTrue(JWT.of(token).verify(signer));
	}
}
