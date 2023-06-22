package com.streamlined.practice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QuickSorterTest {

	@Test
	@DisplayName("test sorting in ascending order")
	void testAscendingOrder() {

		final int start = 1;
		final int finish = 10_000;
		var sampleData = IntStream.range(start, finish).mapToObj(Integer::valueOf).toList();

		var toBeSorted = new ArrayList<>(sampleData);
		Collections.shuffle(toBeSorted);

		var sortedData = new QuickSorter<Integer>(Comparator.naturalOrder(), toBeSorted).getSorted();

		assertEquals(sampleData, sortedData);

	}

	@Test
	@DisplayName("test sorting in descending order")
	void testDescendingOrder() {

		final int start = 1;
		final int finish = 10_000;
		var sampleData = IntStream.range(start, finish).map(x -> finish - x).mapToObj(Integer::valueOf).toList();

		var toBeSorted = new ArrayList<>(sampleData);
		Collections.shuffle(toBeSorted);

		var sortedData = new QuickSorter<Integer>(Comparator.reverseOrder(), toBeSorted).getSorted();

		assertEquals(sampleData, sortedData);

	}

}
