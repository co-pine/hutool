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

package org.dromara.hutool.core.thread;

import org.dromara.hutool.core.date.DateUtil;
import org.dromara.hutool.core.lang.Console;
import org.dromara.hutool.core.util.RandomUtil;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ConcurrencyTesterTest {

	@Test
	@Disabled
	public void concurrencyTesterTest() {
		final ConcurrencyTester tester = ThreadUtil.concurrencyTest(100, () -> {
			final long delay = RandomUtil.randomLong(100, 1000);
			ThreadUtil.sleep(delay);
			Console.log("{} test finished, delay: {}", Thread.currentThread().getName(), delay);
		});
		Console.log(tester.getInterval());
	}

	@Test
	@Disabled
	public void multiTest(){
		final ConcurrencyTester ct = new ConcurrencyTester(5);
		for(int i=0;i<3;i++){
			Console.log("开始执行第{}个",i);
			ct.test(() -> {
				// 需要并发测试的业务代码
				Console.log("当前执行线程：" + Thread.currentThread().getName()+" 产生时间 "+ DateUtil.formatNow());
				ThreadUtil.sleep(RandomUtil.randomInt(1000, 3000));
			});
		}
		Console.log("全部线程执行完毕 "+DateUtil.formatNow());
	}
}
