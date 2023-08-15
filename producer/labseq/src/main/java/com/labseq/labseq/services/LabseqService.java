package com.labseq.labseq.services;

import com.labseq.labseq.caching.LabseqCaching;

public class LabseqService {

    LabseqCaching cache = new LabseqCaching();

    public int labSeq(int n){
        
        // if value is in cache, return the cached value
        if(cache.valueIsCached(n)) return cache.getCachedKey(n);
        
        if(n <= 3) return (n % 2 == 0) ? 0 : 1;
        
        int newValue = labSeq(n - 4) + labSeq(n - 3);
        
        cache.putCachedKey(n, newValue);

        return newValue;
    }
    
}
