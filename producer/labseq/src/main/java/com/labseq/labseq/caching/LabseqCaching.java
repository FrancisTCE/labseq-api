package com.labseq.labseq.caching;

import java.util.HashMap;

public class LabseqCaching {
    
    private HashMap<Integer, Integer> cache;

	public LabseqCaching() {
		this.cache = new HashMap<>();
	}
   
    public void putCachedKey(int k, int n){
        this.cache.put(k, n);
    }

    public int getCachedKey(int k){
        return this.cache.get(k);
    }

    public boolean valueIsCached(int k){
        return this.cache.containsKey(k);
    }

}
