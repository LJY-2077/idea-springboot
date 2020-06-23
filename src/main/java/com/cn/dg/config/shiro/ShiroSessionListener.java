package com.cn.dg.config.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: session监听
 * @Auther: zcz
 * @create 2020/4/16 11:51
 */
@Component
public class ShiroSessionListener implements SessionListener {
    @Override
    public void onStart(Session session) {
        //会话创建，在线人数加一
        System.out.println("在线人数："+ AuthRealm.sessionCount);
    }

    /**
     * 退出会话时触发
     *
     * @param session
     */
    @Override
    public void onStop(Session session) {
        System.out.println("---------session退出---------");
        //会话退出,在线人数减一
        AuthRealm.sessionCount.decrementAndGet();
    }

    /**
     * 会话过期时触发
     *
     * @param session
     */
    @Override
    public void onExpiration(Session session) {
        System.out.println("---------session失效---------");
        //会话过期,在线人数减一
        AuthRealm.sessionCount.decrementAndGet();
    }

    /**
     * 获取在线人数使用
     *
     * @return
     */
    public AtomicInteger getSessionCount() {
        return AuthRealm.sessionCount;
    }
}
