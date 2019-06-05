package com.mzd.responsibilty;

public class SingFilter implements Filter {

    @Override
    public boolean doFilter(Request request, Response response, FilterChain filterChain) {
        if(request.getReq().startsWith("g")){
            System.out.println("============request 起始字符判断通过 ==============");
            if (!filterChain.doFilter(request,response)) {
                return false;
            }
        }

        if(response.getRes().startsWith("e")){
            System.out.println("============ response 起始字符判断通过==============");
            if (!filterChain.doFilter(request,response)) {
                return false;
            }else {
                return true;
            }
        }else{
            return false;
        }
    }
}
