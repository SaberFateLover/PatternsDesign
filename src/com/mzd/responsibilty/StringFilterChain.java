package com.mzd.responsibilty;


public class StringFilterChain extends BaseFilter {



    @Override
    public boolean doFilter(Request request, Response response) {
             pos++;
        for (;pos< index;) {
            if(!filters.get(pos).doFilter(request,response,this))
                return false;
        }
        return true;
    }

}
