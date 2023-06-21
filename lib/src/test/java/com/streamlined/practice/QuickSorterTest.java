package com.streamlined.practice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QuickSorterTest {

	@Test
	@DisplayName("test sorting in ascending order")
	void testAscendingOrder() {

		var sampleData = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

		var toBeSorted = new ArrayList<>(sampleData);
		Collections.shuffle(toBeSorted);

		var sortedData = new QuickSorter<Integer>(Comparator.naturalOrder(), toBeSorted).getSorted();

		assertEquals(sampleData, sortedData);

	}

}
