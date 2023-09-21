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

package org.dromara.hutool.extra.pinyin;

import org.dromara.hutool.extra.pinyin.engine.houbbpinyin.HoubbPinyinEngine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HoubbPinyinTest {

	final HoubbPinyinEngine engine = new HoubbPinyinEngine();

	@Test
	public void getFirstLetterTest(){
		final String result = engine.getFirstLetter("林海", "");
		Assertions.assertEquals("lh", result);
	}

	@Test
	public void getPinyinTest() {
		final String pinyin = engine.getPinyin("你好h", " ");
		Assertions.assertEquals("ni hao h", pinyin);
	}
}
