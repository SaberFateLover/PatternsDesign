package com.mzd.responsibilty;

/**
 * 结合马老师的视频，最后老师留了个作业，是让自己实现javax.servlet 中的Filter实现原理，
 * servlet中的Filter大致原理是：处理request，当把所有的request请求处理完毕后，再处理response;
 * 结合老师给的思路，主要是用递归的形式处理，一般递归是方法调用自己的方法，但是，Filter中的递归是不同
 * 方法的调用，所以和传统的递归还是有区别的。
 */
public class Main {

    public static void main(String[] args) {
        Request request =new Request();
        Response response =new Response();
        request.setReq("g123");
        response.setRes("e111112");
        BaseFilter fc= new StringFilterChain();
        Filter cf =new CharacterFilter();
        Filter sf =new SingFilter();
        fc.setFilters(cf).setFilters(sf).doFilter(request,response);
    }
}
