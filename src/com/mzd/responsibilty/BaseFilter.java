package com.mzd.responsibilty;

import java.util.ArrayList;
import java.util.List;

public  abstract  class BaseFilter implements FilterChain {
    protected int index;
    protected  int pos=-1;
    protected List<Filter> filters =new ArrayList<>();
    public  FilterChain  setFilters(Filter filter){
         filters.add(filter);
         index =filters.size();
         return this;
    }




}
