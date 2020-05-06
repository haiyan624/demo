package com.wq.algorithm.test;

import java.util.LinkedHashMap;
import java.util.Map;

class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {
	// 缓存大小
	private int capacity;
 
	public LRULinkedHashMap(int capacity) {
		// 构造时指定accessOrder为true,按get()时间排序
		super(16, 0.75f, true);
		this.capacity = capacity;
	}
 
	@Override
	public boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		// 如果添加缓存，即put()后size > capacity，就会移除链表队头，即最近最少使用的缓存项
		return size() > capacity;
	}
}