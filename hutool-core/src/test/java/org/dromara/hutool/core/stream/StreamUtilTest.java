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

package org.dromara.hutool.core.stream;

import org.dromara.hutool.core.collection.ListUtil;
import org.dromara.hutool.core.collection.set.SetUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamUtilTest {

	@Test
	public void ofTest(){
		final Stream<Integer> stream = StreamUtil.of(2, x -> x * 2, 4);
		final String result = stream.collect(CollectorUtil.joining(","));
		Assertions.assertEquals("2,4,8,16", result);
	}

	// === iterator ===
	@Test
	public void streamTestNullIterator() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> StreamUtil.ofIter((Iterator<Object>) null));
	}

	@SuppressWarnings({"RedundantOperationOnEmptyContainer", "RedundantCollectionOperation"})
	@Test
	public void streamTestEmptyListToIterator() {
		assertStreamIsEmpty(StreamUtil.ofIter(new ArrayList<>().iterator()));
	}

	@Test
	public void streamTestEmptyIterator() {
		assertStreamIsEmpty(StreamUtil.ofIter(Collections.emptyIterator()));
	}

	@Test
	public void streamTestOrdinaryIterator() {
		final List<Integer> arrayList = ListUtil.of(1, 2, 3);
		Assertions.assertArrayEquals(new Integer[]{1, 2, 3}, StreamUtil.ofIter(arrayList.iterator()).toArray());

		final HashSet<Integer> hashSet = SetUtil.of(1, 2, 3);
		Assertions.assertEquals(hashSet, StreamUtil.ofIter(hashSet.iterator()).collect(Collectors.toSet()));
	}

	void assertStreamIsEmpty(final Stream<?> stream) {
		Assertions.assertNotNull(stream);
		Assertions.assertEquals(0, stream.toArray().length);
	}
	// ================ stream test end ================
}
