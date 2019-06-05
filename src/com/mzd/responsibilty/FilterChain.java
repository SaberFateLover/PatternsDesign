package com.mzd.responsibilty;

import java.util.ArrayList;
import java.util.List;

public interface FilterChain {

     boolean doFilter(Request request, Response response);
    FilterChain  setFilters(Filter filter);

}
