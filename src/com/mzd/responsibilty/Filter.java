package com.mzd.responsibilty;

public interface Filter {

     boolean doFilter(Request request,Response response, FilterChain filterChain);

}
