package com.streamlined.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class QuickSorter<T> implements Sorter<T> {

	private final Comparator<T> comparator;
	private final List<T> data;

	public QuickSorter(Comparator<T> comparator, List<T> data) {
		this.comparator = comparator;
		this.data = data;
	}

	@Override
	public List<T> getSorted() {
		sort(0, data.size() - 1);
		return new ArrayList<>(data);
	}

	private void sort(int start, int finish) {
		if (start < finish) {
			int splitIndex = partitionData(start, finish);
			sort(start, splitIndex);
			sort(splitIndex + 1, finish);
		}
	}

	private int partitionData(int start, int finish) {
		int startIndex = start;
		int finishIndex = finish;

		T pivot = getPivot(start, finish);

		do {
			while (startIndex < finishIndex && comparator.compare(data.get(startIndex), pivot) < 0) {
				startIndex++;
			}

			while (startIndex < finishIndex && comparator.compare(pivot, data.get(finishIndex)) < 0) {
				finishIndex--;
			}

			if (startIndex < finishIndex) {
				swap(startIndex, finishIndex);
			}

		} while (startIndex < finishIndex);

		return startIndex - 1;
	}

	private void swap(int startIndex, int finishIndex) {
		T saved = data.get(startIndex);
		data.set(startIndex, data.get(finishIndex));
		data.set(finishIndex, saved);
	}

	private T getPivot(int start, int finish) {
		return data.get((start + finish + 1) / 2);
	}

}
