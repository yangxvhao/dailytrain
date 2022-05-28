package com.yangxvhao.demo.proxy;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.util.BitSet;

/**
 * 布隆过滤
 *
 * @author yangxuhao
 * @date 2019-12-06 11:23.
 */
public class BloomFilterDemo {
    private static final int DEFAULT_SIZE = 1 << 10;

    private static final BitSet bitSet = new BitSet(DEFAULT_SIZE);

    class BloomHash{
        private int cap;
        private int seed;

        public BloomHash(int cap, int seed) {
            this.cap = cap;
            this.seed = seed;
        }

        public int hash(Object value){
            int hash;
            return value == null ? 0 : ((hash = value.hashCode()) ^ hash >>> 16) ;
        }
    }

    public static void main(String[] args) {
        BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), 10000);
        bloomFilter.put(1);
        bloomFilter.put(2);
        bloomFilter.put(3);

        System.out.println(bloomFilter.mightContain(1));

        String s = "123";
        System.out.println(s.substring(0, 3));
    }
}
