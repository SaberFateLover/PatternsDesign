package com.mzd.responsibilty;

public class CharacterFilter implements Filter {

    @Override
    public boolean doFilter(Request request, Response response, FilterChain filterChain) {
          if(request.getReq().length()>2){
              System.out.println("======request 的长度判断通过 =========");
              if (!filterChain.doFilter(request,response)) {
                  return false;
              }
          }

          if(response.getRes().length()>5){
              System.out.println("======response 的长度判断通过 =========");
              if (!filterChain.doFilter(request,response)) {
                  return false;
              }else {
                  return true;
              }
          }else {
              return false;
          }
    }


}
